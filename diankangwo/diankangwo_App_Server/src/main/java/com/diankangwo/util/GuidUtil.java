package com.diankangwo.util;

import java.util.UUID;
/**
 *  GUID生成
 * @author xiaoyu
 *
 */
public class GuidUtil {

	public static String getGuid(){
		UUID uuid = UUID.randomUUID();
		String a = uuid.toString();
		a = a.toUpperCase();
		a = a.replaceAll("-", "");
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(getGuid());
	}
	
}
