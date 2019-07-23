package com.wwd.main.tongpei;
class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}
class BaseF extends HasF{
	@Override
	public void f() {
		System.out.println("BaseF.f()");
	}  
}
public class Manipulator<T extends HasF> {
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f(); //无法编译 找不到符号 f()
    }

    public static void main(String[] args) {
        HasF hasF  = new BaseF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        manipulator.manipulate();

    }
}