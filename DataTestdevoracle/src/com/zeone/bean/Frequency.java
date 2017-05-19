package com.zeone.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zeone.io.FileOperation;
import com.zeone.jdbc.SensorService;
import com.zeone.lifeline.collector.util.DateUtil;
import com.zeone.radis.RadisData;

public class Frequency {
	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy年MM月dd日HH时mm分ss秒");
	private static List<SensorData> data = new ArrayList<SensorData>();

	public void test(RadisData Radis) {
		String time = sdf.format(new Date());
		String prompt = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "超频数据检查结果：\n";
		String prop = "桥梁名称" + "\t" + "传感器名称" + "\t" + "模块号" + "\t" + "通道号"
				+ "\t" + "数据采集时间" + "\t" + "实际采集频率" + "\t" + "标准频率" + "\n";
		FileOperation.writeTxFile(prompt, time, "_超频数据");
		FileOperation.writeTxFile(prop, time, "_超频数据");
		data = SensorService.getAllSensorInfo();
		for (int i = 0; i < data.size(); i++) {
			SensorData s = data.get(i);
			HashMap<String, Integer> map = Radis.getEquipData1000_Ext(
			s.getGatewaynum(), s.getModularnum(), s.getPathnum(), s);
			List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
					map.entrySet());
			Collections.sort(list, new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
			});

			for (Entry<String, Integer> entry : list) {
				Object key = entry.getKey();
				Integer value = entry.getValue();
				Integer abc = tablemaxmin.max_frequency(s.getLeixing());
				if (value > abc || abc > value) {
				StringBuffer sb = new StringBuffer();
					sb.append(s.getBridgename()).append("\t");
					sb.append(s.getEquipmentname()).append("\t");
					sb.append(s.getModularnum()).append("\t");
					sb.append(s.getPathnum()).append("\t");
					sb.append(key).append("\t");
					sb.append(value).append("\t");
					sb.append(abc).append("\n");
					FileOperation.writeTxFile(sb.toString(), time, "_超频数据");

				}

			}

		}
		System.out.println("结束检查桥梁超频数据"+sdf.format(new Date()));

	}

}
