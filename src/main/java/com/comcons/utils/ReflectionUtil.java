package com.comcons.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

class Student{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class ReflectionUtil {

	public static Object getFildValue(Student student,String name) {
		Class clas = student.getClass();
		try {
			Field field = clas.getDeclaredField(name);
			field.setAccessible(true);
			try {
				Object object = field.get(student);
				return (object);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("wangweidong");
		Object ss = ReflectionUtil.getFildValue(student, "name");
		System.out.println(ss);
	}
}
