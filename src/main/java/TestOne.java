
public class TestOne extends Thread{
	private String nickName;
	private String lastName;
	public void Test(Object obj) {
		TestOne one = (TestOne)obj;
		System.out.println(one.lastName);
		System.out.println(one.nickName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public static void main(String[] args) {
		/*
		 * TestOne one = new TestOne(); one.setLastName("lastName");
		 * one.setNickName("nickName"); one.Test(one);
		 */
		 System.out.println(""+Runtime.getRuntime().availableProcessors());
		
	}

}
