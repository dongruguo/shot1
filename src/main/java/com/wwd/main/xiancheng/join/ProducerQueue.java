package com.wwd.main.xiancheng.join;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable{
	private final BlockingQueue<Integer> proQueue;
	public ProducerQueue(BlockingDeque bd) {
		this.proQueue = bd;
	}
	@Override
	public void run() {
		 for (int i=0;i<10;i++) {
			try {
				System.out.println("生产序号是："+i);
				proQueue.put(i);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		 }
	}
}
