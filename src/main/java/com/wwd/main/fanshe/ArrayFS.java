package com.wwd.main.fanshe;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayFS {
	 public static void main(String[] args) throws Exception{  
	        ArrayList<Integer> strList = new ArrayList<>();  
	        strList.add(100);  
	        strList.add(200);  
	          
	    //  strList.add(100);  
	        //获取ArrayList的Class对象，反向的调用add()方法，添加数据  
	        Class<?> listClass =  Class.forName("java.util.ArrayList"); //得到 strList 对象的字节码 对象  
	        //获取add()方法  
	        Method m = listClass.getMethod("add", Object.class);  
	        //调用add()方法  
	        m.invoke(strList, "bbb");  
	          
	        //遍历集合  
	        for(Object obj : strList){  
	            System.out.println(obj);  
	        }  
	    }  
}
