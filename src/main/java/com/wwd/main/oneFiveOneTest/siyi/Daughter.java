/**
 * @author: 王卫东  
 * @date:   2019年2月12日 上午10:30:04
 */
package com.wwd.main.oneFiveOneTest.siyi;

/**
 * @author: 王卫东  
 * @date:   2019年2月12日 上午10:30:04
 */
public class Daughter extends MontherImpl implements Father {


	@Override
	public int strong() {
		return new FatherImpl() {
			@Override
			public int strong() {
				return super.strong()-2;
			};
			
			public int strowng() {
				return 12;
			};
			
		}.strowng();
	}
	
	@Override
	public int kind() {
		// TODO Auto-generated method stub
		return super.kind()+2;
	}
	public static void main(String[] args) {
		Daughter dau = new Daughter();
		System.out.println(dau.strong());
		System.out.println(Math.max(1,2));
	}
	

}
