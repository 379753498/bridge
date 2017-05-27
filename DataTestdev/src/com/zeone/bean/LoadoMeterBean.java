package com.zeone.bean;  

import java.io.Serializable;
  
public class LoadoMeterBean implements Serializable{
	/**
	 * @see车辆ID
	 */
	private String VEHICLEID;
	/**
	 * @see设备秘钥
	 */
	private String DEVICEKEY;
	/**
	 * @see设备编号
	 */
	private String INDEXCODE;
	/**
	 * @see过车点位
	 */
	private String VEHICLEPOINT;
	/**
	 * @see车牌号码
	 */
	private String PLATENO;
	/**
	 * @see车牌类型
	 */
	private String PLATETYPE;
	/**
	 * @see车辆重量(单位吨，保留2位小数)
	 */
	private String VEHICLEWEIGHT;
	/**
	 * @see是否超限(1-是，0-否)
	 */
	private String ISOVERWEIGHT;
	/**
	 * @see超限重量(单位吨，保留2位小数)
	 */
	private String OVERWEIGHT;
	/**
	 * @see限制重量(单位吨，保留2位小数)
	 */
	private String LIMITWEIGHT;
	/**
	 * @see车辆轴数
	 */
	private String AXLENUM;
	/**
	 * @see轴重(单位吨，多个轴以(,)逗号分隔，保留2位小数)

	 */
	private String AXLEWEIGHT;
	/**
	 * @see车辆轴距(保留2位小数)
	 */
	private String AXLEDISTANCE;
	/**
	 * @see车辆轴组数
	 */
	private String AXLEGROUPNUM;
	/**
	 * @see车辆轴组重(保留2位小数)
	 */
	private String AXLEGROUPWEIGHT;
	/**
	 * @see车辆车速(单位km/h,保留2位小数)
	 */
	private String SPEED;
	/**
	 * @see车辆加速度(保留2位小数)
	 */
	private String ACCELERATION;
	/**
	 * @see车辆车道号(车辆行驶方向最左车道为01，由左向右顺序编号)

	 */
	private String LANENO;
	/**
	 * @see车辆过车时间
	 */
	private String VEHICLETIME;
	/**
	 * @see车辆置信度
	 */
	private String CONFIDENCELEVEL;
	/**
	 * @see车头图片路径
	 */
	private String HEADIMAGEURL;
	/**
	 * @see	车身图片路径
	 */
	private String BODYIMAGEURL;
	/**
	 * @see车尾图片路径
	 */
	private String TAILIMAGEURL;
	/**
	 * @see上传时间
	 */
	private String UPLOADTIME;
	/**
	 * @see设备ID
	 */
	private String EQUIPMENTID;
	/**
	 * @see	桥梁ID
	 */
	private String BRIDGEID;
	
	
	public String getVEHICLEWEIGHT() {
		return VEHICLEWEIGHT;
	}
	public void setVEHICLEWEIGHT(String vEHICLEWEIGHT) {
		VEHICLEWEIGHT = vEHICLEWEIGHT;
	}
	public String getVEHICLEID() {
		return VEHICLEID;
	}
	public void setVEHICLEID(String vEHICLEID) {
		VEHICLEID = vEHICLEID;
	}
	public String getDEVICEKEY() {
		return DEVICEKEY;
	}
	public void setDEVICEKEY(String dEVICEKEY) {
		DEVICEKEY = dEVICEKEY;
	}
	public String getINDEXCODE() {
		return INDEXCODE;
	}
	public void setINDEXCODE(String iNDEXCODE) {
		INDEXCODE = iNDEXCODE;
	}
	public String getVEHICLEPOINT() {
		return VEHICLEPOINT;
	}
	public void setVEHICLEPOINT(String vEHICLEPOINT) {
		VEHICLEPOINT = vEHICLEPOINT;
	}
	public String getPLATENO() {
		return PLATENO;
	}
	public void setPLATENO(String pLATENO) {
		PLATENO = pLATENO;
	}
	public String getPLATETYPE() {
		return PLATETYPE;
	}
	public void setPLATETYPE(String pLATETYPE) {
		PLATETYPE = pLATETYPE;
	}
	public String getISOVERWEIGHT() {
		return ISOVERWEIGHT;
	}
	public void setISOVERWEIGHT(String iSOVERWEIGHT) {
		ISOVERWEIGHT = iSOVERWEIGHT;
	}
	public String getOVERWEIGHT() {
		return OVERWEIGHT;
	}
	public void setOVERWEIGHT(String oVERWEIGHT) {
		OVERWEIGHT = oVERWEIGHT;
	}
	public String getLIMITWEIGHT() {
		return LIMITWEIGHT;
	}
	public void setLIMITWEIGHT(String lIMITWEIGHT) {
		LIMITWEIGHT = lIMITWEIGHT;
	}
	public String getAXLENUM() {
		return AXLENUM;
	}
	public void setAXLENUM(String aXLENUM) {
		AXLENUM = aXLENUM;
	}
	public String getAXLEWEIGHT() {
		return AXLEWEIGHT;
	}
	public void setAXLEWEIGHT(String aXLEWEIGHT) {
		AXLEWEIGHT = aXLEWEIGHT;
	}
	public String getAXLEDISTANCE() {
		return AXLEDISTANCE;
	}
	public void setAXLEDISTANCE(String aXLEDISTANCE) {
		AXLEDISTANCE = aXLEDISTANCE;
	}
	public String getAXLEGROUPNUM() {
		return AXLEGROUPNUM;
	}
	public void setAXLEGROUPNUM(String aXLEGROUPNUM) {
		AXLEGROUPNUM = aXLEGROUPNUM;
	}
	public String getAXLEGROUPWEIGHT() {
		return AXLEGROUPWEIGHT;
	}
	public void setAXLEGROUPWEIGHT(String aXLEGROUPWEIGHT) {
		AXLEGROUPWEIGHT = aXLEGROUPWEIGHT;
	}
	public String getSPEED() {
		return SPEED;
	}
	public void setSPEED(String sPEED) {
		SPEED = sPEED;
	}
	public String getACCELERATION() {
		return ACCELERATION;
	}
	public void setACCELERATION(String aCCELERATION) {
		ACCELERATION = aCCELERATION;
	}
	public String getLANENO() {
		return LANENO;
	}
	public void setLANENO(String lANENO) {
		LANENO = lANENO;
	}
	public String getVEHICLETIME() {
		return VEHICLETIME;
	}
	public void setVEHICLETIME(String vEHICLETIME) {
		VEHICLETIME = vEHICLETIME;
	}
	public String getCONFIDENCELEVEL() {
		return CONFIDENCELEVEL;
	}
	public void setCONFIDENCELEVEL(String cONFIDENCELEVEL) {
		CONFIDENCELEVEL = cONFIDENCELEVEL;
	}
	public String getHEADIMAGEURL() {
		return HEADIMAGEURL;
	}
	public void setHEADIMAGEURL(String hEADIMAGEURL) {
		HEADIMAGEURL = hEADIMAGEURL;
	}
	public String getBODYIMAGEURL() {
		return BODYIMAGEURL;
	}
	public void setBODYIMAGEURL(String bODYIMAGEURL) {
		BODYIMAGEURL = bODYIMAGEURL;
	}
	public String getTAILIMAGEURL() {
		return TAILIMAGEURL;
	}
	public void setTAILIMAGEURL(String tAILIMAGEURL) {
		TAILIMAGEURL = tAILIMAGEURL;
	}
	public String getUPLOADTIME() {
		return UPLOADTIME;
	}
	public void setUPLOADTIME(String uPLOADTIME) {
		UPLOADTIME = uPLOADTIME;
	}
	public String getEQUIPMENTID() {
		return EQUIPMENTID;
	}
	public void setEQUIPMENTID(String eQUIPMENTID) {
		EQUIPMENTID = eQUIPMENTID;
	}
	public String getBRIDGEID() {
		return BRIDGEID;
	}
	public void setBRIDGEID(String bRIDGEID) {
		BRIDGEID = bRIDGEID;
	}

}
