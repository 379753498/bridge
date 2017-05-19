package com.zeone.bean;

import java.io.Serializable;

public class Sqlvlaue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String bridgename;
	private String equipmentid;
	private String equipmentname;
	private String devicePosition;
	private String gatewaynum;
	private String modularnum;
	private String pathnum;
	private String leixing;
	private int filerow;
	private int sqlrow;
	private int pl;
	private int num;
	private String datetime;
	private String filelx;

	public String getFilelx() {
		return filelx;
	}

	public void setFilelx(String filelx) {
		this.filelx = filelx;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPl() {
		return pl;
	}

	public void setPl(int pl) {
		this.pl = pl;
	}

	public String getBridgename() {
		return bridgename;
	}

	public void setBridgename(String bridgename) {
		this.bridgename = bridgename;
	}

	public String getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getEquipmentname() {
		return equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public String getDevicePosition() {
		return devicePosition;
	}

	public void setDevicePosition(String devicePosition) {
		this.devicePosition = devicePosition;
	}

	public String getGatewaynum() {
		return gatewaynum;
	}

	public void setGatewaynum(String gatewaynum) {
		this.gatewaynum = gatewaynum;
	}

	public String getModularnum() {
		return modularnum;
	}

	public void setModularnum(String modularnum) {
		this.modularnum = modularnum;
	}

	public String getPathnum() {
		return pathnum;
	}

	public void setPathnum(String pathnum) {
		this.pathnum = pathnum;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	
	public int getFilerow() {
		return filerow;
	}

	public void setFilerow(int filerow) {
		this.filerow = filerow;
	}

	public int getSqlrow() {
		return sqlrow;
	}

	public void setSqlrow(int sqlrow) {
		this.sqlrow = sqlrow;
	}

}
