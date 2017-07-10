package com.zeone.bean;  
  
public class Sensordata14 {

	private  String bridgename;
	
	private  String EQUIPMENTID;
	private  String equipmentname;
	public String getEquipmentname() {
		return equipmentname;
	}
	@Override
	public String toString() {
		return "Sensordata14 [bridgename=" + bridgename + ", EQUIPMENTID="
				+ EQUIPMENTID + ", equipmentname=" + equipmentname
				+ ", gatewaynum=" + gatewaynum + ", Device_Position="
				+ Device_Position + ", Manufacturer=" + Manufacturer
				+ ", pathnum=" + pathnum + ", modularnum=" + modularnum
				+ ", leixing=" + leixing + "]";
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	private  String gatewaynum;
	private  String Device_Position;
	private  String Manufacturer;
	private  String pathnum;
	private  String modularnum;
	private  String  leixing;
	public String getBridgename() {
		return bridgename;
	}
	public void setBridgename(String bridgename) {
		this.bridgename = bridgename;
	}
	public String getEQUIPMENTID() {
		return EQUIPMENTID;
	}
	public void setEQUIPMENTID(String eQUIPMENTID) {
		EQUIPMENTID = eQUIPMENTID;
	}
	public String getGatewaynum() {
		return gatewaynum;
	}
	public void setGatewaynum(String gatewaynum) {
		this.gatewaynum = gatewaynum;
	}
	public String getDevice_Position() {
		return Device_Position;
	}
	public void setDevice_Position(String device_Position) {
		Device_Position = device_Position;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getPathnum() {
		return pathnum;
	}
	public void setPathnum(String pathnum) {
		this.pathnum = pathnum;
	}
	public String getModularnum() {
		return modularnum;
	}
	public void setModularnum(String modularnum) {
		this.modularnum = modularnum;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	
	
}
