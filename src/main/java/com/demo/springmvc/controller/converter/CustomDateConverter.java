package com.demo.springmvc.controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description: 自定义日期转换器</p>
 * @version 1.0
 */
public class CustomDateConverter implements Converter<String, Date> {


	public Date convert(String source) {
		
		try {
			//进行日期转换
			return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(source);
//			return new SimpleDateFormat("yyyy-MM-dd").parse(source);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
