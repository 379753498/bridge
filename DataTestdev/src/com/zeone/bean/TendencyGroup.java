package com.zeone.bean;  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


  
public class TendencyGroup {
	
	
	private ArrayList<HashMap<String, Double>>lb= new ArrayList<HashMap<String,Double>>();


	public ArrayList<HashMap<String, Double>> getLb() {
		return lb;
	}
	public void setLb(ArrayList<HashMap<String, Double>> lb) {
		this.lb = lb;
	}
	private SensorData sa;

	private TreeMap<Integer, ArrayList<String>> tmp =new TreeMap<Integer, ArrayList<String>>();
	public TreeMap<Integer, ArrayList<String>> getTmp() {
		return tmp;
	}
	public void setTmp(TreeMap<Integer, ArrayList<String>> tmp) {
		this.tmp = tmp;
	}



	


	

	/**
	 * @see als记录波峰
	 */

	public SensorData getSa() {
		return sa;
	}
	public void setSa(SensorData sa) {
		this.sa = sa;
	}
}
