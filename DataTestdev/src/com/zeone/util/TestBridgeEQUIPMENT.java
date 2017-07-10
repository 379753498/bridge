package com.zeone.util;

import java.util.ArrayList;

import org.apache.derby.tools.sysinfo;

import com.zeone.bean.SensorData;
import com.zeone.bean.Sensordata14;
import com.zeone.jdbc.SensorService;

public class TestBridgeEQUIPMENT {

	public static void main(String[] args) throws InterruptedException {

		ArrayList<Sensordata14> allSensordata14 = SensorService
				.getAllSensordata14();

		Thread.sleep(3000);
		ArrayList<SensorData> allSensorInfo = SensorService.getAllSensorInfo();
		int i = 0;
		int flag=0;
		for (Sensordata14 s : allSensordata14) {

			

			for (SensorData s1 : allSensorInfo) {

				if (s.getEquipmentname().equals(s1.getEquipmentname())
						&& s.getModularnum().equals(s1.getModularnum())
						&& s.getGatewaynum().equals(s1.getGatewaynum())
						&& s.getPathnum().equals(s1.getPathnum()))

				{

					i =i+1;
					flag=0;
//					System.out.println(s.toString());
//					System.out.println(i);
					break;
					
				}

				flag=1;
			}
			if(flag==1)
			{
				System.out.println(s.toString());
				flag=0;
			}

		}

	}

}
