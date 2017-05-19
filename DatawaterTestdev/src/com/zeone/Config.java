package com.zeone;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Config {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static final int day=14+1;
	public static final  String date = sdf.format(new Date().getTime() );


}
