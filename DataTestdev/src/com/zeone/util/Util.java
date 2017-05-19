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
		
		int a=3;
		if (a==1)
		{
			getfilezy.getfile(filedate);//获取指定数据解压	
//			getfilezy.getfile("20170513");//获取指定数据解压	
//			getfilezy.getfile("20170514");//获取指定数据解压	
		}

	
		if (a == 3) 
		{

			String s[] = new String[10];
			s[0] = "繁华大道跨南淝河大桥";
			s[1] = "环巢湖路南淝河大桥";
			s[2] = "金寨路高架";
			s[3] = "派河大桥";
			s[4] = "206立交桥";

			FileRederTest fs = new FileRederTest();
			date = fs.init();
			if (date == null) 
			{
				date = sdf.format(new Date().getTime() - 1 * 24 * 60 * 60
						* 1000);
			}
			databiudmysql da = new databiudmysql();

			for (int i = 0; i < s.length; i++) 
			{
				da.testbaobiao(s[i], date, "bridgedatatestdev");
				da.testbaobiao(s[i], date, "bridgedatatestdevtz");
			}

		}
	}
}
