import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

public class Test extends TimerTask {
	
	@Override
    public void run()
    {
        SimpleDateFormat sdf = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("当前时间：" + sdf.format(new Date()));

    }
	
	public static void main(String[] args) {
		System.out.println(System.nanoTime());
		
	}
}

class testCla{
	private String name="11111";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@org.junit.Test
	public void tt() {
		System.out.println("-----------");
		 Timer timer=new Timer();
		 timer.schedule(new Mytask(), 200,200);
		// timer.schedule(new Mytask2(), 2000, 3000);
	}
}

class Mytask extends TimerTask {
    @Override
    public void run()
    {
       
        System.out.println("我的任务运行了" +this.getClass().getName());
    }
}

class Mytask2 extends TimerTask {
    @Override
    public void run()
    {
       
        System.out.println("我的任务运行了" +this.getClass().getName());
    }
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		int i=0;
		while(i<1000) {
			i++;
		}
		
	}
	
}
