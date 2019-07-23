package com.wwd.main.xiancheng.shengchang;

public class ProductTask {
	private int index = 0;
	private int[] data = new int[5];
	
	public synchronized void setProduct(int product) throws InterruptedException {
		if(index == data.length) {
			System.out.println("已经满了，暂时不能在添加了。。。。");
			this.wait();
		}
		data[index] = product;
		System.out.println("生产了产品"+product+"。。。。"+index++);
		this.notifyAll();
		
	}
	
	public synchronized int getProduct() throws InterruptedException  {
		if(index == 0) {
			System.out.println("已经空了，暂时不能在消费了。。。。");
			this.wait();
		}
		int product = data[--index];
		System.out.println("product干了一个了"+product);
		this.notifyAll();
		return product;
		
	}
}
