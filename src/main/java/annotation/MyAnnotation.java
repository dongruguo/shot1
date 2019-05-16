package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//Retention注解决定MyAnnotation注解的生命周期
@Target( { ElementType.METHOD, ElementType.TYPE })
public @interface MyAnnotation {
    String color() default "blue";//为属性指定缺省值
    String value();//定义一个名称为value的属性
}