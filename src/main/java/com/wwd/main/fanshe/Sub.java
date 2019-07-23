package com.wwd.main.fanshe;

class Base{
	private String name;
	public Base(String name) {
		this.name= name;
	}
	public String getName() {
		return name;
	}
	
}
public class Sub extends Base{
	public int age;
	public Sub(String name,int age) {
		super(name);
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public static void main(String[] args) {
		Sub base = new Sub("wwd",28);
		System.out.println();
		
	}
}
