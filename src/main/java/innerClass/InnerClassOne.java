/**
 * @author: 王卫东  
 * @date:   2019年1月31日 下午5:25:47
 */
package innerClass;

/** 成员内部类
 * @author: 王卫东  
 * @date:   2019年1月31日 下午5:25:47
 */
public class InnerClassOne {
	private String name;
	public void outMethod() {
		System.out.println("outMethod()");
	}
	public InnerClassOne(String name) {
		this.name = name;
	}
	
	class InnerClass{
		private String name="InnerClass";
		public void innerMethod(){
			outMethod();
			System.out.println(InnerClassOne.this.name);
		}
	}
	
	public static void main(String[] args) {
		InnerClassOne out = new InnerClassOne("out");
		
		InnerClassOne.InnerClass inner =  out.new InnerClass();
		out = null;
		inner.innerMethod();
	}
	
}
