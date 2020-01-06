package com.zeone.datalink.webservice.service.cxf;  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.zeone.jdbc.JdbcFactory;
import com.zeone.lifeline.collector.util.DateUtil;
  
public class SqlselectTest {

	
	
	public static ArrayList<data> get13list(data da) {
		ArrayList<data> data = new ArrayList<data>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String format = DateUtil.format(new Date(), "yyyyMMdd");
		String sql = " select *  from mon_vehicledata t where t.plateno='"+ da.getPlateNo()+"' and  to_date(to_char(t.uploadtime, 'yyyy-mm-dd hh24:mi:ss'),'yyyy/mm/dd hh24:mi:ss') > (to_date('"+format+"', 'yyyymmdd'))order by t.uploadtime desc";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				data s = new data();
				s.setPlateNo(rs.getString("plateno"));
				s.setIsOverWeight(rs.getString("IsOverWeight"));
				s.setVehicleWeight(rs.getString("VehicleWeight"));
				s.setLimitWeight(rs.getString("LimitWeight"));
				s.setAxleweight(rs.getString("Axleweight"));
				s.setHeadImageURL(rs.getString("HeadImageURL"));
				s.setBodyImageURL(rs.getString("BodyImageURL"));
				s.setTailImageURL(rs.getString("TailImageURL"));
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
	
	
	public static void delete13(data da) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete from mon_vehicledata t where t.plateno like  '%"+da.getPlateNo()+"%'";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql);
		 stmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}



	}
	
	
	public static void delete15(data da) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete from BRIDGE_MON_VEHICLEDATA t where t.plateno like  '%"+da.getPlateNo()+"%'";
		try {
			conn = JdbcFactory.getConnection15();
			stmt = conn.prepareStatement(sql);
		 stmt.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}



	}
	
	
	public static  ArrayList<data> get15list(data da) {
		ArrayList<data> data = new ArrayList<data>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String format = DateUtil.format(new Date(), "yyyyMMdd");
		String sql = " select *  from bridge_mon_vehicledata t where t.plateno='"+ da.getPlateNo()+"' and  to_date(to_char(t.uploadtime, 'yyyy-mm-dd hh24:mi:ss'),'yyyy/mm/dd hh24:mi:ss') > (to_date('"+format+"', 'yyyymmdd'))order by t.uploadtime desc";
		try {
			conn = JdbcFactory.getConnection25();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				data s = new data();
				s.setPlateNo(rs.getString("plateno"));
				s.setIsOverWeight(rs.getString("IsOverWeight"));
				s.setVehicleWeight(rs.getString("VehicleWeight"));
				s.setLimitWeight(rs.getString("LimitWeight"));
				s.setAxleweight(rs.getString("Axleweight"));
				s.setHeadImageURL(rs.getString("HeadImageURL"));
				s.setBodyImageURL(rs.getString("BodyImageURL"));
				s.setTailImageURL(rs.getString("TailImageURL"));
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
