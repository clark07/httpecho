package com.cs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by chensheng350 on 2017/7/7.
 */
public class GsonUtil {

	private static Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:dd").create();

	public static String toJson(Object object){
		return gson.toJson(object);
	}

	public static <T> T fromJson(String json, Class<T> cls){
		return gson.fromJson(json, cls);
	}

}
