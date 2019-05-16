package xiancheng.shengchang;

public class Consumer extends Thread{
	private ProductTask productTask;
	
	public Consumer(ProductTask pt) {
		productTask = pt;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				productTask.getProduct();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
