/**
 * @author: 王卫东  
 * @date:   2019年2月22日 下午3:16:20
 */
package OneFiveOneTest.jiushi;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

/**
 * @author: 王卫东  
 * @date:   2019年2月22日 下午3:16:20
 */
@Inherited
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface InheritedAnnotation {
	
	String value();

}
