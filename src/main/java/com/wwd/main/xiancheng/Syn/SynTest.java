package com.wwd.main.xiancheng.Syn;

public class SynTest {
	 public static void main(String[] args) {  
		 String str = "1111";
	        for (int i = 0; i < 5; i++) {  
	            Thread thread = new Thread(new MyThread(str));  
	            thread.start();  
	        }  
	    }  
   
} 
class MyThread implements Runnable {  
	String str ;
	public MyThread(String s) {
		this.str=s;
	}
    public void run() {  
    	Main sync = new Main();  
        sync.test2(str);  
        sync.test(str);  
    }  
}  
  
 class Main {  
  
	 //is wrong
	 public  synchronized void  test2(String str) {  
		  {
	        System.out.println("test2222开始..");  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println("test22222结束..");  
	    }  
	 }
	 //is right
	 public  synchronized void  test(String str) {  
		 {
	        System.out.println("test开始..");  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println("test结束..");  
	    }  
	 }
}  
