package com.wwd.main.annotation;

import java.util.Collections;

@MyAnnotation(color="redd",value="孤傲苍狼")//等价于@MyAnnotation(value="孤傲苍狼")
public class MyAnnotationTest {
    public static void main(String[] args) {
        /**
         * 用反射方式获得注解对应的实例对象后，在通过该对象调用属性对应的方法
         */
        MyAnnotation annotation = (MyAnnotation) MyAnnotationTest.class.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.color());//输出color属性的默认值：blue
        System.out.println(annotation.value());
    }
}