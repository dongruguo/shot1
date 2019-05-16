package xiancheng.join;

public class Producer implements Runnable { 
    private ProducerCustomer box; 
 
    public Producer(ProducerCustomer box) { 
        this .box = box; 
    } 
 
    @Override 
    public void run() { 
       
        for( int i=0;i<10;i++)  
       {
               try {
                           Thread. sleep(30);
                     } catch (InterruptedException e) {
                            // TODO: handle exception
                           e.printStackTrace();
                     }
       
            box.Producer(); 
       }
        
    } 
}
