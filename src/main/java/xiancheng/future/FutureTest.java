package xiancheng.future;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
 
/**
 * 试验 Java 的 Future 用法
 */
public class FutureTest {
 
    public static class Task implements Callable<String> {
    	private int i;
    	public Task(int i) {
    		this.i=i;
    	}
    	
    	
        @Override
        public String call() throws Exception {
            String tid = i+"";
            System.out.printf("before:	Thread#%s : in call\n", tid);
            Thread.sleep(1000);
            System.out.printf("after:	Thread#%s : in call\n", tid);
            return tid;
        }
    }
 
    public static void main(String[] args)  {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newSingleThreadExecutor();//Executors.newCachedThreadPool();
        for(int i=0; i<10;i++)
            results.add(es.submit(new Task(i)));
        if(!es.isShutdown()) {
        	es.shutdownNow();
        	System.out.println("shutDown!");
        }
		/*
		 * for(Future<String> res : results) { try { System.out.println(res.get()); }
		 * catch (InterruptedException | ExecutionException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } }
		 */
			
    }
 
}