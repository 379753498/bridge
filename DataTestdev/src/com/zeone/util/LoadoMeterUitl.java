package com.zeone.util;  

import java.text.SimpleDateFormat;
import java.util.Calendar;


import com.zeone.loadometer.CheckLoadoMeterImp;
  
public class LoadoMeterUitl {

	
	public static void main(String[] args) {
		CheckLoadoMeterImp checkloadometer= new CheckLoadoMeterImp();
		String[] getdate = getdate(30);
for (int i = 0; i < getdate.length-1; i++) {
	checkloadometer.init(getdate[i]);

}

	
	}
	
	public static String[] getdate(int size)
	{

		   String str[] =new String [size];
		   
		   for (int i = 0; i < size-1; i++) {
			   
			   
			   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        Calendar lastDate = Calendar.getInstance();
		        lastDate.roll(Calendar.DATE, -i);//日期回滚7天
		        String a=sdf.format(lastDate.getTime());
		        str[i]=new String(a);
		        System.out.println(a);
		      
			
		}
	       
			return str;


	}
	
}
