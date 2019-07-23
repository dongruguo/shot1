/**
 * @author: 王卫东  
 * @date:   2019年2月25日 上午9:50:39
 */
package com.wwd.main.oneFiveOneTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 王卫东  
 * @date:   2019年2月25日 上午9:50:39
 */
public class JIushisiTest<T> {
	
	private T t;
	
	private T[] tArray;
	
	private List<T> list  = new ArrayList<T>();
	
	public JIushisiTest() throws Exception {
		try {
			Class<?> typeClass =	Class.forName("java.lang.Integer");
			t = (T)typeClass.newInstance();
			tArray = (T[])Array.newInstance(typeClass, 5);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public T[] gettArray() {
		return tArray;
	}
	public void settArray(T[] tArray) {
		this.tArray = tArray;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public static <T> T[] toArray(List<T> t,Class<T> className) {
		T[] tt = (T[])Array.newInstance(className, t.size());
		for(int i =0 ;i<t.size();i++) {
			tt[i] = t.get(i);
		}
		return tt;
		
	}
	public static void main(String[] args) throws Exception {
		//JIushisiTest<Integer> jiu = new JIushisiTest<>();
		//System.out.println(jiu.gettArray().length);
		List<String> list = new ArrayList<String>();
		list.add("aaa");list.add("bbb");list.add("ccc");
		
		String[] str = toArray(list,java.lang.String.class);
		
		for(Object strTemp:str) {
			System.out.println(strTemp);
		}
	}
}

class Base{
	public Number doStuff() {
		return 0;
	}
}

class Sub extends  Base{
	@Override
	public Integer doStuff() {
		return 1;
	}
}
