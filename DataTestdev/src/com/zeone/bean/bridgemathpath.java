package com.zeone.bean;

import java.io.Serializable;

public class bridgemathpath implements Serializable {
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * CREATE TABLE `bridgedatatestdpath` (
	`id`   INT(11) NOT NULL AUTO_INCREMENT,
   `bridgename` VARCHAR (150),
    `equipmentid` VARCHAR (150),
    `gatewaynum` VARCHAR (150),
  `equipmentname` VARCHAR (150),
  `Pathnum` VARCHAR  (150),
  `modularnum` VARCHAR (150),
  `leixing` VARCHAR (150),
  `nowdate` VARCHAR (150),
   `NAME` VARCHAR (150),
 `avg` DOUBLE,
 `filerow` DOUBLE,
 `maxvle` DOUBLE,
 `minvle` DOUBLE,
 PRIMARY KEY (`id`)
) ;


	 * 
	 */

	private static final long serialVersionUID = 1L;

	private String bridgename;
	private String equipmentid;
	private String equipmentname;
	private String gatewaynum;
	private String modularnum;
	private String pathnum;
	private String leixing;
	private String Nowdate;
	private String name;
	private double avg;
	private double filerow;
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
	public String getNowdate() {
		return Nowdate;
	}
	public void setNowdate(String nowdate) {
		Nowdate = nowdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getFilerow() {
		return filerow;
	}
	public void setFilerow(double filerow) {
		this.filerow = filerow;
	}
	
	




}
