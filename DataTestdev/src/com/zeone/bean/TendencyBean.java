package com.zeone.bean;  
  
public class TendencyBean {

	 private SensorData sa;
	 private String min;
	 private String max;
	 private String avg;
	 private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public SensorData getSa() {
		return sa;
	}

	public void setSa(SensorData sa) {
		this.sa = sa;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
}
