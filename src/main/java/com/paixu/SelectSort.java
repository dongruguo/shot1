package com.paixu;

public class SelectSort {
	public static void selectSort(int[] number) {
		 int temp = 0 ; //中间变量
		for(int i=0;i<number.length;i++) {
			int k=i;
			
			for(int j=number.length-1;j>i;j--) {
				if(number[j]<number[k]) {
					k=j;
				}
			}
			//交换两个数
	        temp = number[i];
	        number[i] = number[k];
	        number[k] = temp;
		}
	//	return number;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {112,14,42,1,3,7,2};
		selectSort(a);
		for(int aa:a) {
			System.out.println(aa);
		}
	}
}
