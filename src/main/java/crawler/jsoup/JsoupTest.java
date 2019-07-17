package crawler.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {
	@Test
	public void test() throws IOException {
		Document doc = Jsoup.connect("https://www.yiibai.com/").get();
		Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
		for (Element image : images) {  
		    System.out.println("src : " + image.attr("src"));  
		    System.out.println("height : " + image.attr("height"));  
		    System.out.println("width : " + image.attr("width"));  
		    System.out.println("alt : " + image.attr("alt"));  
		}

	}
	
}
