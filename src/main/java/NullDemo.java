
public class NullDemo {
	public String age ;
	public NullDemo() {
		
	}
	public static void main(String[] args) {
		NullDemo  nd= new NullDemo();
		if( !(nd.age).equals("") && nd.age != null ) {
			System.out.println("--------------");
		}
	}

}
