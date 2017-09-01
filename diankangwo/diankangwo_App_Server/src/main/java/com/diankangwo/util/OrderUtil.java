package com.diankangwo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单工具类，用来生成订单号
 * 
 * @author xiaoyu
 *
 */
public class OrderUtil {

	private static long orderNum = 0l;
	private static String date;

	/**
	 * 生成订单号
	 * 
	 * @return
	 */
	public static synchronized String getOrderNo() {
		String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
		if (date == null || !date.equals(str)) {
			date = str;
			orderNum = 0l;
		}
		orderNum++;
		long orderNo = Long.parseLong((date)) * 10000;
		orderNo += orderNum;
		return orderNo + "";
	}

}
