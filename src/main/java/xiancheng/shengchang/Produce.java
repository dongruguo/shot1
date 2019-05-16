package xiancheng.shengchang;

public class Produce extends Thread{
	
	private ProductTask productTask;
	
	public Produce(ProductTask pt) {
		productTask = pt;
	}
	@Override
	public void run() {
		for(int i=0;i<10 ;i++) {
			try {
				productTask.setProduct(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
