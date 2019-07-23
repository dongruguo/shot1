package com.wwd.main.lucene;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.ansj.lucene7.AnsjAnalyzer;
import org.ansj.lucene7.AnsjAnalyzer.TYPE;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class FirstLucene {
	
	@Test
	public void test() throws IOException {
		Directory dire = FSDirectory.open(new File("D:\\lucene\\index").toPath());
		// 创建使用的分词器
		Analyzer analyzer = new AnsjAnalyzer(TYPE.query_ansj);
		
		
		// 索引配置对象
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(dire, config);
		Document doc = new Document(); 
		
		String text = "其中第二个相比第一个多了相关的语汇信息，便于我们进行分词";
		Field nameField = new TextField("fileName",text, Store.YES);
		doc.add(nameField);
		writer.addDocument(doc);
		writer.close();
		/*
		 * File file = new File("D:\\lucene\\eclipseData"); File[] files =
		 * file.listFiles();
		 *  for(File f:files) { Document doc = new Document(); 
		 *  String file_name = f.getName(); 
		 *  Field nameField = new TextField("fileName",file_name, Store.YES);
		 * 
		 * Long file_size = FileUtils.sizeOf(f); Field sizeF = new
		 * StoredField("fileSize",file_size);
		 * 
		 * String file_path = f.getPath(); Field pathFiled = new StoredField("filePath",
		 * file_path);
		 * 
		 * String file_content = FileUtils.readFileToString(f); Field contengF = new
		 * TextField("fileContent", file_content,Store.NO);
		 * 
		 * doc.add(nameField);doc.add(sizeF);doc.add(pathFiled);doc.add(contengF);
		 * writer.addDocument(doc);
		 * 
		 * }
		 */
		writer.close();
	}
	
	@Test
	public void search() throws IOException, ParseException {
		Directory dire = FSDirectory.open(new File("D:\\lucene\\index").toPath());
		
		IndexReader reader = DirectoryReader.open(dire);
		IndexSearcher search = new IndexSearcher(reader);
		
		/*
		 * PhraseQuery.Builder builder=new PhraseQuery.Builder(); Term t1=new
		 * Term("fileName","第一"); Term t2=new Term("fileName","第二"); builder.add(t1);
		 * builder.add(t2); // builder.setSlop(0); PhraseQuery query=builder.build();
		 */
		Query query = new WildcardQuery(new Term("fileName","第一"));
		/*
		 * Analyzer analyzer = new AnsjAnalyzer(TYPE.query_ansj); QueryParser parser=new
		 * QueryParser("fileName", analyzer); Query query=parser.parse("第二第一");
		 */
		
		TopDocs docs = search.search(query, 3);
		ScoreDoc[] doc = docs.scoreDocs;
		for(ScoreDoc d:doc) {
			int sc = d.doc;
			Document docu = search.doc(sc);
			String fileName = docu.get("fileName");
			System.out.println("fileName:"+fileName+"");
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
			
		}
	}
	
	@Test
	public void AnnalyTest() {
		 try {  
	            // 要处理的文本  
	            String text = "lucene分析器使用分词器和过滤器构成一个“管道”，文本在流经这个管道后成为可以进入索引的最小单位，因此，一个标准的分析器有两个部分组成，一个是分词器tokenizer,它用于将文本按照规则切分为一个个可以进入索引的最小单位。另外一个是TokenFilter，它主要作用是对切出来的词进行进一步的处理（如去掉敏感词、英文大小写转换、单复数处理）等。lucene中的Tokenstram方法首先创建一个tokenizer对象处理Reader对象中的流式文本，然后利用TokenFilter对输出流进行过滤处理";  
	  
	            // 自定义停用词  
	            String[] self_stop_words = { "的", "了", "呢", "，", "0", "：", ",", "是", "流" };  
	            CharArraySet cas = new CharArraySet(0, true);  
	            for (int i = 0; i < self_stop_words.length; i++) {  
	                cas.add(self_stop_words[i]);  
	            }  
	  
	            // 中英文混合分词器(其他几个分词器对中文的分析都不行)  
	            SimpleAnalyzer sca = new SimpleAnalyzer();//SmartChineseAnalyzer  
	            
	            TokenStream ts = sca.tokenStream("field", text);  
	            CharTermAttribute ch = ts.addAttribute(CharTermAttribute.class);  
	  
	            ts.reset();  
	            while (ts.incrementToken()) {  
	                System.out.println(ch.toString());  
	            }  
	            ts.end();  
	            ts.close();  
	        } catch (Exception ex) {  
	            ex.printStackTrace();  
	        }  
	}

}
