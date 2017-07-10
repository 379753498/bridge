package com.zeone.util;  

import java.util.ArrayList;

import com.zeone.bean.SensorData;
import com.zeone.bean.Sensordata14;
import com.zeone.jdbc.SensorService;
  
public class TestBridgeEQUIPMENT {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		ArrayList<Sensordata14> allSensordata14 = SensorService.getAllSensordata14();
		
		Thread.sleep(3000);
		ArrayList<SensorData> allSensorInfo = SensorService.getAllSensorInfo();
		
		for (SensorData s : allSensorInfo) {
			
			
			
			
			for (Sensordata14 s1 : allSensordata14) {
				
				if( s.getEquipmentname().equals(s1.getEquipmentname())&&s.getModularnum().equals(s1.getModularnum())&&s.getGatewaynum().equals(s1.getGatewaynum())&&s.getPathnum().equals(s1.getPathnum()) )
				
					
				{
				
					
					
				}else {
					
					
				System.out.println(s.toString());	
				System.out.println(s1.toString());	
				}
					
			}
			
			
		}
		
	}
	
	
}
