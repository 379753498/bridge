package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zeone.bean.SensorData;
import com.zeone.bean.bridgetestbaobiao;

public class bridgetestbaobiaoservice {

	public ArrayList<bridgetestbaobiao> getlist(String brideg) {
		ArrayList<bridgetestbaobiao> data = new ArrayList<bridgetestbaobiao>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select count(mon.monproject) as count, mon.monproject  from bas_equipment a  left join MAM_IOTDNSCFG b    on a.equipmentid = b.equipmentid  and a.monprojectid = b.monprojectid  left join bas_bridge bridge   on a.bridgeid = bridge.bridgeid  left join mon_monproject mon  on a.monprojectid = mon.monprojectid where b.gatewaynum is not null  and bridge.bridgename = '"
				+ brideg + "' and mon.monproject!='地磅' group by mon.monproject";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				bridgetestbaobiao s = new bridgetestbaobiao();
				s.setBridgename(brideg);
				s.setLeixing(rs.getString("monproject"));
				s.setZts(rs.getString("count"));
				s.setAvgzd("0");
				s.setZdts("0");
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
