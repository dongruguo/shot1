package tongpei;

import java.util.ArrayList;
import java.util.List;

public class HolderTP<T> {
	
	private T holder;

	public void setHolder(T holder) {
		this.holder = holder;
	}

	public T getHolder() {
		return holder;
	}

	public HolderTP() {

	}

	public HolderTP(T holder) {
		this.holder = holder;
	}
	public static void main(String[] args) {
		
		HolderTP<String> tp1 = new HolderTP<>("qqqqq");
		HolderTP<Integer> tp2 = new HolderTP<>(11);
		System.out.println(tp1.getClass() == tp2.getClass());
		
	}

}
