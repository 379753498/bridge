package com.zeone.bean;

import java.io.Serializable;

public class databaen implements Serializable{
	
	private String systime;
	private String datetime;
	private String level;
	private String VALUE;
	private String maxVALUE;
	private String minVALUE;
	private String avgVALUE;

	public String getMaxVALUE() {
		return maxVALUE;
	}
	public void setMaxVALUE(String maxVALUE) {
		this.maxVALUE = maxVALUE;
	}
	public String getMinVALUE() {
		return minVALUE;
	}
	public void setMinVALUE(String minVALUE) {
		this.minVALUE = minVALUE;
	}
	public String getAvgVALUE() {
		return avgVALUE;
	}
	public void setAvgVALUE(String avgVALUE) {
		this.avgVALUE = avgVALUE;
	}
	public String getSystime() {
		return systime;
	}
	public void setSystime(String systime) {
		this.systime = systime;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	
}
