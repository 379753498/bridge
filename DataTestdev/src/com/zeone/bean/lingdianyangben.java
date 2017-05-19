package com.zeone.bean;

import java.io.Serializable;

public class lingdianyangben implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SensorData  SensorData;
	private double min;
	private double max ;
	private int size;
	private int maxsize;
	private String avg ;
	private String vluaetype ;
	private double zhanbi ;
	public SensorData getSensorData() {
		return SensorData;
	}
	public void setSensorData(SensorData sensorData) {
		SensorData = sensorData;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getMaxsize() {
		return maxsize;
	}
	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}
	public String getAvg() {
		return avg;
	}
	public void setAvg(String avg) {
		this.avg = avg;
	}
	public String getVluaetype() {
		return vluaetype;
	}
	public void setVluaetype(String vluaetype) {
		this.vluaetype = vluaetype;
	}
	public double getZhanbi() {
		return zhanbi;
	}
	public void setZhanbi(double zhanbi) {
		this.zhanbi = zhanbi;
	}
	

}
