package com.zeone.Ftp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import com.zeone.io.FileOperation;

public class FTPUtil {
	private static Logger logger = Logger.getLogger(FTPUtil.class);
	public static final String ftpHost = "172.19.8.2";
	public static final int ftpPort = 21;
	public static final String ftpUserName = "admin";
	public static final String ftpPassword = "2w3e4r5T";
	public static final String path = "10-合肥城市生命线/98-传感器归档数据/桥梁分项/";
	public static String localPath = "D://data//";
	public static FTPClient ftp = null;

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public static String date = sdf.format(new Date().getTime() - 24 * 60 * 60
			* 1000);

	/**
	 * 获取FTPClient对象
	 * 
	 * @param ftpHost
	 *            FTP主机服务器
	 * @param ftpPassword
	 *            FTP 登录密码
	 * @param ftpUserName
	 *            FTP登录用户名
	 * @param ftpPort
	 *            FTP端口 默认为21
	 * @return
	 */
	public FTPClient getFTPClient() {

		localPath = localPath + date + "//";
		FileOperation.createDir(localPath);
		try {
			ftp = new FTPClient();
			ftp.connect(ftpHost, ftpPort);// 连接FTP服务器
			ftp.login(ftpUserName, ftpPassword);// 登陆FTP服务器
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				logger.info("未连接到FTP，用户名或密码错误。");
				ftp.disconnect();

			} else {
				logger.info("FTP连接成功。");
			}
		} catch (SocketException e) {
			e.printStackTrace();
			logger.info("FTP的IP地址可能错误，请正确配置。");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("FTP的端口错误,请正确配置。");
		}
		return ftp;
	}

	public String downsfile(String path, String name) throws Exception {
		String str = null;
		// 设置文件 2进制传输
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		// 设置文件流传输
		ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		// 设置缓冲
		ftp.setBufferSize(1024);
		// 设置文件编码
		ftp.setControlEncoding("GBK");
		// SYST_NT ---对应windows系统
		FTPClientConfig ftpClientConfig = new FTPClientConfig(
				FTPClientConfig.SYST_NT);
		// 系统编码为中文
		boolean abc = ftp.changeWorkingDirectory(new String(path
				.getBytes("GBK"), "iso-8859-1"));
		System.out.println(abc);
		ftpClientConfig.setServerLanguageCode("zh");
		ftp.setFileType(FTP.BINARY_FILE_TYPE);// 注意，使用字符模式
		FTPFile[] f = ftp.listFiles();
		for (int i = 0; i < f.length; i++) {
			if (f[i].getName().contains(name)) {
				str = f[i].getName();
				File localFile = new File(localPath + "/" + f[i].getName());
				OutputStream is = new FileOutputStream(localFile);
				ftp.retrieveFile(f[i].getName(), is);
				is.close();

				break;
			}

		}

		if (str == null) {

			System.out.println(path + name + "没有今天的文件哦！");
		}
		ftp.changeWorkingDirectory("/");

		return str;

	}

	public void close() throws IOException {

		ftp.logout();

		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
			} catch (IOException ioe) {
			}
		}

	}

	public ArrayList<String> getList() throws IOException {

		// 设置文件 2进制传输
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		// 设置文件流传输
		ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
		// 设置缓冲
		ftp.setBufferSize(1024);
		// 设置文件编码
		ftp.setControlEncoding("GBK");
		// SYST_NT ---对应windows系统
		FTPClientConfig ftpClientConfig = new FTPClientConfig(
				FTPClientConfig.SYST_NT);
		// 系统编码为中文
		System.out.println(ftp.changeWorkingDirectory(new String(path
				.getBytes("GBK"), "iso-8859-1")));
		ftpClientConfig.setServerLanguageCode("zh");
		// fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1");

		ftp.setFileType(FTP.BINARY_FILE_TYPE);// 注意，使用字符模式
		ArrayList<String> list = new ArrayList<String>();
		;

		FTPFile[] f = ftp.listFiles();
		for (int i = 0; i < f.length; i++) {

			if (f[i].isDirectory()) {
				list.add(f[i].getName());
			}

		}
		ftp.changeWorkingDirectory("/");
		return list;

	}

	}
