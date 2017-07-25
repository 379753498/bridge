package com.zeone.txt.imp;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.zeone.bean.databaen;
import com.zeone.lifeline.collector.util.DateUtil;

public class FilenameInfo {

	/**
	 * 获取文件名称
	 * @param str
	 * @return
	 */
	public String getfilename(String str) {
		String[] s1 = str.split("\\\\");// 第一次加工
		
		return s1[s1.length - 1];// 取出文件名}
	}
	
	
	
	/**
	 * 获取所有文件
	 * @param Filepath
	 * @return
	 */
	public ArrayList<String> getfilenames(String Filepath) {
		ArrayList<String> filelist =new ArrayList<String>();
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
	
	
	/**
	 * 根据文件名称返回主机号
	 * @param Filename
	 * @return
	 */
	public String getGatewaynum(String Filename) {
		String Gatewaynum;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] filenames = Filename.split("_");
			Gatewaynum = filenames[0] + "_" + filenames[1] + "_" + filenames[2]
					+ "_" + filenames[3];
		} else {

			String[] filenames = Filename.split("_");
			Gatewaynum = filenames[0] + "_" + filenames[1] + "_" + filenames[2];
		}

		return Gatewaynum;
	}

	/**
	 * 根据文件名称范围数据Type
	 * @param Filename
	 * @return
	 */
	public String getTesttype(String Filename) {

		String filelx;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] s1 = Filename.split("_");
			String s4 = s1[6];
			filelx = s4.substring(1, 2);
		} else {
			String[] s3 = Filename.split("_");
			String s4 = s3[5];

			filelx = s4.substring(1, 2);
		}

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
		return filelx;
	}

	
	/**
	 * 根据文件名称返回通道号
	 * 
	 * @Override
	 */
	public String getpathnum(String Filename) {

		String pathnum;
		if (Filename.contains("HF_HHDD_NFH_0001")) {
			String[] s3 = Filename.split("_");
			pathnum = s3[5];
		} else {
			String[] s3 = Filename.split("_");

			pathnum = s3[4];

		}

		return pathnum;
	}

	
	
	public int getfilerow(String filepath) throws IOException, ParseException {

	 ArrayList<databaen>	datab = new ArrayList<databaen>();
		File file = new File(filepath);
		List<String> list = FileUtils.readLines(file, "utf-8");
		int size = list.size() - 13;
		for (int i = 13; i < list.size(); i++) {
			String al = list.get(i);
			if (al.indexOf("#") > -1) {
				size--;
				continue;
			} else if (al.indexOf("2017") == 0) {

				getstrsz(al,getTesttype(getfilename(filepath)));
			} else {
				continue;
			}

		}
		list = null;
		return size;

	}
	
	/**
	 * @Override 根据文件名称返回模块号
	 * @return
	 */
	public String modularnum( String Filename) {
		String[] s3 = Filename.split("_");
		String modularnum = s3[3];
		return modularnum;

	}
	
	
	public void getstrsz(String data,String datatype) throws ParseException {
		// SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String[] Strings = data.split("\t");
		String s4 = Strings[Strings.length - 1];
		String[] values = s4.split(",");
		Strings[Strings.length - 1] = values[0];

		for (int i = 0; i < Strings.length; i++) {
			String a = Strings[i];
			if (i < 2) {
				Date date = DateUtil.parse(a, "yyyyMMdd HHmmss SSS");
				a = DateUtil.format(date, "yyyy/MM/dd HH:mm:ss");
				Strings[i] = a;
			}

		}

		if (datatype.equals("特征值")) {
			databaen da = new databaen();
			da.setSystime(Strings[0]);
			da.setDatetime(Strings[1]);
			da.setLevel(Strings[2]);
			da.setMaxVALUE(values[0]);
			da.setMinVALUE(values[1]);
			da.setAvgVALUE(values[2]);
			
		} else {
			databaen da = new databaen();
			da.setSystime(Strings[0]);
			da.setDatetime(Strings[1]);
			da.setLevel(Strings[2]);
			da.setVALUE(values[0]);
			

		}
	}
	
	
	
	
	
}
