package Syn;

public class TextThread {  
	  
	  
	public static void main(String[] args) {   
		   TxtThread tt1 = new TxtThread();  
		   TxtThread tt2 = new TxtThread();  
		   TxtThread tt3 = new TxtThread();  
		   new Thread(tt1).start();   
		   new Thread(tt2).start();   
		   new Thread(tt3).start();   
		}   
	}  
	  
	  
	class TxtThread implements Runnable {   
	int num = 100;   
	String str = new String();  
	public synchronized void run() { 
	 {   
	    while (num > 0) {  
	     try {   
	      Thread.sleep(100);   
	     } catch (Exception e) {   
	      e.getMessage();   
	     }   
	     System.out.println(Thread.currentThread().getName()   
	       + "this is " + num--);   
	    }   
	   }   
	}   
	}
