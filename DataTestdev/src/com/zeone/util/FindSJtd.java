package com.zeone.util;

import java.util.ArrayList;



import com.zeone.bean.SensorData;
import com.zeone.bean.bridgedatatestdpath;
import com.zeone.jdbc.SensorService;
import com.zeone.jdbc.bridgedatatestdpathMysqlselect;

/**
 * 测试数据跳动的功能
 * @author Administrator
 *
 */
public class FindSJtd {

	private static ArrayList<SensorData> SensorData = SensorService
			.getAllSensorInfo();
	private static ArrayList<bridgedatatestdpath> allshuju = bridgedatatestdpathMysqlselect
			.getbridgedatatestdpathBean();

	private static ArrayList<bridgedatatestdpath> dingzhishuju = bridgedatatestdpathMysqlselect
			.getbridgedatatestdpathBean("2017-05-18");
	public static void main(String[] args) {

		bridgedatatestdpathMysqlselect sy = new bridgedatatestdpathMysqlselect();

		for (SensorData s : SensorData) {

			ArrayList<bridgedatatestdpath> sshuju = sy.getshebei(dingzhishuju, s);
			if (sshuju != null) {

				sy.test(sshuju);

			}

		}

	}

}
