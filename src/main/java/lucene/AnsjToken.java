package lucene;

import java.io.IOException;

import org.ansj.lucene7.AnsjAnalyzer;
import org.ansj.lucene7.AnsjAnalyzer.TYPE;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class AnsjToken {

	
	public static void main(String[] args) {
		Analyzer analyzer = new AnsjAnalyzer(TYPE.query_ansj);
		String text = "其中第二个相比第一个多了相关的语汇信息，便于我们进行分词";
		
		TokenStream stream = analyzer.tokenStream("field", text);
		CharTermAttribute termArr = stream.addAttribute(CharTermAttribute.class);
		try {
			stream.reset();
			while(stream.incrementToken()) {
				System.out.println(termArr.toString());
			}
			stream.end();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ansjToken() {
		
		
	}
}
