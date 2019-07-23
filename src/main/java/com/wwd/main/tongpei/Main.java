package com.wwd.main.tongpei;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        firstInflate(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.clear();
        secondInflate(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        thirdInflate(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static void firstInflate(List<? super Integer> list) {// 装填整数
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void secondInflate(List<? super Float> list) {// 装填浮点数
        list.add(1.1f);
        list.add(2.2f);
        list.add(1.3f);
    }
    public static void thirdInflate(List<? super String> list) {// 装填浮点数
        list.add("aaaa");
        list.add("bbbbb");
        list.add("cccc");
    }
}
