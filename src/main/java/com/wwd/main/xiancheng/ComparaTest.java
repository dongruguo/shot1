package com.wwd.main.xiancheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparaTest {
	
	public static void main(String args[]) {
		List<Person> list = new ArrayList<>();
		Person p1 = new Person();p1.setAge(1);
		Person p2 = new Person();p2.setAge(-10);
		Person p3 = new Person(); p3.setAge(10);
		list.add(p1);list.add(p2);list.add(p3);
		Collections.sort(list,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.getAge()>o2.getAge()) {
					return 1;
				}else {
					return -1;
				}
			}
		});
		for(Person person:list) {
			System.out.println(person.getAge());
		}
	}

}
