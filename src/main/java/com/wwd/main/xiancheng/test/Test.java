package com.wwd.main.xiancheng.test;

public class Test implements Runnable{

	 static  {
		System.out.println("static");
	}
	
	@Override
	public void run() {
		for(int i=1;i<10000;i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+i);
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		Thread thread = new Thread(test);
		thread.start();
		thread.join();
	}
}
