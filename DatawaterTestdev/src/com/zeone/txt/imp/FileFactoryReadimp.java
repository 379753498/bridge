package com.zeone.txt.imp;

import io.netty.build.checkstyle.NewlineCheck;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.zeone.txt.FileFactoryRead;

public class FileFactoryReadimp implements FileFactoryRead {
//	private static List<SensorData> data = new ArrayList<SensorData>();
	private static ArrayList<Object> databean = new ArrayList<Object>();

	ArrayList<String> filelist = new ArrayList<String>();
	String Filename;

	@Override
	public String getfilename(String str) {
		// TODO Auto-generated method stub\
		String[] s1 = str.split("\\\\");// 第一次加工
		Filename = s1[s1.length - 1];// 取出文件名}
		return Filename;
	}

	@Override
	public ArrayList<String> getfilenames(String Filepath) {

		System.out.println(Filepath);

		File root = new File(Filepath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getfilenames(file.getAbsolutePath());

			} else {
				filelist.add(file.getAbsolutePath());

			}

		}

		return filelist;

	}

	@Override
	public String getGatewaynum() {

		String[] filenames = Filename.split("_");
		String Gatewaynum = filenames[0] + "_" + filenames[1] + "_"
				+ filenames[2];

		// TODO Auto-generated method stub
		return Gatewaynum;
	}

	@Override
	public String getTesttype() {

		String[] s3 = Filename.split("_");
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
		// TODO Auto-generated method stub
		return filelx;
	}

	@Override
	public String getpathnum() {
		String[] s3 = Filename.split("_");

		String pathnum = s3[4];

		return pathnum;
	}

	@Override
	public int getfilerow(String filepath) throws IOException {

		File file = new File(filepath);
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(
				file));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,
				"utf-8"), 5 * 1024 * 1024);
		int totalLines = 0;
		String al;
		while (true) {
			al = br.readLine();
			// databaen da=new databaen();
			// da.setDatetime(datetime);
			// da.setLevel(level);
			// databean.add(da);
			if (al == null)

			{
				break;
			} else if (al.indexOf("#") > -1 && al.indexOf("*") > -1) {
				continue;
			} else {
				System.out.println(al);

				totalLines++;
			}

		}
		br.close();
		fis.close();

		return totalLines;
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Object> getbeans(Object Object) throws IOException {
		Iterator<String> it1 = filelist.iterator();
		while (it1.hasNext()) {
			Object = it1.next();
			getfilerow((String) Object);

		}

		return databean;
	}

	public int getBetweenDay(Date date1, Date date2) {
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

	@Override
	public String modularnum() {

		String[] s3 = Filename.split("_");
		String modularnum = s3[3];
		return modularnum;
	}

	// public static SensorData getSensorData(String Gatewaynum,
	// String Modularnum, String Pathnum) {
	// data = SensorService.getAllSensorInfo();
	// for (int i = 0; i < data.size(); i++) {
	// SensorData s = data.get(i);
	// if (s.getGatewaynum().equals(Gatewaynum)
	// && s.getModularnum().equals(Modularnum)
	// && s.getPathnum().equals(Pathnum)) {
	// return s;
	// }
	// }
	//
	// return null;
	//
	// }

	public static String getStrings() {

		return null;

	}
}
