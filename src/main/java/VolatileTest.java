
public class VolatileTest implements Runnable{

	@Override
	public void run() {
		//TODO
		this.get();
	}
	
	public void   get() {
		synchronized (VolatileTest.class) {
			//TODO
		}
	}
		
}
