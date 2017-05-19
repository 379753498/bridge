package com.zeone.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import com.zeone.Config;
import com.zeone.bean.waterbasequipment;
import com.zeone.bean.service.SqlReaderLineService;
import com.zeone.bean.service.waterbasequipmentService;

import com.zeone.io.FileOperation;

public class Util {
	private static TreeMap<String, Map<String, String>> hsp = SqlReaderLineService
			.getsqlmap();
	// 获取最近几天的数据汇总表
	private static TreeMap<String, waterbasequipment> water = waterbasequipmentService
			.getAllSensorInfo();

	// 获取所有的设备表信息
	public static void main(String[] args) {

		if (null != hsp && !hsp.isEmpty()) {
			if (null != water && !water.isEmpty()) {
				Map<String, String> allCnt = null;
				Map<String, String> dailyCnt = null;
				String daily = null;

				String eqName = null;
				String eqCnt = null;
				waterbasequipment wbq = null;
				// 日期-设备-统计值
				for (Entry<String, Map<String, String>> entry : hsp.entrySet()) {
					daily = entry.getKey();
					allCnt = entry.getValue();
					if (null != allCnt && !allCnt.isEmpty()) {
						for (Entry<String, String> valEntry : allCnt.entrySet()) {
							eqName = valEntry.getKey();
							eqCnt = valEntry.getValue();
							if (null != eqName && !"".equals(eqName)) {
								// 获取设备bean
								wbq = water.get(eqName);
								if (null != wbq) {
									dailyCnt = wbq.getDailyCntMap();
									if (null != dailyCnt && !dailyCnt.isEmpty()) {
										dailyCnt.put(daily, eqCnt);
										
										
									} else {
										dailyCnt = new LinkedHashMap<String, String>();
										dailyCnt.put(daily, eqCnt);
										wbq.setDailyCntMap(dailyCnt);
									}
								}
							}
						}
					}
				}
			}
		}

		if (null != water) {
			StringBuffer sb1 = new StringBuffer();

			sb1.append("传感器名称" + "\t");// 传感器名称
			sb1.append("位置信息" + "\t");// 位置信息
			sb1.append("业务系统编码" + "\t");// 业务系统编码
			sb1.append("传感器类型" + "\t");// 传感器类型
			sb1.append("所属区域" + "\t");// 所属区域
			sb1.append("设备编码" + "\t");// 设备编码
			sb1.append("理论传输量（条）" + "\t");// 期望记录数字
			sb1.append("时间" + "\t");// 时间
			sb1.append("统计记录数（条）" + "\n");// 行数
			FileOperation.writeTxFile(sb1.toString(), Config.date, "供水数据统计");
			for (waterbasequipment wbe : water.values()) {
				System.out.print("设备名称：" + wbe.getEQUIPMENTNAME() + "\t");

				StringBuffer sb = new StringBuffer();

				sb.append(wbe.getEquipmentid() + "\t");// 名称
				sb.append(wbe.getEQUIPMENTPOS() + "\t");// 位置
				sb.append(wbe.getEQUIPMENTNAME() + "\t");// 业务系统编码
				sb.append(wbe.getDATA_NAME() + "\t");// 传感器类型
				sb.append(wbe.getDISTRICTNAME() + "\t");// 所属区域
				sb.append(wbe.getEQUIPMENTCODE() + "\t");// 设备编码
				sb.append(wbe.getWANTROWS() + "\t");// 期望记录数字

				if (null != wbe.getDailyCntMap()) {
					for (Entry<String, String> tmp : wbe.getDailyCntMap()
							.entrySet()) {
						// System.out.print("日期：" + tmp.getKey() + "\t");
						// System.out.print("统计值：" + tmp.getValue() + "\t");
						sb.append(tmp.getKey() + "\t");// 设备编码
						sb.append(tmp.getValue() + "\t");// 设备编码
					}
					sb.append("\n");// 设备编码
				}
				FileOperation.writeTxFile(sb.toString(), Config.date, "供水数据统计");
			}
		}
		System.out.println("计算完成~~~~~~");

		/*
		 * String Str[] = SqlReaderLineService.getdate();
		 * 
		 * 
		 * 
		 * for (int i = 0; i < Config.day - 1; i++) { for (waterbasequipment wa
		 * : water) { String a = gewrow(Str[i], wa.getEQUIPMENTNAME());
		 * wa.setRow(a); wa.setDate(Str[i]); StringBuffer sb = new
		 * StringBuffer();
		 * 
		 * sb.append(wa.getDATA_NAME() + "\t");// 差距条数 sb.append(wa.getDate() +
		 * "\t");// 差距条数 sb.append(wa.getDISTRICTNAME() + "\t");// 差距条数
		 * sb.append(wa.getEQUIPMENTCODE() + "\t");// 差距条数
		 * sb.append(wa.getEquipmentid() + "\t");// 差距条数
		 * sb.append(wa.getEQUIPMENTNAME() + "\t");// 差距条数
		 * sb.append(wa.getEQUIPMENTPOS() + "\t");// 差距条数 sb.append(wa.getRow()
		 * + "\t");// 差距条数 sb.append(wa.getRTUorDTU() + "\n");// 差距条数
		 * System.out.println(sb.toString()); } }
		 */

		
		
	}

}
