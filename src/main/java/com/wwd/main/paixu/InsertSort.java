package com.wwd.main.paixu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertSort {
		public static void insertSort(int[] a) {
			int length = a.length;
			int j =  0;
			for(int i =0;i < length;i++) {
				int temp = a[i];
				for(j = i;j>0 && temp<a[j-1];j--) {
					a[j] = a[j-1];
				}
				a[j] = temp;
			}
		}
		public static void main(String[] args) {
			int[] a = new int[] {23,1,243,5,2,12};
			//insertSort(a);
			
			ArrayList<Integer> al = new ArrayList<>();
			al.add(12);
			al.add(-12);
			al.add(0);
			al.add(50);
			Collections.sort(al);
			for(int i:al)
				System.out.println(i);
			Arrays.sort(a);
			System.out.println("--------------");
			for(int ii:a) {
				System.out.print(ii+"--");
			}
			
			
		}
}
