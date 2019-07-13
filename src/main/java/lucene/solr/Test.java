package lucene.solr;

import java.util.HashMap;

import org.ansj.lucene7.AnsjAnalyzer;

public class Test {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<>();
		map.put("stop","library/stop.dic");
		AnsjAnalyzer factory = new AnsjAnalyzer(map);
		factory.getTokenizer(null,map);
	}

}
