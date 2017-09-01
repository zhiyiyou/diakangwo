package com.diankangwo.constant;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.sf.json.JSONArray;

/**
 * json返回数据工具类
 * @author xiaoyu
 *
 */
public class resultMsg {
	
	public static String mapToJson(String code,String msg,Object data){
		Map<String, Object> mapJson = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().serializeNulls().create();
		mapJson.put("code",code);
		mapJson.put("msg", msg);
		if (data == null) {
			mapJson.put("data", new JSONArray());
		}else{
			mapJson.put("data", data);
		}
		return gson.toJson(mapJson);
	}
}
