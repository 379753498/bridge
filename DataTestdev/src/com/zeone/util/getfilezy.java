package com.zeone.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zeone.Ftp.util.DeCompressUtil;
import com.zeone.Ftp.util.FTPUtil;

public class getfilezy {
	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");

	static String date = sdf.format(new Date().getTime() - 1 * 24 * 60 * 60
			* 1000);

	public  static void getfile(String date) throws Exception {

		ArrayList<String> str = new ArrayList<String>();
		ArrayList<String> str1 = new ArrayList<String>();
		FTPUtil f = new FTPUtil();
		f.getFTPClient();
		ArrayList<String> als = f.getList();
		for (int i = 0; i < als.size(); i++) {

			System.out.println(als.get(i));
			String filename = f.downsfile(f.path + als.get(i), date);
			if (filename != null) {
				str.add(f.localPath + filename);
				str1.add(filename);

			}

		}
		f.close();
		for (int i = 0; i < str.size(); i++) {

			String loaclpath = "D:\\bridge\\" + date + "\\" + str1.get(i);
			File dir = new File(loaclpath);
			if (!dir.exists() || !dir.isDirectory()) {
				dir.mkdirs();
			}

			DeCompressUtil.deCompress(str.get(i), loaclpath);
		}
	}

}
