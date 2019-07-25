import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestOne extends Thread{
	
	private static Logger log = LoggerFactory.getLogger(TestOne.class);
	
	private String nickName;
	private String lastName;
	public void Test(Object obj) {
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public static void main(String[] args) throws InterruptedException {
		log.info("info");
		log.debug("debug");
		log.error("错误error信息");
		log.warn("警告warn信息");
		
	}

}
