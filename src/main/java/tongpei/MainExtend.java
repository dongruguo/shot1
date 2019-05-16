package tongpei;
import java.util.ArrayList;
import java.util.List;

public class MainExtend {
    public static void main(String[] args) {
        firstPrint();
        secondPrint();
    }

    public static void firstPrint() {
        List<Float> list1 = new ArrayList<>();//使用 Float作实参类型
        list1.add(12.3f);
        list1.add(23.4f);
        print(list1);
    }

    public static void secondPrint() {
        List<Integer> list2 = new ArrayList<>();//使用Integer作实参类型
        list2.add(1);
        list2.add(2);
        list2.add(3);
        print(list2);
    }

    public static void print(List<? extends Number> list) {// 通配符作形参
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));// 使用get方法
        }
    }
}

