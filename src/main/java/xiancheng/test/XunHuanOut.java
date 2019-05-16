package xiancheng.test;

public class XunHuanOut implements Runnable{
	
	private static int i = 0;
	public static void main(String[] args) {
		XunHuanOut o = new XunHuanOut();
		Thread t1 = new Thread(o);
		Thread t2 = new Thread(o);
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		while(true) {
		synchronized (this){
				try {
					Thread.currentThread().notify();
					System.out.println(Thread.currentThread().getName()+"--"+i++);
					Thread.sleep(1000);
					Thread.currentThread().wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
