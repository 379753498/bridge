package com.zeone.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.zeone.bean.BeanWtihResult;
import com.zeone.bean.SensorData;
import com.zeone.io.FileOperation;
import com.zeone.io.FileRederTest;
import com.zeone.jdbc.SensorService;
import com.zeone.jdbc.databiudmysql;

public class Util {
	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");
	private final static SimpleDateFormat sdf1 = new SimpleDateFormat(
			"yyyyMMdd");
	static String date = sdf.format(new Date().getTime() - 1 * 24 * 60 * 60
			* 1000);
	static String filedate = sdf1.format(new Date().getTime() - 1 * 24 * 60
			* 60 * 1000);

	public static void main(String[] args) throws Throwable {

		int a = 3;

		if (a == 1) {
			// getfilezy.getfile("20170707");//获取指定数据解压
			// getfilezy.getfile("20170708");//获取指定数据解压
			getfilezy.getfile(filedate);// 获取指定数据解压
			// getfilezy.getfile("20170611");//获取指定数据解压
			// getfilezy.getfile("20170530");//获取指定数据解压

		}

		if (a == 3) {

			String s[] = new String[10];
			s[0] = "繁华大道跨南淝河大桥";
			s[1] = "环巢湖路南淝河大桥";
			s[2] = "金寨路高架";
			s[3] = "派河大桥";
			s[4] = "206立交桥";
			
			 FileRederTest fs = new FileRederTest();
			 date = fs.init();
			 if (date == null) {
			 date = sdf.format(new Date().getTime() - 1 * 24 * 60 * 60
			 * 1000);
			 }
			 databiudmysql da = new databiudmysql();
			
			 for (int i = 0; i < s.length; i++) {
			 da.testbaobiao(s[i], date, "bridgedatatestdev");
			 da.testbaobiao(s[i], date, "bridgedatatestdevtz");
			 }

			ArrayList<SensorData> allSensorInfo = SensorService
					.getAllSensorInfo();
			ArrayList<BeanWtihResult> allBeanWtihResult = SensorService
					.getAllBeanWtihResult(date);

			ArrayList<SensorData> getwhatno = getwhatno(allSensorInfo,
					allBeanWtihResult);

			for (SensorData sensorData : getwhatno) {

				StringBuffer sb = new StringBuffer();
				sb.append(sensorData.getBridgename()).append("\t");
				sb.append(sensorData.getEquipmentname()).append("\t");
				sb.append(sensorData.getModularnum()).append("\t");
				sb.append(sensorData.getPathnum()).append("\n");
				FileOperation.writeTxFile(sb.toString(), date, "传感器没有数据上传");

			}

		}
	}

	public static ArrayList<SensorData> getwhatno(
			ArrayList<SensorData> allSensorInfo,
			ArrayList<BeanWtihResult> allBeanWtihResult) {

		ArrayList<SensorData> ls = new ArrayList<SensorData>();
		int flag = 0;
		for (SensorData s1 : allSensorInfo) {

			for (BeanWtihResult beanWtihResult : allBeanWtihResult) {

				if (s1.getBridgename().equals(
								beanWtihResult.getBridgename())
						&& s1.getModularnum().equals(
								beanWtihResult.getModularnum())
						&& s1.getPathnum().equals(beanWtihResult.getPathnum()))

				{
					flag = 1;
					break;
				}
				else{
				flag = 3;
				}
			}
			if (flag == 3) {
				ls.add(s1);
				flag = 0;
			}

		}

		return ls;

	}

}
// }
