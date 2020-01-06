package com.zeone.datalink.webservice.service.cxf;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;




import java.util.Date;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, ParseException {

			
		
		
		VehicleInfoCXF_Service service = new VehicleInfoCXF_Service();

		VehicleInfoCXF vehicleInfoCXFImplPort = service
				.getVehicleInfoCXFImplPort();

		data da = new data();
		da.setDeviceKey("HCG1040602314501");
		da.setIndexCode("HCG1040602314501");
		da.setCheckId("zxbridge0002");
		da.setPlateNo("测试1112");
		da.setPlateType("6");
		da.setVehicleWeight("67.13");
		da.setIsOverWeight("1");
		da.setOverWeight("12.13");
		da.setLimitWeight("55.00");
		da.setAxleNum("6");
		da.setAxleweight("5.05,7.57,17.90,13.10,9.55,13.96");
		da.setAxleDistance("6.58");
		da.setAxleGroupNum("3");
		da.setAxleGroupWeight("5.05,25.47,36.60");
		da.setVehicleSpeed("56.29");
		da.setAcceleration("-0.35");
		da.setLaneNo("02");
		da.setCheckTime("20170822013739"); 
		da.setConfidenceLevel("95");
//		da.setHeadImageURL("http://112.27.200.87:8087/upload/2/20170824000055.jpg");
//		da.setBodyImageURL("http://112.27.200.87:8087/upload/2/20170824000055.jpg");
//		da.setTailImageURL("http://112.27.200.87:8087/upload/2/20170824000055.jpg");
//		
		da.setHeadImageURL("http://10.5.4.145:8866/static/img/systems.png");
		da.setBodyImageURL("http://10.5.4.145:8866/static/img/systems.png");
		da.setTailImageURL("http://10.5.4.145:8866/static/img/systems.png");

		JSONObject jsonObject = JSONObject.fromObject(da);
		String string = jsonObject.toString();
		System.out.println("开始发送josn数据串" + string+ new Date());

		String sendVehicleWeight = vehicleInfoCXFImplPort.sendVehicleWeight(string);
		System.out.println("收到来自服务返回值" + sendVehicleWeight+ new Date());
		int x = 0;
		int y = 1;

		ArrayList<data> get13list = SqlselectTest.get15list(da);// 查询13数据库数据
		if (get13list.size() == 1) {
			data data = get13list.get(0);

			if (data.getPlateNo().equals(da.getPlateNo())) {

				System.out.println("13数据保存成功" + data.toString());
				System.out.println("原始发送数据是" + da.toString());
				x = 1;
			}
		}

//		ArrayList<data> get15list = SqlselectTest.get15list(da);// 查询13数据库数据
//		if (get15list.size() == 1) {
//			data data = get15list.get(0);
//
//			if (data.getPlateNo().equals(da.getPlateNo())) {
//
//				System.out.println("15数据保存成功" + data.toString());
//				System.out.println("原始发送数据是" + da.toString());
//				y = 1;
//			}
//		}

		if (x == 1 && y == 1) {
			SqlselectTest.delete13(da);
			System.out.println("13测试数据删除完成");
			SqlselectTest.delete15(da);
			System.out.println("15测试数据删除完成");

			System.out.println("地磅服务测试完毕 问题的没有！");
		}

		else {
			System.out.println("地磅服务测试完毕数据库没有找到对应数据！");
		}

	
		
	}
}
