package xiancheng.Concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	private final static CountDownLatch latch = new CountDownLatch(3);
	
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				System.out.println("子线程运行"+Thread.currentThread().getName());
				latch.countDown();
			}
		}.start();;
		
		new Thread() {
			@Override
			public void run() {
				System.out.println("子线程运行"+Thread.currentThread().getName());
				latch.countDown();
			}
		}.start();
		try {
			latch.await();	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("子线程运行结束");
	}
}
