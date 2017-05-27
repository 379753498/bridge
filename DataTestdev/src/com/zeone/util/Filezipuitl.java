package com.zeone.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zeone.Ftp.util.DeCompressUtil;
import com.zeone.io.FileOperation;

public class Filezipuitl {

	/**
	 * @param args
	 */
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	static String date = sdf.format(new Date().getTime() - 1 * 24 * 60 * 60	* 1000);
	public static void main(String[] args) {

		String zipdir="D:\\data\\test\\"+date+"\\";
		FileOperation.createDir(zipdir);
		DeCompressUtil dec= new DeCompressUtil();
		dec.ZipFilesStart("D:\\bridge\\20170505", zipdir);
		
	}

}
