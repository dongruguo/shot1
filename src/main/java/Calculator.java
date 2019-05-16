/**
 * @author: 王卫东  
 * @date:   2019年2月1日 下午2:03:48
 */

/**
 * @author: 王卫东  
 * @date:   2019年2月1日 下午2:03:48
 */

enum Ops{ADD,SUB}
public class Calculator {
	private int i,j,result;
	public Calculator() {
		System.out.println("没有参数");
	}
	public Calculator(int _i,int _j) {
		this.i=_i;
		this.j = _j;
		System.out.println("有参数");
	}
	protected void setOperator(Ops _ops) {
		result = _ops.equals(Ops.ADD)?i+j:i-j;
	}
	public int getResult() {
		return result;
	}
	
	public static void main(String[] args) {
		Add cal = new Add(1,2) {
			{
				setOperator(Ops.ADD);
			}
			
		};
		System.out.println(cal.getResult());
	}
}

class Add extends Calculator{
	{
		setOperator(Ops.ADD);
	}
	public Add(int _i, int _j) {
		
	}
}
