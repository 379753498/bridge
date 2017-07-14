package com.zeone.bean;  

import java.util.Date;
  
public class MialBean {

	
	SensorData SensorData;
	
	
	 private long Pass;
	 private long history;
	 private String vaule;
	 private String passString;
	public SensorData getSensorData() {
		return SensorData;
	}
	public void setSensorData(SensorData sensorData) {
		SensorData = sensorData;
	}
	public long getPass() {
		return Pass;
	}
	public void setPass(long pass) {
		Pass = pass;
	}
	public long getHistory() {
		return history;
	}
	public void setHistory(long history) {
		this.history = history;
	}
	public String getVaule() {
		return vaule;
	}
	public void setVaule(String vaule) {
		this.vaule = vaule;
	}
	public String getPassString() {
		return passString;
	}
	public void setPassString(String passString) {
		this.passString = passString;
	}

	

}
