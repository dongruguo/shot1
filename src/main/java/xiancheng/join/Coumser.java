package xiancheng.join;

public class Coumser implements Runnable { 
    private ProducerCustomer box; 
 
    public Coumser(ProducerCustomer box) { 
        this .box = box; 
    } 
 
    @Override 
    public void run() { 
       
        for( int i=0;i<10;i++)
       {
             try {
                           Thread. sleep(3000);                // 这里设置跟上面30不同是为了 盒子中的苹果能够增加，不会生产一个马上被消费  
                     } catch (InterruptedException e) {
                            // TODO: handle exception
                           e.printStackTrace();
                     }
       
            box.Coumser(); 
        } 
 } 
}