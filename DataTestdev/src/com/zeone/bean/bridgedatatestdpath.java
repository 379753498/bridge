package com.zeone.bean;

import java.io.Serializable;

public class bridgedatatestdpath implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String bridgename;
	private String equipmentid;
	private String gatewaynum;
	private String equipmentname;
	private String Pathnum;
	private String modularnum;
	private String leixing;
	private String nowdate;
	private String NAME;
	private double avg;
	private double filerow;
	private double maxvle;
	private double minvle;
	public double getAvg() 
	{
		return avg;
	}
	public void setAvg(double avg) 
	{
		this.avg = avg;
	}
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public String getBridgename() 
	{
		return bridgename;
	}
	public void setBridgename(String bridgename)
	{
		this.bridgename = bridgename;
	}
	public String getEquipmentid() 
	{
		return equipmentid;
	}
	public void setEquipmentid(String equipmentid) 
	{
		this.equipmentid = equipmentid;
	}
	public String getGatewaynum() 
	{
		return gatewaynum;
	}
	public void setGatewaynum(String gatewaynum) 
	{
		this.gatewaynum = gatewaynum;
	}
	public String getEquipmentname() 
	{
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) 
	{
		this.equipmentname = equipmentname;
	}
	public String getPathnum() 
	{
		return Pathnum;
	}
	public void setPathnum(String pathnum) 
	{
		Pathnum = pathnum;
	}
	public String getModularnum() 
	{
		return modularnum;
	}
	public void setModularnum(String modularnum) 
	{
		this.modularnum = modularnum;
	}
	public String getLeixing() 
	{
		return leixing;
	}
	public void setLeixing(String leixing) 
	{
		this.leixing = leixing;
	}
	public String getNowdate() 
	{
		return nowdate;
	}
	public void setNowdate(String nowdate) 
	{
		this.nowdate = nowdate;
	}
	public String getNAME() 
	{
		return NAME;
	}
	public void setNAME(String nAME) 
	{
		NAME = nAME;
	}
	public double getFilerow() 
	{
		return filerow;
	}
	public void setFilerow(double filerow) 
	{
		this.filerow = filerow;
	}
	public double getMaxvle() 
	{
		return maxvle;
	}
	public void setMaxvle(double maxvle)
	{
		this.maxvle = maxvle;
	}
	public double getMinvle() 
	{
		return minvle;
	}
	public void setMinvle(double minvle) 
	{
		this.minvle = minvle;
	}
}
