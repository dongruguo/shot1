package com.wwd.main.JavaJVM;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestOne {
	

	public static void main(String[] args) throws Exception{
		 ArrayList<String> al = new ArrayList<String>();
		 al.add("----");
		 al.add("\\\\");
		  Method m = al.getClass().getMethod("add", java.lang.Object.class);  
		  m.invoke(al, 11);
		  System.out.println(al.toString());
		  
	}

}
