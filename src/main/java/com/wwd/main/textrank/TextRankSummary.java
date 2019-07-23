package com.wwd.main.textrank;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;

import java.util.*;

/**
 * TextRank 自动摘要
 * @author hankcs
 */
public class TextRankSummary
{
    /**
     * 阻尼系数（ＤａｍｐｉｎｇＦａｃｔｏｒ），一般取值为0.85
     */
    final double d = 0.85f;
    /**
     * 最大迭代次数
     */
    final int max_iter = 200;
    final double min_diff = 0.001f;
    /**
     * 文档句子的个数
     */
    int D;
    /**
     * 拆分为[句子[单词]]形式的文档
     */
    List<List<String>> docs;
    /**
     * 排序后的最终结果 score <-> index
     */
    TreeMap<Double, Integer> top;

    /**
     * 句子和其他句子的相关程度
     */
    double[][] weight;
    /**
     * 该句子和其他句子相关程度之和
     */
    double[] weight_sum;
    /**
     * 迭代之后收敛的权重
     */
    double[] vertex;

    /**
     * BM25相似度
     */
    BM25 bm25;

    public TextRankSummary(List<List<String>> docs)
    {
        this.docs = docs;
        bm25 = new BM25(docs);
        D = docs.size();
        weight = new double[D][D];
        weight_sum = new double[D];
        vertex = new double[D];
        top = new TreeMap<Double, Integer>(Collections.reverseOrder());
        solve();
    }

    private void solve()
    {
        int cnt = 0;
        for (List<String> sentence : docs)
        {
            double[] scores = bm25.simAll(sentence);
//            System.out.println(Arrays.toString(scores));
            weight[cnt] = scores;
            weight_sum[cnt] = sum(scores) - scores[cnt]; // 减掉自己，自己跟自己肯定最相似
            vertex[cnt] = 1.0;
            ++cnt;
        }
        for (int _ = 0; _ < max_iter; ++_)
        {
            double[] m = new double[D];
            double max_diff = 0;
            for (int i = 0; i < D; ++i)
            {
                m[i] = 1 - d;
                for (int j = 0; j < D; ++j)
                {
                    if (j == i || weight_sum[j] == 0) continue;
                    m[i] += (d * weight[j][i] / weight_sum[j] * vertex[j]);
                }
                double diff = Math.abs(m[i] - vertex[i]);
                if (diff > max_diff)
                {
                    max_diff = diff;
                }
            }
            vertex = m;
            if (max_diff <= min_diff) break;
        }
        // 我们来排个序吧
        for (int i = 0; i < D; ++i)
        {
            top.put(vertex[i], i);
        }
    }

    /**
     * 获取前几个关键句子
     * @param size 要几个
     * @return 关键句子的下标
     */
    public int[] getTopSentence(int size)
    {
        Collection<Integer> values = top.values();
        size = Math.min(size, values.size());
        int[] indexArray = new int[size];
        Iterator<Integer> it = values.iterator();
        for (int i = 0; i < size; ++i)
        {
            indexArray[i] = it.next();
        }
        return indexArray;
    }

    /**
     * 简单的求和
     * @param array
     * @return
     */
    private static double sum(double[] array)
    {
        double total = 0;
        for (double v : array)
        {
            total += v;
        }
        return total;
    }

