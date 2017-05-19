package com.zeone.data;

import java.io.Serializable;

public class databiud implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bridgename;
	private String equipmentname;
	private String Pathnum;
	private String modularnum;
	public 	String leixing;
	private String  zhongduanshijian;
	public 	String nowdate;
	private int chongfushujugeshu;
	public 	int leijizhongduanshijian;
	private int filerow;
	private int lilunfilerow;
	private int timesize;
	private int lilunsize;
	private int pl;
	private int lilunpl;
	private int zhongduanshuju;
	private int chaochuliangchenggeshu ;
	private int lishishujutiaoshu;
	private int weilaishujutiaoshu;
	private int shujujieshoushijianyichangzongshu;
	private Double cuowuPLzhanbi;
	private Double leijizhongduanshijianzhanbi;
	private Double chongfushujzhanbi;
	private Double chaochuliangchengfanweizhanbi;
	private Double jieshouyichangzongshuzhanbi;
	
	public String getBridgename() {
		return bridgename;
	}
	public void setBridgename(String bridgename) {
		this.bridgename = bridgename;
	}
	public String getEquipmentname() {
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	public String getPathnum() {
		return Pathnum;
	}
	public void setPathnum(String pathnum) {
		Pathnum = pathnum;
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
	public String getZhongduanshijian() {
		return zhongduanshijian;
	}
	public void setZhongduanshijian(String zhongduanshijian) {
		this.zhongduanshijian = zhongduanshijian;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public int getChongfushujugeshu() {
		return chongfushujugeshu;
	}
	public void setChongfushujugeshu(int chongfushujugeshu) {
		this.chongfushujugeshu = chongfushujugeshu;
	}
	public int getLeijizhongduanshijian() {
		return leijizhongduanshijian;
	}
	public void setLeijizhongduanshijian(int leijizhongduanshijian) {
		this.leijizhongduanshijian = leijizhongduanshijian;
	}
	public int getFilerow() {
		return filerow;
	}
	public void setFilerow(int filerow) {
		this.filerow = filerow;
	}
	public int getLilunfilerow() {
		return lilunfilerow;
	}
	public void setLilunfilerow(int lilunfilerow) {
		this.lilunfilerow = lilunfilerow;
	}
	public int getTimesize() {
		return timesize;
	}
	public void setTimesize(int timesize) {
		this.timesize = timesize;
	}
	public int getLilunsize() {
		return lilunsize;
	}
	public void setLilunsize(int lilunsize) {
		this.lilunsize = lilunsize;
	}
	public int getPl() {
		return pl;
	}
	public void setPl(int pl) {
		this.pl = pl;
	}
	public int getLilunpl() {
		return lilunpl;
	}
	public void setLilunpl(int lilunpl) {
		this.lilunpl = lilunpl;
	}
	public int getZhongduanshuju() {
		return zhongduanshuju;
	}
	public void setZhongduanshuju(int zhongduanshuju) {
		this.zhongduanshuju = zhongduanshuju;
	}
	public int getChaochuliangchenggeshu() {
		return chaochuliangchenggeshu;
	}
	public void setChaochuliangchenggeshu(int chaochuliangchenggeshu) {
		this.chaochuliangchenggeshu = chaochuliangchenggeshu;
	}
	public int getLishishujutiaoshu() {
		return lishishujutiaoshu;
	}
	public void setLishishujutiaoshu(int lishishujutiaoshu) {
		this.lishishujutiaoshu = lishishujutiaoshu;
	}
	public int getWeilaishujutiaoshu() {
		return weilaishujutiaoshu;
	}
	public void setWeilaishujutiaoshu(int weilaishujutiaoshu) {
		this.weilaishujutiaoshu = weilaishujutiaoshu;
	}
	public int getShujujieshoushijianyichangzongshu() {
		return shujujieshoushijianyichangzongshu;
	}
	public void setShujujieshoushijianyichangzongshu(
			int shujujieshoushijianyichangzongshu) {
		this.shujujieshoushijianyichangzongshu = shujujieshoushijianyichangzongshu;
	}
	public Double getCuowuPLzhanbi() {
		return cuowuPLzhanbi;
	}
	public void setCuowuPLzhanbi(Double cuowuPLzhanbi) {
		this.cuowuPLzhanbi = cuowuPLzhanbi;
	}
	public Double getLeijizhongduanshijianzhanbi() {
		return leijizhongduanshijianzhanbi;
	}
	public void setLeijizhongduanshijianzhanbi(Double leijizhongduanshijianzhanbi) {
		this.leijizhongduanshijianzhanbi = leijizhongduanshijianzhanbi;
	}
	public Double getChongfushujzhanbi() {
		return chongfushujzhanbi;
	}
	public void setChongfushujzhanbi(Double chongfushujzhanbi) {
		this.chongfushujzhanbi = chongfushujzhanbi;
	}
	public Double getChaochuliangchengfanweizhanbi() {
		return chaochuliangchengfanweizhanbi;
	}
	public void setChaochuliangchengfanweizhanbi(
			Double chaochuliangchengfanweizhanbi) {
		this.chaochuliangchengfanweizhanbi = chaochuliangchengfanweizhanbi;
	}
	public Double getJieshouyichangzongshuzhanbi() {
		return jieshouyichangzongshuzhanbi;
	}
	public void setJieshouyichangzongshuzhanbi(Double jieshouyichangzongshuzhanbi) {
		this.jieshouyichangzongshuzhanbi = jieshouyichangzongshuzhanbi;
	}
	

	
}
