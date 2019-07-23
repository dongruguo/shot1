package com.wwd.main.tongpei;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
	private List<T> array = new ArrayList<T>();

	public void add(T item) {
		array.add(item);
	}

	public T get(int index) {
		return array.get(index);
	}
	
	public static void main(String[] args) {
		ListOfGenerics<String> list = new ListOfGenerics<>();
		list.add("ssss");
		System.out.println(list.get(0));
	}
}
