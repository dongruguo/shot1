package com.wwd.main.xiancheng.shengchang;

public class MainTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		ProductTask pt = new ProductTask();
		
		Produce produce = new Produce(pt);
		Consumer consumer = new Consumer(pt);
		
		consumer.start();
		produce.start();

		produce.sleep(1000);
	}
	
	

}
