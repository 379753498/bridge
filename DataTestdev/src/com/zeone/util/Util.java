package com.zeone.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zeone.io.FileRederTest;
import com.zeone.jdbc.databiudmysql;

public class Util {
	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");
	private final static SimpleDateFormat sdf1 = new SimpleDateFormat(
			"yyyyMMdd");
	static String date = sdf.format(new Date().getTime() - 1 * 24 * 60 * 60
			* 1000);
	static String filedate = sdf1.format(new Date().getTime() - 1 * 24 * 60 * 60* 1000);
	public static void main(String[] args) throws Throwable 
	{
		
	
	
			FileRederTest fs = new FileRederTest();
			date = fs.init();
		
		
	}
}
