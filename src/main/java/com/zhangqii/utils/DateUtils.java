package com.zhangqii.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String CurrentDay(){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String date=format.format(new Date());
		return date;
	}
}
