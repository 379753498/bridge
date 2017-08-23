package com.zeone.datalink.webservice.service.cxf;

import java.sql.Connection;
import java.sql.SQLException;

import com.zeone.jdbc.JdbcFactory;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		VehicleInfoCXF_Service service = new VehicleInfoCXF_Service();

		VehicleInfoCXF vehicleInfoCXFImplPort = service.getVehicleInfoCXFImplPort();

		data da = new data();
		da.setDeviceKey("G1040602314501");
		da.setIndexCode("G1040602314501");
		da.setCheckId("G1040602314501");
		da.setPlateNo("测试1112");
		da.setPlateType("6");
		da.setVehicleWeight("67.13");
		da.setIsOverWeight("0");
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
		da.setHeadImageURL("http://112.27.200.87:8087/upload/1/20170823010948.jpg");
		da.setBodyImageURL("http://112.27.200.87:8087/upload/1/20170823010948.jpg");
		da.setTailImageURL("http://112.27.200.87:8087/upload/1/20170823010948.jpg");

		JSONObject jsonObject = JSONObject.fromObject(da);
		String string = jsonObject.toString();
		System.out.println(string);
		String sendVehicleWeight = vehicleInfoCXFImplPort
				.sendVehicleWeight(string);
		System.out.println(sendVehicleWeight);

		Connection connection = JdbcFactory.getConnection();
		
		
	}
}
