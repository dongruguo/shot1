package daili;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Client {
	
	public static void main(String[] args) throws Exception{
		 //    我们要代理的真实对象
        Subject realSubject = new RealSubject();
        
        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);
        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
        
        subject.rent();
        subject.hello("world");
        
       /* System.out.println("--------------------");
        Class c = Class.forName("daili.RealSubject");
        Constructor con = c.getDeclaredConstructor(new Class[] {String.class});
        con.setAccessible(true);
        RealSubject rs = (RealSubject) con.newInstance(new String[] {"sss"});
        rs.rent();*/
	}
}
