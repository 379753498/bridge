package com.zeone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zeone.bean.Frequency;
import com.zeone.bean.SensorData;
import com.zeone.bean.tablemaxmin;
import com.zeone.io.FileOperation;
import com.zeone.jdbc.SensorService;
import com.zeone.lifeline.collector.util.DateUtil;
import com.zeone.radis.RadisData;

public class EquipText<Static> {
	/** 保存设备信息 */
	private static List<SensorData> data = SensorService.getAllSensorInfo();

	/** 判断数据是否正常的时间依据（20分钟） */
	private final static int INTEVAL = 1000 * 60 * 11;// 变更5分钟
	/** 检查时间间隔（1小时） */
	private final static int INSPECT_INTEVAL = 3600000;
	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy年MM月dd日");// 时间为样式的文件名称
	static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
	static long nh = 1000 * 60 * 60;// 一小时的毫秒数
	static long nm = 1000 * 60;// 一分钟的毫秒数
	static long ns = 1000;// 一秒钟的毫秒数long
	// 获得两个时间的毫秒时间差异
	static String a;

	// private final static String PATH = "D://bridge_equipment//";
	/**
	 * @param args
	 */



	public  void init() {

			RadisData radis = new RadisData();
			System.out.println("开始检查桥梁中断数据"+sdf.format(new Date()));
			write(radis);
			System.out.println("开始检查桥梁错误数据"+sdf.format(new Date()));
			errorwrite(radis);
			System.out.println("开始检查桥梁超频数据"+sdf.format(new Date()));
			Frequency f = new Frequency();
			f.test(radis);
		
	}

	public static void write(RadisData radis) {
		String time = sdf.format(new Date());
		String prompt = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "中断数据检查结果：\n";
		String prop = "桥梁名称" + "\t" + "传感器名称" + "\t" + "模块号" + "\t" + "通道号"
				+ "\t" + "数据采集时间" + "\t" + "采集值" + "\t" + "累计中断时间" + "\n";
		FileOperation.writeTxFile(prompt, time, "_中断数据");
		FileOperation.writeTxFile(prop, time, "_中断数据");
		for (int i = 0; i < data.size(); i++) {
			SensorData s = data.get(i);
			
			Map<String, String> value = radis.getEquipData(s.getGatewaynum(),
					s.getModularnum(), s.getPathnum());
			Long history = 0L;
			Long pass = 0L;
			if(value.get("time")==null)
			{
				StringBuffer sb = new StringBuffer();
				sb.append(s.getBridgename()).append("\t");
				sb.append(s.getEquipmentname()).append("\t");
				sb.append(s.getModularnum()).append("\t");
				sb.append(s.getPathnum()).append("\t");
				sb.append(
						DateUtil.format(new Date(history),
								"yyyy-MM-dd HH:mm:ss")).append("\t");
				sb.append(value.get("value")).append("\t");
				sb.append(a).append("\n");
				FileOperation.writeTxFile(sb.toString(), time, "_没有接收到数据");	
			}
			
			if (value.get("time") != null) {
				history = Long.parseLong(value.get("time"));
				pass = new Date().getTime() - history;
				long day = pass / nd;// 计算差多少天
				long hour = pass % nd / nh;// 计算差多少小时
				long min = pass % nd % nh / nm;// 计算差多少分钟
				long sec = pass % nd % nh % nm / ns;// 计算差多少秒//输出结果
				a = day + "天" + hour + "小时" + min + "分钟" + sec + "秒";
			}
			if (pass > INTEVAL) {

				StringBuffer sb = new StringBuffer();
				sb.append(s.getBridgename()).append("\t");
				sb.append(s.getEquipmentname()).append("\t");
				sb.append(s.getModularnum()).append("\t");
				sb.append(s.getPathnum()).append("\t");
				sb.append(
						DateUtil.format(new Date(history),
								"yyyy-MM-dd HH:mm:ss")).append("\t");
				sb.append(value.get("value")).append("\t");
				sb.append(a).append("\n");
				FileOperation.writeTxFile(sb.toString(), time, "_中断数据");

			}
			
//			else{
//				StringBuffer sb = new StringBuffer();
//				sb.append(s.getBridgename()).append("\t");
//				sb.append(s.getEquipmentname()).append("\t");
//				sb.append(s.getModularnum()).append("\t");
//				sb.append(s.getPathnum()).append("\t");
//				sb.append(
//						DateUtil.format(new Date(history),
//								"yyyy-MM-dd HH:mm:ss")).append("\t");
//				sb.append(value.get("value")).append("\t");
//				sb.append("正常数据").append("\n");
//				FileOperation.writeTxFile(sb.toString(), time, "_中断数据");
//				
//			
//			
//			}
			
			
		}
		System.out.println("结束检查桥梁中断数据"+sdf.format(new Date()));
	}

	public static void errorwrite(RadisData radis) {
		String time = sdf.format(new Date());
		String prompt = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "超标数据检查结果：\n";
		String prop = "桥梁名称" + "\t" + "传感器名称" + "\t" + "模块号" + "\t" + "通道号"
				+ "\t" + "数据采集时间" + "\t" + "采集值" + "\n";

		FileOperation.writeTxFile(prompt, time, "_超标数据");
		FileOperation.writeTxFile(prop, time, "_超标数据");

		for (int i = 0; i < data.size(); i++) {
			SensorData s = data.get(i);
			Map<String, String> value = radis.getEquipData(s.getGatewaynum(),
					s.getModularnum(), s.getPathnum());

			find(s, value, time);

		}
		FileOperation.writeTxFile("\n\n\n\n", time, "_超标数据");
		System.out.println("结束检查桥梁错误数据"+sdf.format(new Date()));

	}

	public static void find(SensorData s, Map<String, String> value, String time) {

		if (value.get("time") == null) {
			System.out.println(s.getBridgename() + "\t" + value.get("value")
					+ "\t" + s.getEquipmentname() + "\t" + s.getModularnum()
					+ "\t" + s.getPathnum() + "\t"
					+ tablemaxmin.max_vlaue(s.getLeixing()) + "\t"
					+ tablemaxmin.min_vlaue(s.getLeixing()));

		}

		if (value.get("time") != null) {

			Double a = Double.valueOf(value.get("value"));
			// System.out.println(s.getBridgename()+"\t"+a+"\t"+s.getEquipmentname()+"\t"+tablemaxmin.max_vlaue(s.getLeixing())+"\t"+tablemaxmin.min_vlaue(s.getLeixing()));

			if (a > tablemaxmin.max_vlaue(s.getLeixing())
					|| a < tablemaxmin.min_vlaue(s.getLeixing())) {
				tablemaxmin.Dowirte(s, value, time);
				// System.out.println(s.getBridgename()+"\t"+a+"\t"+s.getEquipmentname()+"\t"+tablemaxmin.max_vlaue(s.getLeixing())+"\t"+tablemaxmin.min_vlaue(s.getLeixing()));

			}
		}

	}
}
