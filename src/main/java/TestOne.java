import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class TestOne implements Serializable{
	
	private static Logger log = LoggerFactory.getLogger(TestOne.class);
	
	private String nickName;
	
	private String lastName;
	

}
