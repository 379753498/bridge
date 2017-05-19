package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zeone.bean.SensorData;
/**
 * 数据库相关操作
 */
public class SensorService {
	/**
	 * 获取设备的信息
	 * 
	 */
	
	
	
	public static List<SensorData> getAllSensorInfo() {
		List<SensorData> data = new ArrayList<SensorData>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select bridge.bridgename, a.equipmentid, a.equipmentname, a.device_position, b.gatewaynum, b.modularnum, b.pathnum, mon.monproject from bas_equipment a left join MAM_IOTDNSCFG b on a.equipmentid = b.equipmentid and a.monprojectid = b.monprojectid left join bas_bridge bridge on a.bridgeid = bridge.bridgeid left join mon_monproject mon on a.monprojectid = mon.monprojectid where b.gatewaynum is not null order by bridge.bridgename, a.monprojectid";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SensorData s = new SensorData();
				data.add(s);
				s.setBridgename(rs.getString("bridgename"));
				s.setEquipmentid(rs.getString("equipmentid"));
				s.setEquipmentname(rs.getString("equipmentname"));
				s.setDevicePosition(rs.getString("device_position"));
				s.setGatewaynum(rs.getString("gatewaynum"));
				s.setModularnum(rs.getString("modularnum"));
				s.setPathnum(rs.getString("pathnum"));
				s.setLeixing(rs.getString("monproject"));
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
