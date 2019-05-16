package xiancheng.join;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class PublicBoxQueue {
	public static void main(String[] args) {
		 BlockingDeque<Integer> bd = new LinkedBlockingDeque<>(5);
		 
		 ProducerQueue pq = new ProducerQueue(bd);
		 
		 ConsumerQueue cq = new ConsumerQueue(bd);
		 
		 Thread thread1 = new Thread(pq);
		 
		 Thread thread2 = new Thread(cq);
		 thread1.start();
		 thread2.start();
	}
}
