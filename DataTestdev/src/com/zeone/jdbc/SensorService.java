package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





import com.zeone.bean.SensorData;
import com.zeone.bean.Sensordata14;
/**
 * 数据库相关操作
 */
public class SensorService {
	/**
	 * 获取设备的信息
	 * 
	 */
	
	

	
	public static ArrayList<SensorData> getAllSensorInfo() {
		ArrayList<SensorData> data = new ArrayList<SensorData>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select bridge.bridgename, a.equipmentid, a.equipmentname, a.device_position, b.gatewaynum, b.modularnum, b.pathnum, mon.monproject from bas_equipment a left join MAM_IOTDNSCFG b on a.equipmentid = b.equipmentid and a.monprojectid = b.monprojectid left join bas_bridge bridge on a.bridgeid = bridge.bridgeid left join mon_monproject mon on a.monprojectid = mon.monprojectid where b.gatewaynum is not null and mon.monproject !='地磅' order by bridge.bridgename, a.monprojectid";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SensorData s = new SensorData();
				
				s.setBridgename(rs.getString("bridgename"));
				s.setEquipmentid(rs.getString("equipmentid"));
				s.setEquipmentname(rs.getString("equipmentname"));
				s.setDevicePosition(rs.getString("device_position"));
				s.setGatewaynum(rs.getString("gatewaynum"));
				s.setModularnum(rs.getString("modularnum"));
				s.setPathnum(rs.getString("pathnum"));
				s.setLeixing(rs.getString("monproject"));
			
				
				data.add(s);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return data;
	}
	
	
	
	
	public static ArrayList<Sensordata14> getAllSensordata14() {
		ArrayList<Sensordata14> data = new ArrayList<Sensordata14>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select bridge.bridgename ,CGQ.EQUIPMENTID,CGQ.equipmentname,CGQ.Parent_Id ,CGQ.Device_Position , CGQ.Manufacturer ,shebeicanshubiao.sensor_code ,zidian.tname   from PLAT_BAS_EQUIPMENT CGQ    left join PLAT_BAS_EQUIPCONFIG shebeicanshubiao       on CGQ.Equipmentid = shebeicanshubiao.Equip_Id     left join PLAT_BAS_BRIDGE bridge  on bridge.BRIDGEID = shebeicanshubiao.BUILD_ID     left join PLAT_BAS_DICTIONARY zidian   on CGQ.Equiptype = zidian.TID   where CGQ.Sys_Flag = 'bridge' and shebeicanshubiao.point_flag='bridge'  and bridge.bridgename  in ('金寨路高架','环巢湖路南淝河大桥','派河大桥','繁华大道跨南淝河大桥','206立交桥') and  shebeicanshubiao.sensor_code is not null and CGQ.Parent_Id  is not null order by bridge.bridgename ";
		try {
			conn = JdbcFactory.getConnection15();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Sensordata14 s = new Sensordata14();
				
				s.setBridgename(rs.getString("bridgename"));
				s.setEQUIPMENTID(rs.getString("equipmentid"));
				s.setEquipmentname(rs.getString("equipmentname"));
				s.setDevice_Position(rs.getString("device_position"));
				s.setGatewaynum(rs.getString("Parent_Id"));
			
				s.setManufacturer(rs.getString("Manufacturer"));
				s.setLeixing(rs.getString("tname"));
				
				String a= rs.getString("sensor_code");
				
				if(a.contains("_"))
				{
				s.setModularnum(getModularnum(a));
				s.setPathnum(getpathnum(a));
				}
				else
				{
					s.setModularnum("null");
					s.setPathnum("null");
				}
				data.add(s);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return data;
	}
	
	
	public static String getModularnum( String s)
	
	{
		String[] split = s.split("_");
		
		
		return split[0];
		
	}
	
	public static String getpathnum( String s)
	{
		
		String[] split = s.split("_");
		
		
		return split[1];
		
		
		
	}
	
	

	// 关闭资源
	public static void close(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
