package OneFiveOneTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Person implements Serializable
{
    String name;
    
    int age;
    
//    transient int age;    //此属性不可序列化
    
    double height;
    
    public Person(int age, String name, double height)
    {
        this.age = age;
        this.name = name;
        this.height = height;
    }
    
    public String toString()
    {
    return this.name + "," +this.age + "," + this.height;
    }
    
}

public class FinalTest implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//byte int chat float double Strig long short
	
	public  final String STS = new String("44444444444");
	
	
	

	private String initName() {
		// TODO Auto-generated method stub
		return "cccccc";
	} 
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		   {
			   System.out.println();
			 /*  FinalTest ft = new FinalTest();
		        //存入序列化的对象
		        FileOutputStream fos = new FileOutputStream("person.txt");
		        ObjectOutputStream oos = new ObjectOutputStream(fos);
		       
		        oos.writeObject(ft);
		        oos.writeObject(ft);
		        oos.close();*/
		    
		    ///////////////////////////////////////////////////////
		    
		        //取出序列化的对象
		      FileInputStream fn = new FileInputStream("person.txt");
		        ObjectInputStream ois = new ObjectInputStream(fn);
		    
		        while(fn.available() > 0)    //代表文件中还有内容
		        {
		        	FinalTest p = (FinalTest)ois.readObject();
		            System.out.println(p.STS+"sss"); 
		        }
		        fn.close();
		 
		    }
			
		
		
	}
	
}
