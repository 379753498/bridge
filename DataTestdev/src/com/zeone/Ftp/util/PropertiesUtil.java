package com.zeone.Ftp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * PropertiesUtil
 * @author 唐延波
 * @date 2014-5-21 下午6:22:11
 */
public class PropertiesUtil {

	public static Properties getProperties(String path){
		InputStream stream =Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		try {
			p.load(stream);
			return p;
		} catch (IOException e) {
		
		}
		return null;		
	}
}