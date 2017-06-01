package com.zeone.util;  

import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.Date;

import com.zeone.loadometer.CheckLoadoMeterImp;
  
public class LoadoMeterUitl {

	
	public static void main(String[] args) {
		CheckLoadoMeterImp checkloadometer = new CheckLoadoMeterImp();
		checkloadometer.write();
		String[] getdate = getdate(150);
		for (int i = 0; i < getdate.length; i++) {
			checkloadometer.init(getdate[i]);

		}
	
	}
	
	public static String[] getdate(int size)
	{

		   String str[] =new String [size];
		
		   for (int i = 0; i < str.length; i++) {
			   
			   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        Calendar lastDate = Calendar.getInstance();
		        lastDate.setTime(new Date());
		        lastDate.roll(Calendar.DAY_OF_YEAR, -i);//日期回滚7天
		        String a=sdf.format(lastDate.getTime());
		        str[i]=new String(a);
		        System.out.println(a);
		      
			
		}
	       
			return str;


	}
	
}
