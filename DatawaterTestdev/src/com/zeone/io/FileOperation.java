package com.zeone.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.zeone.lifeline.collector.util.DateUtil;


/**
 * 文件写入操作
 */
public class FileOperation {
	
	private  static String PATH;
	static String date;
	/**
	 * 根据路径创建文件
	 * @param fileName
	 * 
	 * 
	 * 
	 * @return
	 */
	
	public FileOperation()
	{
		date= DateUtil.format(new Date(), "yyyy-MM-dd");
		PATH= "c://bridge_equipment//"+date+"//";// 根路径
		
	}
	public static File createFile(String fileName){
		File file = new File(fileName);
		try {
			if(!file.getParentFile().exists()){
				if(!file.getParentFile().mkdirs()){
					System.out.println(file.getParentFile() + "创建目录失败！");
					return null;
				}
			}
		
			if(!file.exists()){
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * 将内容写入文件
	 * @param content
	 * @return
	 */
	public static boolean writeTxFile(String content, String time ,String  a){
		
		date= DateUtil.format(new Date(), "yyyy-MM-dd");
		PATH= "C://bridge_equipment//"+date+"//";// 根路径
		File file = createFile(PATH + time +a+ ".txt");
		if(file == null){
			System.out.println("写入失败");
			return false;
		}
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return true;
	}
}
