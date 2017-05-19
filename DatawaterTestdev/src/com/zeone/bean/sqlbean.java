package com.zeone.bean;

import java.io.Serializable;

public class sqlbean implements Serializable {

	private String SQlrow;
	private String EQUIPMENTNAME;
	public String getSQlrow() {
		return SQlrow;
	}
	public void setSQlrow(String sQlrow) {
		SQlrow = sQlrow;
	}
	public String getEQUIPMENTNAME() {
		return EQUIPMENTNAME;
	}
	public void setEQUIPMENTNAME(String eQUIPMENTNAME) {
		EQUIPMENTNAME = eQUIPMENTNAME;
	}
	
}
