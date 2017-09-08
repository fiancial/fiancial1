package com.xyy.springmvc.mybatis.test;

import com.xyy.springmvc.mybatis.beans.Student;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

 

public class Test {

	public static void main(String[] args) {

		String strJson = "{\"id\":123,\"stuName\":\"stuName\",\"password\":\"machineType\",\"sex\":1,\"age\":22,\"dt\":2017-1-1}";
		String strArr = "[{\"id\":123,\"stuName\":\"stuName\",\"password\":\"machineType\",\"sex\":1,\"age\":22},{\"id\":123,\"stuName\":\"stuName\",\"password\":\"machineType\",\"sex\":1,\"age\":22},{\"id\":123,\"stuName\":\"stuName\",\"password\":\"machineType\",\"sex\":1,\"age\":22}]";
		// 1、使用JSONObject
		JSONObject jsonObject = JSONObject.fromObject(strJson);
		Student  stu = (Student ) JSONObject.toBean(jsonObject, Student.class);
		// 2、使用JSONArray
		JSONArray jsonArray = JSONArray.fromObject(strArr);
		// 获得jsonArray的第i个元素
		int i = 0;
		for (Object object : jsonArray) {
			i++;
			Object o = object;
			JSONObject jsonObject2 = JSONObject.fromObject(o);
			Student stu2 = (Student) JSONObject.toBean(jsonObject2,
					Student.class);
			System.out.println("stu2:" + i + ":" + stu2);
		}

		System.out.println("stu:" + stu);
	}

}
