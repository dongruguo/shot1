package xiancheng.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {


	private Lock lock = null;
   // private Condition condition=lock.newCondition();
    public MyService(Lock lock) {
    	this.lock = lock;
    }
    public  void testMethod() {
        
        try {
            lock.lock();
            System.out.println("开始wait");
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadNamwwwe=" + Thread.currentThread().getName()
                        + (" " + (i + 1)));
            }
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        finally
        {
          
        }
    }
    public static void main(String[] args) {
    	Lock lock = new ReentrantLock();
    	MyService y = new MyService(lock);
    	y.testMethod();
    	y.testMethod();
	}
}