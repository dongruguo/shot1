import java.util.ArrayList;
import java.util.List;

public class TestTPF<A> {
	public  void getSys(List<A> a) {
		for(A aa: a) {
			System.out.println(aa);
		}
	}
	public static void main(String[] args) {
		TestTPF<String> tt = new TestTPF<>();
		List<String> aa = new ArrayList<>();
		aa.add("aaa");aa.add("bbb");aa.add("cccc");
		tt.getSys(aa);
	}

}
