import java.util.ArrayList;
import java.util.List;
class Base{}
class Fruit extends Base{}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
class  Plate<T>{
	private T item;
	public Plate(T t) {
		item = t;
	}
	public void setItem(T t) {
		item = t;
	}
	public T getItem() {
		return item;
	}
};


public class CovariantArrays {
	public static List<Fruit> getList() {
		ArrayList<Fruit> a= new ArrayList<Fruit>();
		a.add(new Fruit());
		return a;
	}
	public static void testPlateT() {
		//Plate<Fruit> p=new Plate<Apple>(new Apple());
		Plate<? extends Fruit> p=new Plate<Fruit>(new Fruit());
		List<? extends Fruit> list1 = getList();
		
		//ArrayList<String> aa = new ArrayList<String>("1111","2222");
		//p.setItem(new Base());
		/*ArrayList<? extends Fruit> ddl = new ArrayList<Fruit>();*/
		
	}
    public static void main(String[] args) {       
	
    }
}
