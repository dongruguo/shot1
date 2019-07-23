package com.wwd.main.fastJson;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastJsonTest {
	private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

	//json字符串-数组类型
	private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

	//复杂格式json字符串
	private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
	
	@Test
	public void testOne() {
		 JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

		 Map<String,Object> student  =  JSON.parseObject(JSON_OBJ_STR, Map.class);
		 System.out.println(student.get("studentName"));
	}
	
	@Test
	public void testTwo() {
		 JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		 System.out.println(jsonArray.get(0));
	}

}
