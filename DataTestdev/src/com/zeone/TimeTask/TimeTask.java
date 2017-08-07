package com.zeone.TimeTask;  

import java.util.Date;
import java.util.TimerTask;

import com.zeone.Config;
import com.zeone.EquipText;
  
public class TimeTask  extends TimerTask{
	EquipText ex= new EquipText();
	int init;
	@Override
	
	public void run() {
		
		// TODO Auto-generated method stub  
		System.out.println(new Date()+"开始时间");
		try {
			 init = ex.init();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		System.out.println(new Date()+"结束时间");
		
		if(init==1)
		{
			
			this.cancel();
			Config.exectime=1000*6*60*60;
			TimerTask ts =new TimeTask();
			MyTimer.AutozhixingMethood(ts,Config.exectime,Config.exectime);
			System.out.println(Config.exectime);
		}
		else{
			this.cancel();
			Config.exectime=1000*60*60;
			TimerTask ts =new TimeTask();
			MyTimer.AutozhixingMethood(ts,Config.exectime,Config.exectime);
			System.out.println(Config.exectime);
		}
		
	}

}
