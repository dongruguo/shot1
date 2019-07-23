package com.wwd.main.tongpei;

import java.util.ArrayList;
import java.util.List;

public class test1 {
	
	 public void testOne() {
/*		 List<? extends A> list1 = new ArrayList<A>(); 
       A a = list1.get(0);
       List<? extends A> list2 = new ArrayList<B>();  
       List<? super B> list3 = new ArrayList<B>(); 
       list3.add(new C());
       //想要正确，必须向下转型，但是向下转型是不安全的，非常容易出错
       B b = (B)list3.get(0); //编译器无法确定get返回的对象类型是B,还是B的父类或 Object.
       List<? super B> list4 = new ArrayList<A>();  
*/	
		 
	 }
}

class A{}
class B extends A{}
class C extends B{}

class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}
class yeye{
	public String yeye;
	
}
class baba extends yeye{
	public String baba;
}
class erzi extends baba{
	public String erzi;
}