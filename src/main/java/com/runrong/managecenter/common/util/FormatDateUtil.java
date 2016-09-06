package com.runrong.managecenter.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 转化时间格式
 * @author yanyimin
 *
 */
public class FormatDateUtil {
	
	public static Date formatToMongoDate(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yyyy");
		
		
			Date time = null;
			//mongodb自带的时区问题
			try {
				 Calendar ca = Calendar.getInstance();
			     ca.setTime(sdf2.parse(date));
			     ca.add(Calendar.HOUR_OF_DAY, 8);
				time = sdf.parse(sdf.format(ca.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			return time;
	}
	
	public static String formatToFront(String date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=sdf2.format(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
//	public static void main(String[] args) throws ParseException {
//		
//		System.out.println(formatToFront("2015-10-1 00:00:00"));
//		
//		System.out.println(formatToMongoDate("2015-11-1"));
//	}
}
