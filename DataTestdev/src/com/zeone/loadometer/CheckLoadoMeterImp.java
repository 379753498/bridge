package com.zeone.loadometer;  

import java.util.ArrayList;

import com.zeone.bean.LoadMeterdata;
import com.zeone.bean.LoadoMeterBean;
import com.zeone.io.FileOperation;
import com.zeone.jdbc.LoadoMeterOacle;
  
public class CheckLoadoMeterImp {

	
	

	
	  public void init(String  date)
	  {
		  
		  ArrayList<LoadoMeterBean> allLoadoMeterBean = LoadoMeterOacle.getAllLoadoMeterBean(date);
		  LoadMeterdata Loaddata= new LoadMeterdata();
		  for (LoadoMeterBean loadoMeterBean : allLoadoMeterBean) 
		  {		
			  if(loadoMeterBean.getISOVERWEIGHT().contains("1"))
			  {
				  Loaddata.setLoadMetersize(Loaddata.getLoadMetersize()+1);
			  }
			  
			  
			  boolean checkShopSign = LoadoMeter.checkShopSign(loadoMeterBean);
			  if(!checkShopSign)
			  {
				  StringBuffer nb = new StringBuffer();
					nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车牌识别错误明细表");
				  Loaddata.setPLATENOSize(Loaddata.getPLATENOSize()+1);
			  }
			  
			  
			  boolean checkVEHICLEWEIGHT = LoadoMeter.checkVEHICLEWEIGHT(loadoMeterBean);
			  if(!checkVEHICLEWEIGHT)
			  {
				  StringBuffer nb = new StringBuffer();
					nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getVEHICLEWEIGHT()+"车重数据").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车重数据错误明细表");
				  Loaddata.setVEHICLEWEIGHTSize(Loaddata.getVEHICLEWEIGHTSize()+1);
			  }
			  
			  boolean checkAXLENUM = LoadoMeter.checkAXLENUM(loadoMeterBean);
			  if(!checkAXLENUM)
			  {
				  StringBuffer nb = new StringBuffer();
					nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getAXLENUM()+"车辆的轴数").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车辆的轴数数据错误明细表");
				  Loaddata.setAXLENUMSize(Loaddata.getAXLENUMSize()+1);
			  }
			  
			  boolean checkAXLEDISTANCE = LoadoMeter.checkAXLEDISTANCE(loadoMeterBean);
			  if(!checkAXLEDISTANCE)
			  {
				  StringBuffer nb = new StringBuffer();
					nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getAXLEDISTANCE()+"车辆轴距").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车辆轴距数据错误明细表");
				  Loaddata.setAXLEDISTANCESize(Loaddata.getAXLEDISTANCESize()+1);
			  }
			  
			  boolean checkSPEED = LoadoMeter.checkSPEED(loadoMeterBean);
			  if(!checkSPEED)
			  {
				  StringBuffer nb = new StringBuffer();
					nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getSPEED()+"车辆速度").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车辆速度数据错误明细表");
				  Loaddata.setSPEEDSize(Loaddata.getSPEEDSize()+1);
			  }
			  boolean checkACCELERATION = LoadoMeter.checkACCELERATION(loadoMeterBean);
			  if(!checkACCELERATION)
			  {
				  StringBuffer nb = new StringBuffer();
					nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getACCELERATION()+"车辆加速度").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车辆加速度数据错误明细表");
				  Loaddata.setACCELERATIONSize(Loaddata.getACCELERATIONSize()+1);
			  }
			  boolean checkPLATETYPE = LoadoMeter.checkPLATETYPE(loadoMeterBean);
			 
			  
			  
			  if(!checkPLATETYPE)
			  {
				  StringBuffer nb = new StringBuffer();
				  nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getPLATETYPE()+"车牌类型").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "车辆类型错误明细表");
				  Loaddata.setPLATETYPESize(Loaddata.getPLATETYPESize()+1);
			  }
			  
			  boolean checkMathCar = LoadoMeter.checkMathCar(loadoMeterBean);
			  if(!checkMathCar)
			  {
				  StringBuffer nb = new StringBuffer();
				  nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getPLATETYPE()+"车牌类型").append("\t");
					nb.append(loadoMeterBean.getVEHICLEWEIGHT()+"车总重").append("\t");
					nb.append(loadoMeterBean.getLIMITWEIGHT()+"限制重量").append("\t");
					nb.append(loadoMeterBean.getOVERWEIGHT()+"超载重量").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "超载重量计算错误明细表");
				  Loaddata.setMathCarSize(Loaddata.getMathCarSize()+1);
			  }
			  int checkCarpath = LoadoMeter.checkCarpath(loadoMeterBean);
			  if(checkCarpath>0)
			  {
				  StringBuffer nb = new StringBuffer();
				  nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getPLATETYPE()+"车牌类型").append("\t");
					nb.append(loadoMeterBean.getHEADIMAGEURL()+"头部照片路径").append("\t");
					nb.append(loadoMeterBean.getBODYIMAGEURL()+"车身照片路径").append("\t");
					nb.append(loadoMeterBean.getTAILIMAGEURL()+"尾部照片路径").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "超载图片数据错误明细表");
				  Loaddata.setCheckCarpathSize(Loaddata.getCheckCarpathSize()+1);
			  }
			  
			  boolean checktime = LoadoMeter.checktime(loadoMeterBean);
			  
			  if(!checktime)
			  {
				  StringBuffer nb = new StringBuffer();
				  nb.append(loadoMeterBean.getPLATENO()+"车牌号码").append("\t");
					nb.append(loadoMeterBean.getPLATETYPE()+"车牌类型").append("\t");
					nb.append(loadoMeterBean.getVEHICLETIME()+"过车时间").append("\t");
					nb.append(loadoMeterBean.getUPLOADTIME()+"数据上传时间").append("\n");
				  FileOperation.writeTxFile(nb.toString(),date, "拍摄时间戳数据错误明细表");
				  Loaddata.setChecktimesize(Loaddata.getChecktimesize()+1);
			  }
			  Loaddata.setAllSize(Loaddata.getAllSize()+1);
			  
		  }
		  
		  	
		  
		  StringBuffer lnb = new StringBuffer();
		  lnb.append(date).append("\t");
		  
		  lnb.append(String.valueOf(Loaddata.getLoadMetersize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getAllSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getPLATENOSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getVEHICLEWEIGHTSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getAXLENUMSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getAXLEDISTANCESize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getSPEEDSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getACCELERATIONSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getPLATETYPESize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getMathCarSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getCheckCarpathSize())).append("\t");
		  lnb.append(String.valueOf(Loaddata.getChecktimesize())).append("\n");
	  		
	  FileOperation.writeTxFile(lnb.toString(),"_", "地磅数据汇总表明细表");

		  
		  
		  
	  }
	public  void write()
	{
		StringBuffer nb = new StringBuffer();
 		 nb.append("日期").append("\t");
 		 nb.append("总超载数").append("\t");
 		 nb.append("总车数").append("\t");
 		 nb.append("车牌识别错误").append("\t");
 		 nb.append("车重数据错误").append("\t");
 		 nb.append("轴数错误").append("\t");
 		 nb.append("轴距错误").append("\t");
 		 nb.append("速度数据错误").append("\t");
 		 nb.append("加速度数据错误").append("\t");
 		 nb.append("车辆类型错误").append("\t");
 		 nb.append("超载重量计算错误").append("\t");
 		 nb.append("图片数据错误错误").append("\t");
 		 nb.append("时间戳数据错误").append("\n");
 FileOperation.writeTxFile(nb.toString(),"_", "地磅数据汇总表明细表");
	}
	
}
