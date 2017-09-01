package com.diankangwo.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * DATE处理工具类
 * @author xiaoyu
 *
 */
public class DateUtil {
	public static int daysBetween(Date firstDate, Date secondDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(secondDate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	 public static String DateToMySQLDateTimeString(Date date)
	 {
	  final String[] MONTH = {
	    "Jan","Feb","Mar","Apr","May","Jun",
	    "Jul","Aug","Sep","Oct","Nov","Dec", 
	  };
	  StringBuffer ret = new StringBuffer();
	  String dateToString = date.toString();  //like "Sat Dec 17 15:55:16 CST 2005"
	  ret.append(dateToString.substring(24,24+4));//append yyyy
	  String sMonth = dateToString.substring(4,4+3);
	  for(int i=0;i<12;i++) {      //append mm 
	   if(sMonth.equalsIgnoreCase(MONTH[i])) {
	    if((i+1) < 10)
	     ret.append("-0");
	    else
	     ret.append("-");
	    ret.append((i+1));
	    break;
	   }
	  }
	  ret.append("-");
	  ret.append(dateToString.substring(8,8+2));
	  ret.append(" ");
	  ret.append(dateToString.substring(11,11+8));
	 
	  return ret.toString();
	 }
	 public static Date getNowDate() {
		   Date currentTime = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String dateString = formatter.format(currentTime);
		   ParsePosition pos = new ParsePosition(8);
		   Date currentTime_2 = formatter.parse(dateString, pos);
		   return currentTime_2;
		}
}
