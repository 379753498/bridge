package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zeone.bean.RQSBbean;
import com.zeone.bean.SensorData;

/**
 * 数据库相关操作
 */
public class RQSBbeanService {
	/**
	 * 获取设备的信息
	 * 
	 */

	public static String getrow(String  MONITORTIME,String SEQUENCENUM) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String Sql = "select count(*) Rownumber from gas_mon_realtimedata where  monitortime between to_date('"
				+ MONITORTIME
				+ " 00:00:00', 'yyyy-mm-dd hh24:mi:ss') and to_date('"
				+ MONITORTIME
				+ " 23:59:59', 'yyyy-mm-dd hh24:mi:ss')  and sequencenum='"
				+ SEQUENCENUM + "'";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(Sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString("Rownumber");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return "null";
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
