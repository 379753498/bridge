package com.zeone.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.zeone.bean.RQSBbean;
import com.zeone.jdbc.RQSBbeanService;

public class RQFileRederTest {

	private static  List<RQSBbean> ls = new ArrayList<RQSBbean>();

	private static ArrayList<String> filelist = new ArrayList<String>();

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static int i = 0;
	static long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数

	public static int getTextLines(String path) throws IOException {

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

	public static int getTextLines2(String path) throws IOException {
		FileReader fr = new FileReader(path); // 这里定义一个字符流的输入流的节点流，用于读取文件（一个字符一个字符的读取）
		BufferedReader br = new BufferedReader(fr);
		// 在定义好的流基础上套接一个处理流，用于更加效率的读取文件（一行一行的读取）
		int x = 0; // 用于统计行数，从0开始
		while (br.readLine() != null) { // readLine()方法是按行读的，返回值是这行的内容
			x++; // 每读一行，则变量x累加1
		}
		br.close();
		fr.close();
		return x - 13; // 返回总的行数

	}

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

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Date pass = new Date();

		String date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);

//		printlist(test(date));
		while (true) {
			Thread.sleep(10000);
			while (getBetweenDay(pass, new Date()) == 1)

			{
				pass = new Date();
				date = sdf.format(new Date().getTime() - 24 * 60 * 60 * 1000);
				printlist(test(date));
			}
		}
	}

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

	static ArrayList<RQSBbean> test(String date) throws IOException {
		System.out.println(date);
		String path = "D://collector-data//" + date + "//gas";// 定义文件路径

		getFiles(path);
		filelist.size();

		System.out.println(filelist.size());
		System.out.println("开始时间" + new Date());

		Iterator<String> it1 = filelist.iterator();

		while (it1.hasNext()) {

			String path1 = it1.next();

			int filedataRow = getTextLines1(path1);

			String[] s1 = path1.split("\\\\");// 第一次加工
			String s2 = s1[(s1.length - 1)];// 取出文件名
			String[] s3 = s2.split("_");
			String s4 = s3[s3.length - 1];
			String filelx = s4.substring(1, 2);

			if (filelx.equals("0")) {
				filelx = "CH4";

			} else if (filelx.equals("1")) {
				filelx = "C2H6";
			} else if (filelx.equals("2")) {
				filelx = "H2S";
			} else if (filelx.equals("3")) {
				filelx = "CO";
			} else if (filelx.equals("4")) {
				filelx = "温度";
			} else {

			}

			String SEQUENCENUM = s3[0] + "_" + s3[1] + "_" + s3[2];
			String modularnum = s3[1];
			String pathnum = s3[2];
			RQSBbean rq= new RQSBbean();
			rq.setFiledataRow(filedataRow);
			rq.setModularnum(modularnum);
			rq.setFilelx(filelx);
			rq.setSEQUENCENUM(SEQUENCENUM);
			rq.setPathnum(pathnum);
			rq.setFactory(getfactoryname(SEQUENCENUM));
			rq.setMONITORTIME(date);
			String a= RQSBbeanService.getrow(date, SEQUENCENUM);
			rq.setSqlrow(a);
			ls.add(rq);
			System.out.print(++i);
			 System.out.println(new Date());
		}
		return (ArrayList<RQSBbean>) ls;
	}

	
	private static void printlist(ArrayList<RQSBbean> ls)
	{
		
		StringBuffer sb1 = new StringBuffer();
		 sb1.append("设备编号" + "\t");
		 sb1.append("时间" + "\t");
		 sb1.append("模块号" + "\t");
		 sb1.append("通道号" + "\t");
		 sb1.append("采集平台数据条数" + "\t");
		 sb1.append("数据库入库条数" + "\t");
		 sb1.append("传感器类型" + "\t");
		 sb1.append("厂家名称" + "\n");
		 FileOperation.writeTxFile(sb1.toString(), ls.get(0).getMONITORTIME(), "_燃气数据统计");
		
		for (int i = 0; i < ls.size(); i++) {
			RQSBbean s=ls.get(i);
			StringBuffer sb = new StringBuffer();
			 sb.append(s.getSEQUENCENUM() + "\t");
			 sb.append(s.getMONITORTIME() + "\t");
			 sb.append(s.getModularnum() + "\t");
			 sb.append(s.getPathnum() + "\t");
			 sb.append(s.getFiledataRow() + "\t");
			 sb.append(s.getSqlrow() + "\t");
			 sb.append(s.getFilelx() + "\t");
			 sb.append(s.getFactory() + "\n");
			 FileOperation.writeTxFile(sb.toString(), s.getMONITORTIME(), "_燃气数据统计");
			 
			
		}
		
	}
	private static int getTextLines1(String fileName) throws IOException {

		File file = new File(fileName);
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(
				file));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,
				"utf-8"), 5 * 1024 * 1024);

		// BufferedReader br = new BufferedReader(new FileReader(fileName));

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
	 * N=研究院单点设备 A 9=-汉威设备  1  研究院多通道设备
	 * 
	 * @param SEQUENCENUM 设备名称
	 * @return  
	 * @Description:
	 */
	public static String getfactoryname(String SEQUENCENUM)
	{   String type = SEQUENCENUM.substring(0, 1);

		if(type.equals("N"))
		{
			return "研究院单点设备";
		}
		if(type.equals("A")||type.equals("9"))
		{
			return "汉威设备";
		}
		if(type.equals("1"))
		{
			return "研究院多通道设备";
		}
		return "不知道谁的设备";
		
		
		
	}
}
