package com.zeone.TimeTask;  

import java.util.Date;
import java.util.TimerTask;

import com.zeone.EquipText;
  
public class TimeTask  extends TimerTask{
	EquipText ex= new EquipText();
	@Override
	public void run() {
		// TODO Auto-generated method stub  
		System.out.println("aaa");
//		ex.init();
	System.out.println(new Date());
	}

}
