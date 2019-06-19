import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String str = "<br/>|<Br/>sccsds<br/>|<BR/><br/>|<BR/><br/>|<BR/><br/>|<BR/>";
		str =  str.replaceAll("<br/>|<BR/>", "1212");
		System.out.println(str);
	}
}
