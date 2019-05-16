package xiancheng.ThreadLocal;


public class DeepClone implements Cloneable{
	private SeraTest seraTest;
	private String sub;
	public SeraTest getSeraTest() {
		return seraTest;
	}
	public void setSeraTest(SeraTest seraTest) {
		this.seraTest = seraTest;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	@Override 
	public Object clone() throws CloneNotSupportedException {
		DeepClone dp =(DeepClone) super.clone();
		dp.setSeraTest((SeraTest)seraTest.clone());
		return dp;
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		SeraTest s = new SeraTest();
		s.setAge(111);
		DeepClone d1 = new DeepClone();
		d1.setSeraTest(s);
		DeepClone d2 = d1;
		d2.getSeraTest().setAge(123);
		System.out.println(d1.getSeraTest().getAge());
		System.out.println(d2.getSeraTest().getAge());
		
		
	}

}
