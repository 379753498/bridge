package com.zeone.bean.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReaderlineService {
	ArrayList<String> filelist=new ArrayList<String>();
	
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
}
