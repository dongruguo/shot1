package xiancheng.ThreadLocal;

class Demo{
	public String name;
	
}
public class Test {
	private final String name;
	
	private final Demo demo;
	
	public Test(){
		name = "ss";
		demo = null;
	}
	public Test(Demo demo) {
		name = "ss";
		this.demo = demo;
	}
	

	ThreadLocal<Name> longLocal = new ThreadLocal<Name>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();

	public void set(Name name) {
		longLocal.set(name);
		stringLocal.set(Thread.currentThread().getName());
		
	}

	public String getLong() {
		return longLocal.get().name;
	}

	public String getString() {
		return stringLocal.get();
	}

	public static void main(String[] args) throws InterruptedException {
		
		Demo demo = new Demo();
		Test t1 = new Test(demo);
		System.out.println(t1.demo.name);
		demo.name="wangweid";
		System.out.println(t1.demo.name);
		System.out.println("-----------------");
		final Test test = new Test();
		Name na = new Name();
		na.name="name1";
		test.set(na);
		System.out.println(test.getLong());
		na.name="aaaaaa";
		System.out.println(test.getString());

		Thread thread1 = new Thread() {
			public void run() {
				test.set(na);
				System.out.println(test.getLong());
				System.out.println(test.getString());
			};
		};
		thread1.start();
		thread1.join();

		System.out.println(test.getLong());
		System.out.println(test.getString());
	}
}
class Name{
	public String name;
	public Name() {
		
	}
}