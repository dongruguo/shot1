package daili;

public class RealSubject implements Subject{
	
	public RealSubject() {
	
	}

	private RealSubject(String str) {
		System.out.println("RealSubject "+str);
	}
	public void rent() {
		System.out.println(" I want to rent my house");
	}
    
    public void hello(String str) {
    	System.out.println(" I want to say "+str);
    }
}
