<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
=======
import java.util.concurrent.ArrayBlockingQueue;
>>>>>>> branch 'master' of https://github.com/dongruguo/shot1.git

public class Test extends TimerTask {
	
	@Override
    public void run()
    {
        SimpleDateFormat sdf = null;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("当前时间：" + sdf.format(new Date()));

    }
	
	public static void main(String[] args) {
<<<<<<< HEAD
		List<String> l1 = new ArrayList<>();
		l1.add("l1");l1.add("l2");
		List<String> l2 = new ArrayList<>();
		l2.add("l2");
		Set<String> set = new HashSet<>();
		set.addAll(l1);set.addAll(l2);
		for(String str:set) {
			System.out.println(str);
		}
		
=======
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
		try {
			queue.put(10);
			queue.put(9);
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
			queue.put(8);
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class testCla{
	private String name="11111";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
>>>>>>> branch 'master' of https://github.com/dongruguo/shot1.git
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
