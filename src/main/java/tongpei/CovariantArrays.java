package tongpei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {
	public String name = "fruit";
	public void sys() {
		System.out.println("this is "+name);
	}
}
class Apple extends Fruit {
	public String name = "Apple";
	public void sys() {
		System.out.println("this is "+name);
	}
}
class Jonathan extends Apple {}
class Orange extends Fruit {
	public String name = "Orange";
	public void sys() {
		System.out.println("this is "+name);
	}
}

public class CovariantArrays {
	public static void printTest(List<? extends Fruit> list) {
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getClass());
			list.get(i).sys();
		}
	}
	
	
	
	public static void test1() {
		List<Fruit> flist = new ArrayList<Fruit>();
    	flist.add(new Fruit());
    	flist.add(new Apple());
    	flist.add(new Orange());
    	
    	printTest(flist);
	}
	
	public static void test2() {
	  	Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
	}
	
    public static void main(String[] args) { 
    	 //泛型不支持协变
    	//ArrayList<Fruit> list = new ArrayList<Fruit>();
    	
    	 List<? extends Fruit> flist =
    		        Arrays.asList(new Apple(),new Apple());
    		        Apple a = (Apple)flist.get(0); // No warning
    		        a.sys();
    		        System.out.println(flist.contains((Object)new Apple()));; // Argument is ‘Object’
    		        System.out.println(flist.indexOf(new Apple()));; // Argument is ‘Object’
    	
    	
  
    }
} 