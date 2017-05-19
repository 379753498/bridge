package com.zeone.bean.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zeone.bean.waterbasequipment;
import com.zeone.jdbc.JdbcFactory;

public class waterbasequipmentService {

	public static TreeMap<String, waterbasequipment> getAllSensorInfo() {
		TreeMap<String, waterbasequipment> data = new TreeMap<String, waterbasequipment>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder("select");
		sql.append(" t.EQUIPMENTPOS,");
		sql.append(" t.EQUIPMENTNAME,");
		sql.append(" c.DISTRICTNAME,");
		sql.append(" t.EQUIPMENTCODE,");
		sql.append(" b.DATA_NAME,");
		sql.append(" t.equipmentid");
		sql.append(" from");
		sql.append(" water_bas_equipment t left join datadic_items b on b.id=t.equiptypecode left join CODE_BAS_DISTRICT c on t.DISTRICTCODE = c.DISTRICTCODE ");
		sql.append(" order by   t.EQUIPMENTNAME asc ,t.EQUIPMENTCODE");

		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				waterbasequipment water= new waterbasequipment();
				water.setDATA_NAME(rs.getString("DATA_NAME"));
				water.setDISTRICTNAME(rs.getString("DISTRICTNAME"));
				water.setEQUIPMENTCODE(rs.getString("EQUIPMENTCODE"));
				water.setEquipmentid(rs.getString("EQUIPMENTNAME"));
				water.setEQUIPMENTNAME(rs.getString("equipmentid"));
				water.setEQUIPMENTPOS(rs.getString("EQUIPMENTPOS"));
				data.put(water.getEQUIPMENTNAME(), water);
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

	@Override
	public String toString() {
		return "waterbasequipmentService [toString()=" + super.toString() + "]";
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
