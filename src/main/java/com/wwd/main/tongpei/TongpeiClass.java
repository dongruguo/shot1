package com.wwd.main.tongpei;

public class TongpeiClass<T> {
	  private  T item;
	    public TongpeiClass(T t){item=t;}
	    public TongpeiClass(){}
	    public void set(T t){item=t;}
	    public T get(){return item;}
	    public <F> F getF(F f){
	    	return f;
	    };
}
