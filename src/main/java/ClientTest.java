public class ClientTest implements Cloneable{
	public static void main(String[] args) {
		System.out.println(AppleTest.home.getIi());
		
	}
	public static int i=10;
	public static void dd() {
		System.out.println(i);
	}
}

enum AppleTest{
	mobile("one",1),home("home",2);
	
	private String name;
	
	private int ii;

	private AppleTest(String name,int ii){
		this.setName(name);
		this.setIi(ii);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIi() {
		return ii;
	}

	public void setIi(int ii) {
		this.ii = ii;
	}
	
	
}

