package JavaJVM;

public class JavaDui {
	public static void main(String[] args) {
		System.out.println("Xmx:"+Runtime.getRuntime().maxMemory()/1024.0/1024+"M");
		System.out.println("totalMemory Xmx:"+Runtime.getRuntime().totalMemory()/1024.0/1024+"M");
		System.out.println("freeMemory Xmx:"+Runtime.getRuntime().freeMemory()/1024.0/1024+"M");
	}
}
