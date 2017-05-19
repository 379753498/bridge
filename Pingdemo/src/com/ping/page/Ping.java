package com.ping.page;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Ping

{

	public boolean pingtest(String ip) 
	{
		String line = null;
		ArrayList<String> ls= new ArrayList<String>();
		String command = "ping  " + ip;
 boolean la=false;
		try 
		{
//			System.out.println(ip);
			Process pro = Runtime.getRuntime().exec(command);
			BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream(), Charset.forName("GBK")));
			while ((line = buf.readLine()) != null)
			{ls.add(line);
			System.out.print(line.toString() + "\r\n");
				if(line.contains("回复")){
					
					la=true;
					break;
					
				}
			}
			
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}
		if(la)
		{
			
			return true;
			
		}else{
			return false;
		}


	}
}
