package com.zeone.loadometer;  

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zeone.bean.LoadoMeterBean;
import com.zeone.lifeline.collector.util.DateUtil;
  
public class LoadoMeter {
	
	/**
	 * 检测车牌号码是否符合规定
	 * 
	 * @param LoadoMeterBean
	 * @return  
	 * @Description:
	 */
	
	
	public static boolean checkShopSign(LoadoMeterBean LoadoMeterBean)
	{  
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[京,津,渝,沪,冀,晋,辽,吉,黑,苏,浙,皖,闽,赣,鲁,豫,鄂,湘,粤,琼,川,贵,云,陕,秦,甘,陇,青,台,内蒙古,桂,宁,新,藏,澳,军,海,航,警][A-Z][0-9,A-Z]{5}$"); // 验证车牌号
		m = p.matcher(LoadoMeterBean.getPLATENO());
		b = m.matches();
		return b;
		
               
    }
	/**
	 * 
	 * 
	 * @param LoadoMeterBean
	 * @return   检测车辆的重量范围
	 * @Description:
	 */
	public static boolean checkVEHICLEWEIGHT(LoadoMeterBean LoadoMeterBean)
	{
		if(LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getVEHICLEWEIGHT())>=LoadoMeterinfo.VEHICLEWEIGHTmin()&&LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getVEHICLEWEIGHT())<=LoadoMeterinfo.VEHICLEWEIGHTmax())
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
    }

	
	/**
	 * 
	 * 
	 * @param LoadoMeterBean
	 * @return   检测车辆的轴数范围
	 * @Description:
	 */
	
	
	public static boolean checkAXLENUM(LoadoMeterBean LoadoMeterBean)
	{
		if(LoadoMeterinfo.StringtoInt(LoadoMeterBean.getAXLENUM())>=LoadoMeterinfo.AXLENUMmin()&&LoadoMeterinfo.StringtoInt(LoadoMeterBean.getAXLENUM())<=LoadoMeterinfo.AXLENUMmax())
		{
			return true;
		}
		else
		{
			return false;
		}
		
    }
	/**
	 * 
	 * 
	 * @param LoadoMeterBean
	 * @return  检测车辆轴距范围合规性
	 * @Description:
	 */
	public static boolean checkAXLEDISTANCE(LoadoMeterBean LoadoMeterBean)
	{
		if(LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getAXLEDISTANCE())>=LoadoMeterinfo.AXLEDISTANCETmin()&&LoadoMeterinfo.StringtoInt(LoadoMeterBean.getAXLEDISTANCE())<=LoadoMeterinfo.AXLEDISTANCETmax())
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
    }
	
	/**
	 * 
	 * 
	 * @param LoadoMeterBean
	 * @return  检测测试车速合理性
	 * @Description:
	 */
	
	
	public static boolean checkSPEED(LoadoMeterBean LoadoMeterBean)
	{
		if(LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getSPEED())>=LoadoMeterinfo.SPEEDmix()&&LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getSPEED())<=LoadoMeterinfo.SPEEDmax())
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
    }

	/**
	 * 
	 * 
	 * @param LoadoMeterBean
	 * @return   检测汽车加速度合规性
	 * @Description:
	 */
	
	public static boolean checkACCELERATION(LoadoMeterBean LoadoMeterBean)
	{
		if(LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getACCELERATION())>=LoadoMeterinfo.ACCELERATIONmix()&&LoadoMeterinfo.Stringtodouble(LoadoMeterBean.getACCELERATION())<=LoadoMeterinfo.ACCELERATIONmax())
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
    }
	/**
	 *  检测过车牌车辆类型是否正常
	 * 
	 * @param LoadoMeterBean
	 * @return  
	 * @Description:
	 */
	public static boolean checkPLATETYPE(LoadoMeterBean LoadoMeterBean)
	{
		String PLATETYPE=LoadoMeterBean.getPLATETYPE();
		
		int stringtoInt = LoadoMeterinfo.StringtoInt(PLATETYPE);
		
		if(stringtoInt>7||stringtoInt<1)
		{
			return false; 
		}
		else
		{
			return true;  	
		}
		
    }
	/**
	 * 检测车辆总重-限重 是否等于超载数；
	 * @param LoadoMeterBean
	 * @return  
	 * @Description:
	 */
	public static boolean checkMathCar(LoadoMeterBean LoadoMeterBean)
	{
		if (LoadoMeterBean.getISOVERWEIGHT().contains("1")) //判断是否是超载 如果不是超载就不需要进行验证
		{
			double VEHICLEWEIGHT = LoadoMeterinfo.Stringtodouble(LoadoMeterBean
					.getVEHICLEWEIGHT());

			double LIMITWEIGHT = LoadoMeterinfo.Stringtodouble(LoadoMeterBean
					.getLIMITWEIGHT());

			double OVERWEIGHT = LoadoMeterinfo.Stringtodouble(LoadoMeterBean
					.getOVERWEIGHT());
			
			Double number=LIMITWEIGHT+OVERWEIGHT;
			Double nnumber=VEHICLEWEIGHT;
			DecimalFormat df = new DecimalFormat("0.00");
			String CNY = df.format(number); // 6.20 这个是字符串，但已经是我要的两位小数了
			number = Double.parseDouble(CNY); // 6.20
			String C1NY = df.format(nnumber); // 6.20 这个是字符串，但已经是我要的两位小数了
			nnumber = Double.parseDouble(C1NY); //
			
			if (number.equals(nnumber)) 
			{
				return true;

			} 
			else 
			{
				return false;
			}

		} 
		else 
		{

			return true;

		}
               
    }
	/**
	 * 检测超载的图片是否都存在
	 * 
	 * @param LoadoMeterBean
	 * @return   返回1 代表有1个不存在  返回2 代表2个  返回 3 代表3个不存在  0代表正常
	 * @Description:
	 */
	public static int checkCarpath(LoadoMeterBean LoadoMeterBean)
	{	 int flag=0;
	
	
	if (LoadoMeterBean.getISOVERWEIGHT().contains("1")) 
	{
		
		
		 if(LoadoMeterBean.getHEADIMAGEURL()==null)
		 {
			 flag=flag+1;
			 
		 }
		 if(LoadoMeterBean.getBODYIMAGEURL()==null)
		 {
			 flag=flag+1;
			 
		 }
		 if(LoadoMeterBean.getTAILIMAGEURL()==null)
		 {
			 flag=flag+1;
			 
		 }
		 
		
	}
		return flag;  
		               
    }
	
	
	
	/**
	 * 
	 * @param LoadoMeterBean
	 * @return  检查拍摄时间和入库时间的差距 超过2分钟或者提前2分就算错误数据
	 * @Description:
	 */
	public static boolean checktime(LoadoMeterBean LoadoMeterBean)
	{
		String vehicletime = LoadoMeterBean.getVEHICLETIME();
		String uploadtime = LoadoMeterBean.getUPLOADTIME();
		String[] h2=uploadtime.split("\\.");
		String[] h=vehicletime.split("\\.");
		
		
		try {
			Date n1 = DateUtil.parse(h[0],"yyyy-MM-dd HH:mm:ss");
			Date n2 = DateUtil.parse(h2[0],"yyyy-MM-dd HH:mm:ss");
			long s1 = n2.getTime() - n1.getTime();

			if(s1>1000*120||s1<-1000*120)
			{
				return false;
			}
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		return true;

			

               
    }
	
	
	
	
	
	

	
}
