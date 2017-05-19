package com.zeone.bean;

import java.io.Serializable;

/**
 * @Title: 燃气数据bean
 * @Description:
 * @Author:Administrator
 * @Since:2017年3月6日
 * @Version:1.1.0
 */

public class RQSBbean implements Serializable {


	private static final String tablename = "gas_mon_realtimedata";

	/**
	 * @see 设备名称
	 */
	private String SEQUENCENUM;
	/**
	 * @see 时间
	 */
	private String MONITORTIME;
	/**
	 * @see 模块号
	 */
	private String modularnum;
	/**
	 * @see 通道号
	 */
	private String pathnum;
	/**
	 * @see 数据库条数
	 */
	private String Sqlrow;
	/**
	 * @see 传感器类型
	 */
	private String filelx;
	/**
	 * @see 厂家名称
	 */
	private String factory;
	private int filedataRow;

	public static String getTablename() {
		return tablename;
	}

	public String getSEQUENCENUM() {
		return SEQUENCENUM;
	}

	public void setSEQUENCENUM(String sEQUENCENUM) {
		SEQUENCENUM = sEQUENCENUM;
	}

	public String getMONITORTIME() {
		return MONITORTIME;
	}

	public void setMONITORTIME(String mONITORTIME) {
		MONITORTIME = mONITORTIME;
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

	public String getSqlrow() {
		return Sqlrow;
	}

	public void setSqlrow(String sqlrow) {
		Sqlrow = sqlrow;
	}

	public String getFilelx() {
		return filelx;
	}

	public void setFilelx(String filelx) {
		this.filelx = filelx;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public int getFiledataRow() {
		return filedataRow;
	}

	public void setFiledataRow(int filedataRow) {
		this.filedataRow = filedataRow;
	}



}