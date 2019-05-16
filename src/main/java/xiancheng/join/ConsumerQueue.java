package xiancheng.join;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable{

	@Override
	public void run() {
		 for (int i=0;i<10;i++) {
				try {
					System.out.println("消费序号是："+proQueue.take());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			 }
		
	}
	
	private final BlockingQueue proQueue;
	public ConsumerQueue(BlockingDeque bd) {
		this.proQueue = bd;
	}

}
