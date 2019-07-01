import java.util.concurrent.ArrayBlockingQueue;

public class Test {
	public static void main(String[] args) {
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
	}
}
