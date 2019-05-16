package JavaJVM;

class ClassLoaderAndForNameTest{
	
	static {
		System.out.println("ClassLoaderAndForNameTest AAAA");
	}
	public void getInner(String str) {
		System.out.println(str);
	}
}

public class ClassLoaderAndForName {
	
	 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		 Class line = Class.forName("JavaJVM.ClassLoaderAndForNameTest");
		 ClassLoaderAndForNameTest cc =  (ClassLoaderAndForNameTest) line.newInstance();
		 cc.getInner("Class.forname");
		// -----------------------
		 ClassLoader cl = ClassLoader.getSystemClassLoader();  
	        // 下面语句仅仅是加载Tester类  
		 Class cla = cl.loadClass("JavaJVM.ClassLoaderAndForNameTest");  
		ClassLoaderAndForNameTest  cc2 = (ClassLoaderAndForNameTest) cla.newInstance();
	    cc2.getInner("ClassLoader.loadClass"); 
		 System.out.println("系统加载Tester类");  
	        // 下面语句才会初始化Tester类  
	}
}
