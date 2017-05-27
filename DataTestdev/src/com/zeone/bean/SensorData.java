package com.zeone.bean;

import java.io.Serializable;

public class SensorData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String bridgename;
	private String equipmentid;
	private String equipmentname;
	private String devicePosition;
	private String gatewaynum;
	private String modularnum;
	private String pathnum;
	private String leixing;
	private String filepath;
	private int filerow;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public int getFilerow() {
		return filerow;
	}

	public void setFilerow(int filerow) {
		this.filerow = filerow;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
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

}
