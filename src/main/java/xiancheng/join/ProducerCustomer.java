package xiancheng.join;

public class ProducerCustomer {

	 private int production = 0;     
	 public static void main(String []args)
     {
		ProducerCustomer box= new ProducerCustomer();
            
		Coumser con= new Coumser(box);
        Producer pro= new Producer(box);
        
        Thread t1= new Thread(con);
        Thread t2= new Thread(pro);
        
        t1.start();
        t2.start();
            
            
     }
	public synchronized void Producer() {
		while(production > 5) {
			try {
				System.out.println("is over"+production);
				this.wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		production++;
		System.out.println("再生产"+production);
		this.notify();
	}

	public synchronized void Coumser() {
		while(production <1) {
			try {
				System.out.println("meila"+production);
				this.wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		production--;
		System.out.println("再消费"+production);
		this.notify();
	}
	
  
  
}