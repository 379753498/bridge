package com.zeone.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.zeone.io.FileOperation;
import com.zeone.lifeline.collector.util.DateUtil;

public class tablemaxmin {


	public final static String DynamicDeflection = "动态挠度";// 动态挠度
	public final static String strain = "应变";// 应变
	public final static String temperature = "温度";// 温度
	public final static String windSpeed = "风速";// 风速
	public final static String windDirection = "风向";// 风向
	public final static String StaticDeflection = "静态挠度";// 静态挠度
	public final static String SuspenderForce = "吊杆力";// 吊杆力
	public final static String displacement = "位移";// 位移
	public final static String DipAngle = "倾角";// 倾角
	public final static String Jsd = "加速度";// 加速度

	
	
	
	
	public static void Dowirte(SensorData s,Map<String, String> value, String time)
	{
//		String time = sdf.format(new Date());
		long history = 0L;
		if(value.get("time") == null){
			history = 0;
		} else {
			history = Long.parseLong(value.get("time"));
		}
//		long history = Long.parseLong(value.get("time"));
		StringBuffer sb = new StringBuffer();
		sb.append(s.getBridgename()).append("\t");
		// sb.append(s.getEquipmentid()).append("\t");
		sb.append(s.getEquipmentname()).append("\t");
		// sb.append(s.getGatewaynum()).append("\t");
		sb.append(s.getModularnum()).append("\t");
		sb.append(s.getPathnum()).append("\t");
		sb.append(DateUtil.format(new Date(history), "yyyy-MM-dd HH:mm:ss")).append("\t");
		sb.append(value.get("value")).append("\n");


		FileOperation.writeTxFile(sb.toString(), time,"_超标数据");

	}

	public static  Double min_vlaue(String Sensortype) {

		if (Sensortype.equals(DynamicDeflection)) {

			return (double) -750;
		}

		if (Sensortype.equals(strain)) {

			return (double) -3000;
		}
		if (Sensortype.equals(temperature)) {

			return (double) -50;
		}
		if (Sensortype.equals(windSpeed)) {

			return (double) 0;
		}
		if (Sensortype.equals(windDirection)) {

			return (double) 0;
		}

		if (Sensortype.equals(StaticDeflection)) {

			return (double) -150;
		}
		if (Sensortype.equals(SuspenderForce)) {

			return (double) -3000;
		}
		if (Sensortype.equals(displacement)) {

			return (double) -375;
		}
		if (Sensortype.equals(DipAngle)) {

			return (double) -15;
		}
		if (Sensortype.equals(Jsd)) {

			return (double) -2000;
		}

		return (double) -99999;

	}
	
	public static  Double max_vlaue(String Sensortype) {
		if (Sensortype.equals(DynamicDeflection)) {

			return (double) 750;
		}

		if (Sensortype.equals(strain)) {

			return (double) 3000;
		}
		if (Sensortype.equals(temperature)) {

			return (double) 100;
		}
		if (Sensortype.equals(windSpeed)) {

			return (double) 50;
		}
		if (Sensortype.equals(windDirection)) {

			return (double) 360;
		}

		if (Sensortype.equals(StaticDeflection)) {

			return (double) 150;
		}
		if (Sensortype.equals(SuspenderForce)) {

			return (double) 3000;
		}
		if (Sensortype.equals(displacement)) {

			return (double) 375;
		}
		if (Sensortype.equals(DipAngle)) {

			return (double) 15;
		}
		if (Sensortype.equals(Jsd)) {

			return (double) 2000;
		}

		return (double) 99999;

	}
	
	public static  Integer max_frequency(String Sensortype) {
		if (Sensortype.equals(DynamicDeflection)) {

			return  8;
		}

		if (Sensortype.equals(strain)) {

			return  10;
		}
		if (Sensortype.equals(temperature)) {

			return  1;
		}
		if (Sensortype.equals(windSpeed)) {

			return  1;
		}
		if (Sensortype.equals(windDirection)) {

			return 1;
		}

		if (Sensortype.equals(StaticDeflection)) {

			return  1;
		}
		if (Sensortype.equals(SuspenderForce)) {

			return 1;
		}
		if (Sensortype.equals(displacement)) {

			return  10;
		}
		if (Sensortype.equals(DipAngle)) {

			return  1;
		}
		if (Sensortype.equals(Jsd)) {

			return  20;
		}

		return  99999;

	}
	
	
}
