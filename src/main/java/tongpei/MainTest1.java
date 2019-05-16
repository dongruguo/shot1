package tongpei;

public class MainTest1 {
	
	public static void  get() {
		TongpeiClass<String> tt = new TongpeiClass<String>();
		tt.set("sssss");
		Integer aa = tt.getF(123);
		System.out.println(aa);
		System.out.println(tt.get());
	}
	
	public static void main(String[] args) {
		get();
	}

}
