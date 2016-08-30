package com.runrong.managecenter.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * json工具
 */
public class JsonUtil {
	
	/**
	 * 将对象转化为JSON
	 * @param o
	 * @return
	 */
	public static JSON getJsonFromObject(Object o){
		JSONObject json=(JSONObject) JSON.toJSON(o);
		return json;
	}
}
