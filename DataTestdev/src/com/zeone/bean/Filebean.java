package com.zeone.bean;

import java.io.Serializable;

public class Filebean implements Serializable{

	
   	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getGatewaynum() {
		return Gatewaynum;
	}
	public void setGatewaynum(String gatewaynum) {
		Gatewaynum = gatewaynum;
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
	public String getTesttype() {
		return Testtype;
	}
	public void setTesttype(String testtype) {
		Testtype = testtype;
	}
	private String filename;
   	
   	
   	private String Gatewaynum;

	private String modularnum;
	private String pathnum;
	private String Testtype;
	
}
