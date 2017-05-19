package com.zeone.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import com.zeone.bean.SensorData;
import com.zeone.bean.Sqlvlaue;
import com.zeone.bean.tablemaxmin;
import com.zeone.jdbc.SensorService;
import com.zeone.jdbc.sqlvlaueService;

public class FileRederTest {
	private static List<SensorData> data = new ArrayList<SensorData>();
	static int filedataRow = 0;
	static String Bridgename;
	static String Equipmentname;
	static String type;
	static int pl;
	private static ArrayList<String> filelist = new ArrayList<String>();
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static int i = 0;
	static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
	static String date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);

	public static int getTextLines4(String path) throws IOException {

		InputStream is = new BufferedInputStream(new FileInputStream(path));

		byte[] c = new byte[1024];
		int count = 0;
		int readChars = 0;
		while ((readChars = is.read(c)) != -1) {
			for (int i = 0; i < readChars; ++i) {
				if (c[i] == '\n')
					++count;
			}
		}
		is.close();
		return count - 13;
	}

	/**
	 * 获取文件行数的方法
	 * 
	 * */
	private static int getTextLines(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(
				file));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,
				"utf-8"), 5 * 1024 * 1024);
		int totalLines = 0;
		String al;
		while (true) {
			al = br.readLine();
			if (al == null)

			{
				break;
			} else if (al.indexOf("#") > -1) {
				continue;
			} else {
				totalLines++;
			}

		}
		br.close();
		fis.close();

		return totalLines - 13;
	}

	/**
	 * 比较日期返回天数方法
	 * 
	 * */
	public static int getBetweenDay(Date date1, Date date2) {
		Calendar d1 = new GregorianCalendar();
		d1.setTime(date1);
		Calendar d2 = new GregorianCalendar();
		d2.setTime(date2);
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			// d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 主方法
	 * 
	 * */
	static List<Sqlvlaue> li;

	public static void main(String[] args) throws IOException,
			InterruptedException, ParseException {
		Date pass = new Date();
		test(date);

		while (true) {
			Thread.sleep(1000);
			while (getBetweenDay(pass, new Date()) == 1) {

				date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);
				pass = new Date();
				test(date);
				// sqlvlaueService.getAllsqlrows(li);
			}
		}
	}

	/**
	 * 获取目标文件列表的方法
	 * 
	 * */
	static ArrayList<String> getFiles(String filePath) {
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file.getAbsolutePath());

			} else {
				filelist.add(file.getAbsolutePath());

			}

		}

		return filelist;
	}

	/**
	 * 执行分析文件数据 加工报表
	 * 
	 * */
	static List<Sqlvlaue> test(final String date) throws IOException {

		System.out.println(date);
		String path = "D://collector-data//" + date + "//bridge";// 定义文件路径
		// String path = "D://collector-data//" + date +
		// "//bridge//HF_JZXY_00000007";// 定义文件路径

		getFiles(path);
		filelist.size();

		System.out.println(filelist.size());
		System.out.println("开始时间" + new Date());

		Iterator<String> it1 = filelist.iterator();

		StringBuffer sb = new StringBuffer();
		sb.append("桥梁名称" + "\t");// 桥梁名称
		sb.append("桥梁主机号" + "\t");// 桥梁主机号
		sb.append("模块号" + "\t");// 模块号
		sb.append("通道号" + "\t");// 通道号
		sb.append("测量值类型" + "\t");// 测量值类型
		sb.append("传感器名称" + "\t");// 传感器名称
		sb.append("频率" + "\t");// 频率
		sb.append("数据类型" + "\t");// 数据类型
		sb.append("数据时间" + "\t");// 数据时间
		sb.append("理论总条数" + "\t");// 理论总条数
		sb.append("实际统计条数" + "\t");// 实际统计条数
		sb.append("差距条数" + "\n");// 差距条数

		FileOperation.writeTxFile(sb.toString(), date, "_桥梁数据统计");
		List<Sqlvlaue> data = new ArrayList<Sqlvlaue>();

		while (it1.hasNext()) {

			String path1 = it1.next();
			filedataRow = FileRederTest.getTextLines(path1);
			String[] s1 = path1.split("\\\\");// 第一次加工
			String s2 = s1[5];// 取出文件名
			String[] s3 = s2.split("_");
			String s4 = s3[5];
			String filelx = s4.substring(1, 2);

			if (filelx.equals("0")) {
				filelx = "单测量值";

			} else if (filelx.equals("1")) {
				filelx = "双测量值";
			} else if (filelx.equals("3")) {
				filelx = "特征值";
			} else if (filelx.equals("4")) {
				filelx = "傅立叶变换值";
			} else {
				filelx = "null";
			}

			String Gatewaynum = s3[0] + "_" + s3[1] + "_" + s3[2];
			String modularnum = s3[3];
			String pathnum = s3[4];
			SensorData s = FileRederTest.getSensorData(Gatewaynum, modularnum,
					pathnum);

			if (s != null) {
				System.out.println(s.getEquipmentname());
				type = s.getLeixing();
				s.setFilepath(path1);
				Bridgename = s.getBridgename();
				Equipmentname = s.getEquipmentname();
				pl = tablemaxmin.max_frequency(type);
			} else {
				System.out.println("没找到");

				type = "没找到";
				Bridgename = "没找到";
				Equipmentname = "没找到";
				pl = 0;
			}
			int num;
			int num_a;
			// 如果是单测量值 赋予pl不变 否则pl=0
			if (filelx.equals("单测量值")) {
				num = 60 * 60 * 24 * pl;
				num_a = num - filedataRow;
			} else {
				pl = 0;
				num = 0;
				num_a = 0;
			}

			StringBuffer sb2 = new StringBuffer();
			sb2.append(Bridgename + "\t");// 桥梁名称
			sb2.append(Gatewaynum + "\t");// 桥梁主机号
			sb2.append(modularnum + "\t");// 模块号
			sb2.append(pathnum + "\t");// 通道号
			sb2.append(filelx + "\t");// 测量值类型
			sb2.append(Equipmentname + "\t");// 传感器名称
			sb2.append(pl + "\t");// 频率
			sb2.append(type + "\t");// 数据类型
			sb2.append(date + "\t");// 数据时间
			sb2.append(num + "\t");// 理论值
			sb2.append(filedataRow + "\t");// 实际数据总数
			sb2.append(num_a + "\n");// 差距值
			FileOperation.writeTxFile(sb2.toString(), date, "_桥梁数据统计");
			System.out.print(++i);
			System.out.println(new Date());
			Sqlvlaue Sql = new Sqlvlaue();
			Sql.setBridgename(Bridgename);
			Sql.setGatewaynum(Gatewaynum);
			Sql.setEquipmentname(Equipmentname);
			Sql.setFilerow(filedataRow);
			Sql.setModularnum(modularnum);
			Sql.setPathnum(pathnum);
			Sql.setPl(pl);
			Sql.setNum(num);
			Sql.setLeixing(type);
			Sql.setDatetime(date);
			Sql.setFilelx(filelx);
			data.add(Sql);

		}
		return data;
	}

	/**
	 * 通过模块号 通道号.获取SensorData 实体对象
	 * 
	 * */
	public static SensorData getSensorData(String Gatewaynum,
			String Modularnum, String Pathnum) {
		data = SensorService.getAllSensorInfo();
		for (int i = 0; i < data.size(); i++) {
			SensorData s = data.get(i);
			if (s.getGatewaynum().equals(Gatewaynum)
					&& s.getModularnum().equals(Modularnum)
					&& s.getPathnum().equals(Pathnum)) {
				return s;
			}
		}

		return null;

	}
}
