package xiancheng.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import xiancheng.test.main;

public class ThreadPoolExecutorTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			Thread.sleep(i*1000);
			es.execute(new ThreadPoolExecutorTestRun(i+""));
		}
	}
	
	
}
class ThreadPoolExecutorTestRun extends Thread{
	
	private String index;
	public ThreadPoolExecutorTestRun(String index) {
		this.index = index;
		
	}
	@Override
	public void run() {
		System.out.println(index);
	}
}
