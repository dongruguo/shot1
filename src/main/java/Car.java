public class Car extends BaseCar{
	static {
		System.out.println("static block");
	}
	public void CarSyso() {
		System.out.println("new Car");
	}
	public static void CarSyso(String s) {
		System.out.println("static Car s");
	}
	public static void main(String[] args) {
		BaseCar bc = new Car();
		bc.baseCarSyso("ssss");
	}
	
}

class BaseCar{
	static {
		System.out.println("static block BaseCar");
	}
	public void baseCarSyso() {
		System.out.println("new BaseCar");
	}
	public static void baseCarSyso(String s) {
		System.out.println("static BaseCar "+s);
	}
}