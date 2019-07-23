package com.wwd.main.JavaJVM;


class BaseTest{
	int bb  =20;
	public void sys11() {
		System.out.println("BaseTest sys11");
	}
	public void sys22() {
		System.out.println("BaseTest sys22");
	}
}
class SubTest extends BaseTest{
	int a = 10;
	public void sys11() {
		System.out.println("SubTest sys11");
	}
	public void sys33() {
		System.out.println("SubTest sys33");
	}
}
public class StaticDispatch {
	public static void main(String[] args) {
		BaseTest base= new SubTest();
		
		SubTest st = (SubTest)base;
		base.sys11();
	}
}
