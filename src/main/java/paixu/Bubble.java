package paixu;

public class Bubble {
	public static int[] bubble(int[] a) {
		int length = a.length;
		for(int i = 0 ;i < length-1;i++) {
			for(int j= 0 ;j <length-1-i;j++ ) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j]= a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int[] a = new int[] {12,14,42,1,3,7,2};
		bubble(a);
		for(int aa:a) {
			System.out.println(aa);
		}
	}
}
