package xiancheng.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NonCompleteServiceTest {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String>[] futures = new FutureTask[10];
        
        /**
         * 产生一个随机数，模拟不同的任务的处理时间不同
         */
        long endnano = System.nanoTime()+1000;
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(new Callable<String>() {
                public String call(){
                    int rnt = new Random().nextInt(5);
                    
                    try {
                        Thread.sleep(rnt*1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return String.valueOf(rnt*1000);
                }
            });
        }
        
        /**
         * 获取结果时，如果任务没有完成，则阻塞,在顺序获取结果时，
         * 可能别的任务已经完成，显然效率不高
         */
        for (int i = 0; i < futures.length; i++) {
        	long leftTime = endnano-System.nanoTime();
            try {
				try {
					//
					String re = futures[i].get(leftTime,TimeUnit.NANOSECONDS);
					System.out.println(re);
				} catch (TimeoutException e) {
					futures[i].cancel(true);
					System.out.println("-----------");
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				System.out.println("1111111111");
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				System.out.println("2222222222");
				futures[i].cancel(true);
				e.printStackTrace();
			}
        }
        executorService.shutdown();
    }

}