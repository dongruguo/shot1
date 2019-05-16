
public class DemoTest {
public static void main(String[] args) {
	Base1 base = new Sub();
	base.doAnyThing();
	base.doSomeThing();
}
	
	

}

class Base1{
	public static void doSomeThing() {
		System.out.println("------Base doSomeThing-------");
	}
	
	public void doAnyThing() {
		System.out.println("------Base doAnyThing-------");
	}
}

class Sub extends Base1{
	public static void doSomeThing() {
		System.out.println("------Base doSomeThing-------");
	}
	
	@Override
	public void doAnyThing() {
		System.out.println("------Base doAnyThing-------");
	}
}