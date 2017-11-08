package com.zhangqii.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class TagDateConverter implements Converter<String, Date> {


	public Date convert(String val) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {

			return sdf.parse(val);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
