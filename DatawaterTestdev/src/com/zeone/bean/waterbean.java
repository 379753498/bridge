package com.zeone.bean;

import java.io.Serializable;

public class waterbean implements Serializable {

	/**
	 * @see date 数据日期
	 * 
	 */
	private String date;
	/**
	 * @see SerialNumber 序列号
	 * 
	 */
	private String SerialNumber;
	/**
	 * @see ManholeNumber 窨井位置信息
	 * 
	 */

	private String phoneNumber;

	private String ManholeNumber;
	/**
	 * @see Rutordtu 类型
	 * 
	 */
	private String Rutordtu;

	/**
	 * @see ZhongduanNumber 终端编码
	 * 
	 */
	private String ZhongduanNumber;
	/**
	 * @see yewuNumber 业务系统 编码
	 * 
	 */
	private String yewuNumber;
	/**
	 * @see lilunzhi 理论值
	 * 
	 */

	
	
	private String lilunzhi;
	/**
	 * @see caijiROw 采集平台数据量
	 * 
	 */
	private int caijiROw;
	/**
	 * @see yewuROw 业务系统数据量
	 * 
	 */
	private int yewuROw;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}

	public String getManholeNumber() {
		return ManholeNumber;
	}

	public void setManholeNumber(String manholeNumber) {
		ManholeNumber = manholeNumber;
	}

	public String getRutordtu() {
		return Rutordtu;
	}

	public void setRutordtu(String rutordtu) {
		Rutordtu = rutordtu;
	}

	public String getZhongduanNumber() {
		return ZhongduanNumber;
	}

	public void setZhongduanNumber(String zhongduanNumber) {
		ZhongduanNumber = zhongduanNumber;
	}

	public String getYewuNumber() {
		return yewuNumber;
	}

	public void setYewuNumber(String yewuNumber) {
		this.yewuNumber = yewuNumber;
	}

	public String getLilunzhi() {
		return lilunzhi;
	}

	public void setLilunzhi(String lilunzhi) {
		this.lilunzhi = lilunzhi;
	}

	public int getCaijiROw() {
		return caijiROw;
	}

	public void setCaijiROw(int caijiROw) {
		this.caijiROw = caijiROw;
	}

	public int getYewuROw() {
		return yewuROw;
	}

	public void setYewuROw(int yewuROw) {
		this.yewuROw = yewuROw;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
