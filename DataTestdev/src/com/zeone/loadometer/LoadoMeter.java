package com.zeone.loadometer;  

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zeone.bean.LoadoMeterBean;
  
public class LoadoMeter {
	
	
	
	
	public static boolean checkShopSign(String shopSign)
	{  
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[京,津,渝,沪,冀,晋,辽,吉,黑,苏,浙,皖,闽,赣,鲁,豫,鄂,湘,粤,琼,川,贵,云,陕,秦,甘,陇,青,台,内蒙古,桂,宁,新,藏,澳,军,海,航,警][A-Z][0-9,A-Z]{5}$"); // 验证车牌号
		m = p.matcher(shopSign);
		b = m.matches();
		return b;
		
               
    }
	
	

	
	
	
	
public static void main(String[] args) {
	
	
	
	System.out.println(LoadoMeter.checkShopSign("皖AB4493"));
	
	LoadoMeterBean b= new LoadoMeterBean();
	
}
	
}