    public static void main(String[] args)
    {
        String document = "金安区政协反映：居民住宅小区物业管理服务质量的好坏与城市基础网格的稳定及居民幸福指数息息相关。当前，街道社区定期对小区开展集中整治行动不仅人力、物力难以保障，而且难以形成长效机制，达到预期效果。近年来，我市各住宅小区虽采用不同方式实施了物业管理，但均存在诸多弊病，给居民日常生活带来了诸多不便，主要体现在：\r\n" + 
        		"　　\r\n" + 
        		"　　一是服务质量低，管理能力差。有些小区的物业管理形同虚设，部分物业服务企业的经营管理模式严重滞后，企业的市场意识、风险意识、法律意识、资本经营意识、创新意识、品牌意识和产品保护意识都十分薄弱。二是观念陈旧，服务不主动。部分物业遇到问题推来推去，不予及时解决；物业企业缺少一批懂技术、会管理、善经营、勇于开拓创新的企业家。部分物业服务企业人员素质不高，服务不规范。三是物业和业主的矛盾重重。部分小区居民欠费不交，管理出现恶性循环。四是管理体制不理顺。成立的业主委员会没有发挥业主与物业企业之间桥梁与纽带的作用，服务质量的监管工作没有真正地开展起来，对物业服务与公共财务的收支疏于监督。\r\n" + 
        		"　　\r\n" + 
        		"　　为此，建议：\r\n" + 
        		"　　\r\n" + 
        		"　　一要优化物业准入模式。在物业公司准入方面，严格实行公开招投标，选出几家优质的物业公司。同时，召集业主代表参与竞聘大会，竞聘采取公开演讲的方式，让入选的物业公司在有限时间内，借助PPT分别对自己的服务理念、管理方式、人员配备、收费标准、活动开展等各个方面向参会的业主代表们一一展示。最后通过民主投票的方式，让业主代表选出心仪的物业公司。\r\n" + 
        		"　　\r\n" + 
        		"　　二要加强物业监管力度。充分发挥街道和社区在物业管理中的重要作用，建立健全物业管理的有关制度，将住宅小区物业监管纳入各社区工作的职责范围，社区工作人员分片联系各小区，指导小区业主委员会的成立与调整，指导小区业主委员会日常工作开展，引导业主委员会积极履职。社区民警和相关部门都要积极予以配合。统一制定物业服务管理合同，街道社区督促物业公司定期对服务内容、标准、收费依据及用途进行公示；建立物业公司和从业人员信用档案，增强物业公司及从业人员服务意识。\r\n" + 
        		"　　\r\n" + 
        		"　　三要完善物业奖惩机制。进一步建立完善物业公司综合评价及奖惩机制，针对小区环境建设、安全管理、综合治理等方面，对物业公司实行评级、评星制度，与所能够服务管理的小区规模、档次、数量及收费标准挂钩。引入物业管理服务企业的淘汰机制，对一些服务质量差、群众评议差、整改屡不到位的物业管理公司要予以清退";
        System.out.println(TextRankSummary.getTopSentenceList(document, 5));
    }

    /**
     * 将文章分割为句子
     * @param document
     * @return
     */
    static List<String> spiltSentence(String document)
    {
        List<String> sentences = new ArrayList<String>();
        if (document == null) return sentences;
        for (String line : document.split("[\r\n]"))
        {
            line = line.trim();
            if (line.length() == 0) continue;
            for (String sent : line.split("[，,。:：“”？?！!；;]"))
            {
                sent = sent.trim();
                if (sent.length() == 0) continue;
                sentences.add(sent);
            }
        }

        return sentences;
    }

    /**
     * 是否应当将这个term纳入计算，词性属于名词、动词、副词、形容词
     * @param term
     * @return 是否应当
     */
    public static boolean shouldInclude(Term term)
    {
        return CoreStopWordDictionary.shouldInclude(term);
    }

    /**
     * 一句话调用接口
     * @param document 目标文档
     * @param size 需要的关键句的个数
     * @return 关键句列表
     */
    public static List<String> getTopSentenceList(String document, int size)
    {
        List<String> sentenceList = spiltSentence(document);
        List<List<String>> docs = new ArrayList<List<String>>();
        for (String sentence : sentenceList)
        {
            List<Term> termList = HanLP.segment(sentence);
            List<String> wordList = new LinkedList<String>();
            for (Term term : termList)
            {
                if (shouldInclude(term))
                {
                    wordList.add(term.word);
                }
            }
            docs.add(wordList);
        }
        TextRankSummary textRankSummary = new TextRankSummary(docs);
        int[] topSentence = textRankSummary.getTopSentence(size);
        List<String> resultList = new LinkedList<String>();
        for (int i : topSentence)
        {
            resultList.add(sentenceList.get(i));
        }
        return resultList;
    }
}