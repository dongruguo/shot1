package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{

	//　这个就是我们要代理的真实对象
    private Object subject;
    public DynamicProxy(Object subject)
    {
    		this.subject = subject;
    }
    
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start .....");
		
		method.invoke(subject, args);
		
		System.out.println("endd ....");
		return null;
	}

}
