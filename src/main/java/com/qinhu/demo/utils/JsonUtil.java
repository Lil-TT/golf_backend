package com.qinhu.demo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * JSON 工具类
 *
 * @author Administrator
 *
 */
public class JsonUtil {

	/**
	 * 对象转换JSON
	 *
	 * @param obj
	 * @return
	 */
	public static String objToJson(Object obj) {
		return new Gson().toJson(obj);
	}

	public static Object JsonToObj(String str, Class<?> clazz) {
		return new Gson().fromJson(str, clazz);
	}

	public static String fastObjToJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static Map<String, Object> fastJsonToObj(String str) {
		return JSON.parseObject(str, new TypeReference<Map<String, Object>>() {
		});
	}

	public static List<Map<String, Object>> fastJsonToList(String str) {
		return JSON.parseObject(str, new TypeReference<List<Map<String, Object>>>() {
		});
	}

	/**
	 * json数组字符串转换 map集合
	 *
	 * @param jsonList
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<Map<String, Object>> getConvertJsonListMap(String jsonList) {
		if (Tool.isEmpty(jsonList)) {
			return null;
		}
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(jsonList).getAsJsonArray();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (JsonElement obj : Jarray) {
			@SuppressWarnings("unchecked")
			Map<String, Object> cseMap = gson.fromJson(obj, Map.class);
			list.add(cseMap);
		}
		return list;
	}

}
