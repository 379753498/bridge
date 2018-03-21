package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;







import com.zeone.bean.BeanWtihResult;
import com.zeone.bean.SensorData;
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
	
	
	
	public static ArrayList<BeanWtihResult> getAllBeanWtihResult( String date) {
		ArrayList<BeanWtihResult> data = new ArrayList<BeanWtihResult>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM bridgedatatestdev WHERE `bridgedatatestdev`.`nowdate`='"+date+"' ";
		try {
			conn = MysqljdbcFactory.getConnection();
			
		 rs = databiudmysql.findrs(conn, sql);
			while (rs.next()) {
				BeanWtihResult s = new BeanWtihResult();
				
				s.setBridgename(rs.getString("bridgename"));
			s.setEquipmentname(rs.getString("equipmentname"));
			s.setModularnum(rs.getString("modularnum"));
				s.setPathnum(rs.getString("pathnum"));
		
				
				data.add(s);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return data;
	}
	
	
	
	public static ArrayList<SensorData> getAllSensordata14() {
		ArrayList<SensorData> data = new ArrayList<SensorData>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select a.equipmentname,a.parent_id,b.tid,b.monitor_id,c.bridgename,d.tname,b.sensor_code from  PLAT_BAS_EQUIPMENT a,PLAT_BAS_EQUIPCONFIG b,PLAT_BAS_BRIDGE c,plat_bas_dictionary d where a.equipmentid=b.equip_id and c.bridgeid=b.build_id and d.tid=b.monitor_id and b.sensor_code is not null and d.tname!='地磅' order by c.bridgename, d.tname ";
		try {
			conn = JdbcFactory.getConnection15();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SensorData s = new SensorData();
				
				s.setBridgename(rs.getString("bridgename"));
				s.setEquipmentid(rs.getString("tid"));
				s.setEquipmentname(rs.getString("equipmentname"));
				s.setGatewaynum(rs.getString("parent_id"));
				s.setLeixing(rs.getString("tname"));
				String a = rs.getString("sensor_code");

				if (a.contains("_")) {
					s.setModularnum(getModularnum(a));
					s.setPathnum(getpathnum(a));
				} else {
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
