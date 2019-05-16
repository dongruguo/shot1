/**
 * @author: 王卫东  
 * @date:   2019年2月22日 下午3:17:38
 */
package OneFiveOneTest.jiushi;

/**
 * @author: 王卫东  
 * @date:   2019年2月22日 下午3:17:38
 */
public abstract class AbstractParent {
	
	 @InheritedAnnotation(value = "parent abstractMethod ")
	public abstract void abstractMethod();
	
	@InheritedAnnotation("parents doExtends")
	public void doExtends() {
		System.out.println("AbstractParent  doExtends...." );
	}

}
