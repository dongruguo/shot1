package xiancheng.kecheng;

public class TestOne {
	public static void main(String[] args) {
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		});
		thread2.start();
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println(this.getName());
			}
		};
		thread.start();
	}

}
