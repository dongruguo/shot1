package com.paixu;



public class MaoPao {
	public static int[] MaoP(int[] str) {
		for(int i=0;i<str.length-1;i++) {
			for(int j=i+1;j<str.length;j++) {
				if(str[i]>str[j]) {
					str[i]=str[i]+str[j];
					str[j] = str[i] -str[j];
					str[i] = str[i] -str[j];
				}
			}
		}
		return str;
	}
	public static void main(String[] args) {
		int[] stt  = new int[] {1,4,6,2,1,-1,0};
		for(int i:stt) {
			System.out.print(i+"--");
		}
		 MaoP(stt);
		System.out.println();
		for(int i:stt) {
			System.out.print(i+"--");
		}
		System.out.println();
		System.gc();
	}
}
