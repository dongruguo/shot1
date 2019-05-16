package suncn.collecion;

import java.util.HashMap;

public class SetTest1 {
	public static void main(String[] args) {
		HashMap<String ,String> hashMap = new HashMap<>();
		String s = hashMap.put("222", "333");

		s = hashMap.put("222", "333");
		System.out.println(s);
	}
}
