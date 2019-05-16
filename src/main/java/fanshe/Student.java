package fanshe;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//---------------构造方法-------------------  
    //（默认的构造方法）  
    Student(String str){  
        System.out.println("(默认)的构造方法 s = " + str);  
    }  
      
    //无参构造方法  
    public Student(){  
        System.out.println("调用了公有、无参构造方法执行了。。。");  
    }  
      
    //有一个参数的构造方法  
    public Student(char name){  
        System.out.println("姓名：" + name);  
    }  
      
    //有多个参数的构造方法  
    public Student(String name ,int age){  
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。  
    }  
      
    //受保护的构造方法  
    protected Student(boolean n){  
        System.out.println("受保护的构造方法 n = " + n);  
    }  
      
    //私有构造方法  
    private Student(int age){  
        System.out.println("私有的构造方法   年龄："+ age);  
    }  
    public  void getConstructor() throws Exception{
    	 //1.加载Class对象  
        Class clazz = Class.forName("fanshe.Student");  
        //2.获取所有公有构造方法  
        System.out.println("**********************所有公有构造方法*********************************");  
        Constructor[] conArray = clazz.getConstructors();  
        for(Constructor c : conArray){  
            System.out.println(c);  
        }  
          
          
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");  
        conArray = clazz.getDeclaredConstructors();  
        for(Constructor c : conArray){  
            System.out.println(c);  
        }  
          
        System.out.println("*****************获取公有、无参的构造方法*******************************");  
        Constructor con = clazz.getConstructor(null);  
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型  
        //2>、返回的是描述这个无参构造函数的类对象。  
      
        System.out.println("con = " + con);  
        //调用构造方法  
        Object obj = con.newInstance();  
    //  System.out.println("obj = " + obj);  
    //  Student stu = (Student)obj;  
          
        System.out.println("******************获取私有构造方法，并调用*******************************");  
        con = clazz.getDeclaredConstructor(char.class);  
        System.out.println(con);  
        //调用构造方法  
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)  
        obj = con.newInstance('男');  
        
        System.out.println("******************获取String int构造方法，并调用*******************************");  
        con = clazz.getConstructor(String.class,int.class);  
        System.out.println(con);  
        //调用构造方法  
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)  
        obj = con.newInstance("男",22);  
    }
	  //**************成员方法***************//  
	    public void show1(String s){  
	        System.out.println("调用了：公有的，String参数的show1(): s = " + s);  
	    }  
	    protected void show2(){  
	        System.out.println("调用了：受保护的，无参的show2()");  
	    }  
	    void show3(){  
	        System.out.println("调用了：默认的，无参的show3()");  
	    }  
	    private String show4(int age){  
	        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);  
	        return "abcd";  
	    }  
    public static void main(String[] args) throws Exception {  
    	 //1.获取Class对象  
        Class stuClass = Class.forName("fanshe.Student");  
        //2.获取所有公有方法  
        System.out.println("***************获取所有的”公有“方法*******************");  
      //  stuClass.getMethods();  
        Method[] methodArray = stuClass.getMethods();  
        for(Method m : methodArray){  
            System.out.println(m);  
        }  
        System.out.println("***************获取所有的方法，包括私有的*******************");  
        methodArray = stuClass.getDeclaredMethods();  
        for(Method m : methodArray){  
            System.out.println(m);  
        }  
        System.out.println("***************获取公有的show1()方法*******************");  
        Method m = stuClass.getDeclaredMethod("show1", String.class); 
        m.setAccessible(true);//解除私有限定
        System.out.println(m);  
        //实例化一个Student对象  
        Object obj = stuClass.getConstructor().newInstance();  
        m.invoke(obj, "刘德华");  
        System.out.println(System.getProperty("java.class.path"));
       
          
          
    }  
    
}
