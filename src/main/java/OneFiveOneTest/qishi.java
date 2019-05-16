package OneFiveOneTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class qishi extends TestSub{
	
	public static void TestList() {
		ClassRoom c1 = new ClassRoom("1",1);
		ClassRoom c2 = new ClassRoom("2",2);
		ClassRoom c3 = new ClassRoom("3",3);
		ClassRoom c4 = new ClassRoom("4",4);
		ArrayList<ClassRoom> a1 = new ArrayList<>();
		ArrayList<ClassRoom> a2 = new ArrayList<>();
		a1.add(c1);a1.add(c2);
		a2.add(c1);a2.add(c3);
		//交集
	//	a1.retainAll(a2);//ClassRoom [name=1, grade=1]
		//差集
		//a1.removeAll(a2);//ClassRoom [name=2, grade=2]
		Collections.shuffle(a1);
		//无重复的并集
		a1.removeAll(a2);//值获取在a1中存在的
		a1.addAll(a2);//将上面的结果在添加全部的a2
		for(ClassRoom cc:a1) {
			System.out.println(cc);
		}
		
		
		
	}
	
	public static void testList() {
		List<String> c = new ArrayList<>();
    	c.add("A");c.add("B");
    	List<String> c1 = new ArrayList<>(c);
    	List<String> c2 = c.subList(0, c.size());
    	c2.add("C");
    	System.out.println(c.equals(c1)+" c.equals(c1)");
    	System.out.println(c.equals(c2)+" c.equals(c2)");
    	for(String cc:c) {
    		System.out.println(cc);
    	}
	}
	public static Object getSecondMaxValue(String[] list) {
		List<String> al = Arrays.asList(list);
		System.out.println(al.size()+"----------");
		for(String str:list) {
			System.out.println(str);
		}
		TreeSet<String> set = new TreeSet<>(al);
		return set.lower(set.last());
	}
	
	public static Object getFieldValue(Object object,String name) {
		/**
		 * getField获取所有的object和父类或者接口的public属性
		 * getDeclaredField是获取object的所有方法
		 */
		
		try {
			Class clazz = object.getClass();
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			Object value = field.get(object);
			return value;
		}catch(Exception e) {
		//TODO	
		}
		
		return null;
	}
    public static void main(String[] args) throws InterruptedException {
    	TestList();
    }
    
    public static  void get(StringBuffer a,String b) {
    	a.append("111");
    	
    }
}

class ComparatorClassRoom implements Comparator<ClassRoom>{

	@Override
	public int compare(ClassRoom o1, ClassRoom o2) {
		// TODO Auto-generated method stub
		return o1.getGrade()-o2.getGrade();
	}
	
}

class ClassRoom {
	private String name;
	private Integer grade;
	public ClassRoom(String name,Integer grade) {
		this.name = name;
		this.grade = grade;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ClassRoom [name=" + name + ", grade=" + grade + "]";
	}
	
}
class TestSub{
	
}
