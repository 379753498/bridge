package com.zeone.bean;

import java.io.Serializable;
import java.util.ArrayList;



public class FileDataBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<databaen> ArrayListdatabaen;
	
	private SensorData SensorData;

	public ArrayList<databaen> getArrayListdatabaen() {
		return ArrayListdatabaen;
	}

	public void setArrayListdatabaen(ArrayList<databaen> arrayListdatabaen) {
		ArrayListdatabaen = arrayListdatabaen;
	}

	public SensorData getSensorData() {
		return SensorData;
	}

	public void setSensorData(SensorData sensorData) {
		SensorData = sensorData;
	}
	
}
