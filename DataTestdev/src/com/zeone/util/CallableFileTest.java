package com.zeone.util;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

import com.zeone.bean.databaen;
import com.zeone.lifeline.collector.util.DateUtil;
import com.zeone.txt.imp.FileFactoryReadimp;

public class CallableFileTest {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		 Date  date = new Date();
		 
		 System.out.println(date.toString());
		FileFactoryReadimp FileFactoryReadimp = new FileFactoryReadimp();
		//获取文件列表
		
		String path = "D://bridgetestdemo";// 定义文件路径
//		String path = "Z://"+date+"//bridge";// 定义文件路径
		ArrayList<String> filelist = FileFactoryReadimp.getfilenames(path);
		
		ExecutorService ExecutorService=  Executors.newFixedThreadPool(5);
		List<Future> list = new ArrayList<Future>();
		
		for (int i = 0; i < filelist.size(); i++) {
			
			String string = filelist.get(i).toString();
			System.out.println(string);
			FileCallable FileCallable = new FileCallable(string,FileFactoryReadimp.getfilename(string));
			Future<ArrayList<databaen>> submit = ExecutorService.submit(FileCallable);
			list.add(submit);
			
		}
		ExecutorService.shutdown();
		
		for (Future future : list) {
			ArrayList<databaen> x = (ArrayList<databaen>) future.get();
			for (int i = 0; i < x.size(); i++) {
				databaen databaen = x.get(i);
				System.out.println(databaen.toString());
				
				
			}
			 x.clear();
		}
		
		Date  date1 = new Date();
		 
		 System.out.println(date1.toString());
	}
	
	
	
}


class FileCallable implements Callable< ArrayList<databaen>>{
	private String Filename;
	private String filepath;
	FileCallable(){};
	
	public FileCallable(String filepath) {
		this.filepath = filepath;
	}
	ArrayList<databaen> datab = new ArrayList<databaen>();
	@Override
	public ArrayList<databaen> call() throws Exception {
		
		datab = new ArrayList<databaen>();
		File file = new File(filepath);
		List<String> list = FileUtils.readLines(file, "utf-8");
		int size = list.size() - 13;
		for (int i = 13; i < list.size(); i++) {
			String al = list.get(i);
			if (al.indexOf("#") > -1) {
				size--;
				continue;
			} else if (al.indexOf("2018") == 0) {

				getstrsz(al);
			} else {
				continue;
			}

		}
		list = null;
		return datab;


		
	}
	
	
	
	public void getstrsz(String s) throws ParseException {
		// SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String[] Strings = s.split("\t");
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

		if (getTesttype().equals("特征值")) {
			databaen da = new databaen();
			da.setSystime(Strings[0]);
			da.setDatetime(Strings[1]);
			da.setLevel(Strings[2]);
			da.setMaxVALUE(values[0]);
			da.setMinVALUE(values[1]);
			da.setAvgVALUE(values[2]);
			datab.add(da);
		} else {
			databaen da = new databaen();
			da.setSystime(Strings[0]);
			da.setDatetime(Strings[1]);
			da.setLevel(Strings[2]);
			da.setVALUE(values[0]);
			datab.add(da);

		}
	}
	
	
	public String getTesttype() {

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
	
	public FileCallable(String filepath, String filename) {
		super();
		this.filepath = filepath;
		Filename = filename;
	}


}

