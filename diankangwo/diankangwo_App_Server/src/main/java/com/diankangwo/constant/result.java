package com.diankangwo.constant;

import com.diankangwo.util.JSONUtils;

public class result {


	public String dataToJson(String code,String msg,String data){
		JSONUtils.toJSONString(data);
		return "";
	}
}
