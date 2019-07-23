package com.wwd.main.paixu;

public class QuckSort {
	//是分治法之一类的算法
	public static void quckSort(int[] qs ,int low,int high){
		if(low < high){
			int middle = getMiddle(qs,low,high);
			quckSort(qs,low,middle-1);
			quckSort(qs,middle+1,high);
	   }
	}
	
	public static int getMiddle(int[] qs ,int low,int high) {
		int temp  = qs[low];
		while(low<high) {
			while(low < high && qs[high] > temp) {
				high--;
			}
			qs[low] = qs[high];
			while(low < high && qs[low] < temp) {
				low++;
			}
			qs[high] = qs[low];
		}
		qs[low] = temp ; //中轴记录到尾
		return low ; // 返回中轴的位置
	}
	public static void main(String[] args) {
		int[] a = new int[] {12,14,42,1,3,7,2};
		quckSort(a,0,a.length-1);
		for(int aa:a) {
			System.out.println(aa);
		}
	}
}
