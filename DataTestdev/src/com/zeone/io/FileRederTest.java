package com.zeone.io;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import SendMail.Mailutil;

import com.zeone.bean.SensorData;
import com.zeone.data.databiud;
import com.zeone.jdbc.SensorService;
import com.zeone.txt.imp.FileFactoryReadimp;

public class FileRederTest {

	static int filedataRow = 0;
	static String Bridgename;
	static String Equipmentname;
	static String type;
	static int pl;
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static int i = 0;
	static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
	static String date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);
	private static FileFactoryReadimp fa;
	private static ArrayList<String> filelist = new ArrayList<String>();
	private static ArrayList<SensorData> SensorData = SensorService
			.getAllSensorInfo();

	public String init() throws Throwable {

		fa = new FileFactoryReadimp();
		date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);
//		date="20170506";
		String dev=test(date);
		StringBuffer sb2 = new StringBuffer();
		sb2.append("桥梁名称" + "\t");
		sb2.append("传感器名称" + "\t");
		sb2.append("传感器类型" + "\t");
		sb2.append("模块号" + "\t");
		sb2.append("通道号" + "\t");
		sb2.append("实际数据行数" + "\t");
		sb2.append("理论数据行数" + "\t");
		sb2.append("理论频率" + "\t");
		sb2.append("错误频率数" + "\t");
		sb2.append("错误频率占比" + "\t");
		sb2.append("中断数据次数" + "\t");
		sb2.append("累计中断时间" + "\t");
		sb2.append("累计中断时间占比" + "\t");
		sb2.append("重复数据个数" + "\t");
		sb2.append("重复数据占比" + "\t");
		sb2.append("超出量程范围数据个数" + "\t");
		sb2.append("超出量程范围数据占比" + "\t");
		sb2.append("数据接收异常数据总数" + "\t");
		sb2.append("数据接收异常数据总数占比" + "\n");
		FileOperation.writeTxFile(sb2.toString(), date, "实时值分析数据汇总");
		if (FileFactoryReadimp.datatest.size() > 0) {

			for (databiud databiud : FileFactoryReadimp.datatest) {
				StringBuffer sb = new StringBuffer();
				sb.append(databiud.getBridgename()).append("\t");
				sb.append(databiud.getEquipmentname()).append("\t");
				sb.append(databiud.getLeixing()).append("\t");
				sb.append(databiud.getModularnum()).append("\t");
				sb.append(databiud.getPathnum()).append("\t");
				sb.append(databiud.getFilerow()).append("\t");
				sb.append(databiud.getLilunfilerow()).append("\t");
				sb.append(databiud.getLilunpl()).append("\t");
				sb.append(databiud.getPl()).append("\t");
				sb.append(databiud.getCuowuPLzhanbi()).append("\t");
				sb.append(databiud.getZhongduanshuju()).append("\t");
				sb.append(databiud.getZhongduanshijian()).append("\t");
				sb.append(databiud.getLeijizhongduanshijianzhanbi()).append(
						"\t");
				sb.append(databiud.getChongfushujugeshu()).append("\t");
				sb.append(databiud.getChongfushujzhanbi()).append("\t");
				sb.append(databiud.getChaochuliangchenggeshu()).append("\t");
				sb.append(databiud.getChaochuliangchengfanweizhanbi()).append(
						"\t");
				sb.append(databiud.getShujujieshoushijianyichangzongshu())
						.append("\t");
				sb.append(databiud.getJieshouyichangzongshuzhanbi()).append(
						"\n");
				FileOperation.writeTxFile(sb.toString(), date, "实时值分析数据汇总");

			}
			
			Session sessioninit = Mailutil.Sessioninit();
			MimeMessage createMimeMessage = Mailutil.createMimeMessages(sessioninit, FileFactoryReadimp.datatest);
			Mailutil.Send(sessioninit, createMimeMessage,Mailutil.getAddres());
			
			
			

		}
		StringBuffer sb22 = new StringBuffer();
		sb22.append("桥梁名称" + "\t");
		sb22.append("传感器名称" + "\t");
		sb22.append("传感器类型" + "\t");
		sb22.append("模块号" + "\t");
		sb22.append("通道号" + "\t");
		sb22.append("实际数据行数" + "\t");
		sb22.append("理论数据行数" + "\t");
		sb22.append("理论频率" + "\t");
		sb22.append("错误频率数" + "\t");
		sb22.append("错误频率占比" + "\t");
		sb22.append("中断数据次数" + "\t");
		sb22.append("累计中断时间" + "\t");
		sb22.append("累计中断时间占比" + "\t");
		sb22.append("重复数据个数" + "\t");
		sb22.append("重复数据占比" + "\t");
		sb22.append("超出量程范围数据个数" + "\t");
		sb22.append("超出量程范围数据占比" + "\t");
		sb22.append("数据接收异常数据总数" + "\t");
		sb22.append("数据接收异常数据总数占比" + "\n");
		FileOperation.writeTxFile(sb22.toString(), date, "特征值分析数据汇总");
		if (FileFactoryReadimp.datatesttzz.size() > 0) {

			for (databiud databiud : FileFactoryReadimp.datatesttzz) {
				StringBuffer sb = new StringBuffer();
				sb.append(databiud.getBridgename()).append("\t");
				sb.append(databiud.getEquipmentname()).append("\t");
				sb.append(databiud.getLeixing()).append("\t");
				sb.append(databiud.getModularnum()).append("\t");
				sb.append(databiud.getPathnum()).append("\t");
				sb.append(databiud.getFilerow()).append("\t");
				sb.append(databiud.getLilunfilerow()).append("\t");
				sb.append(databiud.getLilunpl()).append("\t");
				sb.append(databiud.getPl()).append("\t");
				sb.append(databiud.getCuowuPLzhanbi()).append("\t");
				sb.append(databiud.getZhongduanshuju()).append("\t");
				sb.append(databiud.getZhongduanshijian()).append("\t");
				sb.append(databiud.getLeijizhongduanshijianzhanbi()).append(
						"\t");
				sb.append(databiud.getChongfushujugeshu()).append("\t");
				sb.append(databiud.getChongfushujzhanbi()).append("\t");

				sb.append(databiud.getChaochuliangchenggeshu()).append("\t");

				sb.append(databiud.getChaochuliangchengfanweizhanbi()).append(
						"\t");
				sb.append(databiud.getShujujieshoushijianyichangzongshu())
						.append("\t");
				sb.append(databiud.getJieshouyichangzongshuzhanbi()).append(
						"\n");
				FileOperation.writeTxFile(sb.toString(), date, "特征值分析数据汇总");
			}

		}

		System.out.println("统计完毕等待中！！！！");
		return dev;
	}

	/**
	 * 执行分析文件数据 加工报表
	 * 
	 * @throws Throwable
	 * 
	 * */

	static String  test(final String date) throws Throwable {


		System.out.println(date);
		String path = "D://bridge";// 定义文件路径
//		String path = "Z://"+date+"//bridge";// 定义文件路径
		filelist = fa.getfilenames(path);
		System.out.println(filelist.size());
		System.out.println("开始时间" + new Date());
		Iterator<String> it1 = filelist.iterator();
		String nowdatea=null;
		while (it1.hasNext()) {

			String path1 = it1.next();
			System.out.println(path1+"开始时间" + new Date());
			fa.getfilename(path1);

			String a = fa.getGatewaynum();
			String b = fa.getmodularnum();
			String c = fa.getpathnum();
			
			if (fa.getTesttype().equals("单测量值")
					|| fa.getTesttype().equals("双测量值")) {
				SensorData sa = getSensorData(a, b, c);
				System.out.println(path1+"开始读取时间" + new Date());
				filedataRow = fa.getfilerow(path1);
				System.out.println(path1+"完成读取时间" + new Date());
				nowdatea=fa.getmap(sa, filedataRow);

			} 
			else if (fa.getTesttype().equals("特征值")) {

				SensorData sb = getSensorData(a, b, c);
				System.out.println(path1+"开始读取时间" + new Date());
				filedataRow = fa.getfilerow(path1);
				System.out.println(path1+"完成读取时间" + new Date());

				nowdatea=fa.gettezhengzhi(sb, filedataRow);

			}

		}
		return nowdatea;
		
	
	}

	public static SensorData getSensorData(String Gatewaynum,
			String Modularnum, String Pathnum) {
		for (SensorData s : SensorData) {
			if (s.getGatewaynum().equals(Gatewaynum)
					&& s.getModularnum().equals(Modularnum)
					&& s.getPathnum().equals(Pathnum)) {
				return s;
			}
		}
		return null;
	}

	public static SensorData getSensorData2(String bridgename,
			String Modularnum, String Pathnum) {
		for (SensorData s : SensorData) {
			if (s.getBridgename().equals(bridgename)
					&& s.getModularnum().equals(Modularnum)
					&& s.getPathnum().equals(Pathnum)) {
				return s;
			}
		}
		return null;
	}
}
