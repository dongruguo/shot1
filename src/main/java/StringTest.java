
class St{
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
public class StringTest {
	public static void changeMe(StringBuffer str) {
		//str.setName("changed");
		str .append("abcabc");
	}
	public static void main(String[] args) {
	/*	String str1 = new String("abc");
		String str2 = new String("abc");
		*/
		/*St stt = new St();
		stt.setName("chushi");
		System.out.println(stt.getName());
		changeMe(stt);
		System.out.println(stt.getName());*/
		StringBuffer sb = new StringBuffer("1111");
		System.out.println(sb);
		changeMe(sb);
		System.out.println(sb.toString());
	}

}
