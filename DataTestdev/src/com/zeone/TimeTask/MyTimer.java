package com.zeone.TimeTask;  

import java.util.Timer;
import java.util.TimerTask;
  
public class MyTimer {

	
	
	public static void main(String[] args) {
		
		TimerTask ts =new TimeTask();
		AutozhixingMethood(ts,0,1000);
		
	}
/**
 * 
 * 第一次延迟多久开始执行
 * 每延迟多久就再次循环执行
 * @param task
 * @param whenBeginLongtime
 * @param longtime  
 * @Description:
 */
	private static void AutozhixingMethood(TimerTask task ,long whenBeginLongtime ,long longtime) {
		Timer time= new Timer();
		time.schedule(task, whenBeginLongtime,longtime);
	}
	/**
	 * 在延时delay毫秒后执行task
	 * @param task
	 * @param whenBeginLongtime
	 * @param longtime  
	 * @Description:
	 */
	private static void zhidingTimeMethood(TimerTask task ,long longtime) {
		Timer time= new Timer();
		time.schedule(task, longtime);
	}
	
}
