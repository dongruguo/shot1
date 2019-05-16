/**
 * @author: 王卫东  
 * @date:   2019年2月12日 上午10:15:20
 */
package OneFiveOneTest.siyi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author: 王卫东  
 * @date:   2019年2月12日 上午10:15:20
 */
public class Son extends FatherImpl implements Monther {

	@Override
	public int strong() {
		return super.strong()+1;
	}
	
	@Override
	public int kind() {
		return new MontherSpecial().kind();
	}
	
	private class MontherSpecial extends MontherImpl{
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		Son son = new Son();
	//	System.out.println(son.kind());
		Class cla =  Son.class;
		  Method methods = cla.getDeclaredMethod("kind");
		  Annotation anno = methods.getAnnotation(Override.class);
		  System.out.println(anno.toString());
	/*	Math ma = (Math) cla.newInstance();
		System.out.println(ma.max(12, 23));*/
	}

}
