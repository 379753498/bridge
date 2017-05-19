package com.zeone.bean;

import java.io.Serializable;
import java.util.Map;

public class waterbasequipment implements Serializable {

	/**
	 * 
	 * select t.EQUIPMENTPOS 位置信息, t.EQUIPMENTNAME 传感器名称,c.DISTRICTNAME 所属区域 ,
	 * t.EQUIPMENTCODE 设备编码, b.DATA_NAME 传感器类型 ,t.equipmentid 业务系统编码 from
	 * water_bas_equipment t left join datadic_items b on b.id=t.equiptypecode
	 * left join CODE_BAS_DISTRICT c on t.DISTRICTCODE = c.DISTRICTCODE order by
	 * t.EQUIPMENTNAME asc ,t.EQUIPMENTCODE
	 * 
	 */
	private String EQUIPMENTNAME;
	private String DISTRICTNAME;
	private String EQUIPMENTCODE;
	private String DATA_NAME;
	private String equipmentid;
	private String RTUorDTU;
	private String caijirow;
	private String WANTROWS;
	
	public String getWANTROWS() {
		return WANTROWS;
	}

	public void setWANTROWS(String wANTROWS) {
		WANTROWS = wANTROWS;
	}

	private Map<String, String> dailyCntMap;
	
	public String getCaijirow() {
		return caijirow;
	}

	public void setCaijirow(String caijirow) {
		this.caijirow = caijirow;
	}

	private String EQUIPMENTPOS;

	public String getEQUIPMENTPOS() {
		return EQUIPMENTPOS;
	}

	public void setEQUIPMENTPOS(String eQUIPMENTPOS) {
		EQUIPMENTPOS = eQUIPMENTPOS;
	}

	public String getEQUIPMENTNAME() {
		return EQUIPMENTNAME;
	}

	public void setEQUIPMENTNAME(String eQUIPMENTNAME) {
		EQUIPMENTNAME = eQUIPMENTNAME;
	}

	public String getDISTRICTNAME() {
		return DISTRICTNAME;
	}

	public void setDISTRICTNAME(String dISTRICTNAME) {
		DISTRICTNAME = dISTRICTNAME;
	}

	public String getEQUIPMENTCODE() {
		return EQUIPMENTCODE;
	}

	public void setEQUIPMENTCODE(String eQUIPMENTCODE) {
		EQUIPMENTCODE = eQUIPMENTCODE;
	}

	public String getDATA_NAME() {
		return DATA_NAME;
	}

	public void setDATA_NAME(String dATA_NAME) {

		DATA_NAME = dATA_NAME;
		if (DATA_NAME.equals("应力监测仪") || DATA_NAME.equals("高频压力计"))

		{
			setRTUorDTU("DTU");
			
		} else if (DATA_NAME.equals("腐蚀监测仪")) {
			setRTUorDTU("null");
		} else {
			setRTUorDTU("RTU");
		}
		if(DATA_NAME.equals("应力监测仪"))
		{
			setWANTROWS("240");
		}
		if(DATA_NAME.equals("超声波插入式流量计"))
		{
			setWANTROWS("8640");
		}
		if(DATA_NAME.equals("压力计"))
		{
			setWANTROWS("8640");
		}
		if(DATA_NAME.equals("高频压力计"))
		{
			setWANTROWS("864000");
		}
		if(DATA_NAME.equals("漏失监测仪"))
		{
			setWANTROWS("1");
		}
		if(DATA_NAME.equals("腐蚀监测仪"))
		{
			setWANTROWS("48");
		}if(DATA_NAME.equals("电磁流量计"))
		{
			setWANTROWS("8640");
		}
		
		
	/**
	 * 	1	超声波插入式流量计 8640
	    2	压力计 8640
		3	高频压力计 864000
		4	电磁流量计 8640
		5	漏失监测仪 1
		6	腐蚀监测仪 48
		7	应力监测仪 240

	 */
		
	}

	public String getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getRTUorDTU() {
		return RTUorDTU;
	}

	public void setRTUorDTU(String rTUorDTU) {
		RTUorDTU = rTUorDTU;
	}

	public Map<String, String> getDailyCntMap() {
		return dailyCntMap;
	}

	public void setDailyCntMap(Map<String, String> dailyCntMap) {
		this.dailyCntMap = dailyCntMap;
	}

}
