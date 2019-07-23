/**
 * @author: 王卫东  
 * @date:   2019年2月22日 下午3:20:14
 */
package com.wwd.main.oneFiveOneTest.jiushi;

import java.lang.reflect.Method;

/**
 * @author: 王卫东  
 * @date:   2019年2月22日 下午3:20:14
 */
public class InheritedAnnotationTest {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<SubClassImpl> cla = SubClassImpl.class;
		Method method = cla.getMethod("abstractMethod",new Class[] {});
		if(method.isAnnotationPresent(InheritedAnnotation.class)) {
			  InheritedAnnotation ma = method.getAnnotation(InheritedAnnotation.class);  
			  System.out.println(ma.value());
		}else {
			System.out.println("注解是不能继承的");
		}
		System.out.println("-------------------");
		 method = cla.getMethod("doExtends", new Class[] {});
		 if(method.isAnnotationPresent(InheritedAnnotation.class)) {
			  InheritedAnnotation ma = method.getAnnotation(InheritedAnnotation.class);  
			  System.out.println(ma.value());
		 }else {
				System.out.println("注解是不能继承的");
		 }
	}

}
