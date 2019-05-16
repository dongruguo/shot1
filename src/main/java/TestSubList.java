import java.util.ArrayList;
import java.util.List;

public class TestSubList {
		public static void main(String[] args) {
			 List<String> parentList = new ArrayList<String>();
		        
		        for(int i = 0; i < 5; i++){
		            parentList.add(String.valueOf(i));
		        }
		        
		        List<String> subList = parentList.subList(1, 3);
		        for(String s : subList){
		            System.out.println(s);//output: 1, 2
		        }
		        System.out.println("-----------");//output: 1, 2
		        //non-structural modification by sublist, reflect parentList
		        subList.set(0, "new 1"); 
		        for(String s : parentList){
		            System.out.println(s);//output: 0, new 1, 2, 3, 4
		        }
		        System.out.println("-----------");//output: 1, 2
		        //structural modification by sublist, reflect parentList
		        subList.add(String.valueOf(2.5));
		        for(String s : parentList){
		            System.out.println(s);//output:0, new 1, 2,    2.5, 3,    4
		        }
		        
		        //non-structural modification by parentList, reflect sublist
		        parentList.set(2, "new 2");
		        for(String s : subList){
		            System.out.println(s);//output: new 1, new 2
		        }
		        
		        //structural modification by parentList, sublist becomes undefined(throw exception)
		        parentList.add("undefine");
//		        for(String s : subList){
//		            System.out.println(s);
//		        }
//		        subList.get(0);
		}
}
