package com.zeone.jdbc;  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zeone.bean.LoadoMeterBean;

  
public class LoadoMeterOacle {

	public static ArrayList<LoadoMeterBean> getAllLoadoMeterBean(String date) {
		ArrayList<LoadoMeterBean> data = new ArrayList<LoadoMeterBean>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "select * from mon_vehicledata where UPLOADTIME >=to_date('"+date+" 00:00:00','yyyy-mm-dd hh24:mi:ss') and UPLOADTIME <= to_date('"+date+" 23:59:59','yyyy-mm-dd hh24:mi:ss')";
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				LoadoMeterBean s = new LoadoMeterBean();
						s.setVEHICLEID(rs.getString(1));
						s.setDEVICEKEY(rs.getString(2));
						s.setINDEXCODE(rs.getString(3));
						s.setVEHICLEPOINT(rs.getString(4));
						s.setPLATENO(rs.getString(5));
						s.setPLATETYPE(rs.getString(6));
						s.setVEHICLEWEIGHT(rs.getString(7));
						s.setISOVERWEIGHT(rs.getString(8));
						s.setOVERWEIGHT(rs.getString(9));
						s.setLIMITWEIGHT(rs.getString(10));
						s.setAXLENUM(rs.getString(11));
						s.setAXLEWEIGHT(rs.getString(12));
						s.setAXLEDISTANCE(rs.getString(13));
						s.setAXLEGROUPNUM(rs.getString(14));
						s.setAXLEGROUPWEIGHT(rs.getString(15));
						s.setSPEED(rs.getString(16));
						s.setACCELERATION(rs.getString(17));
						s.setLANENO(rs.getString(18));
						s.setVEHICLETIME(rs.getString(19));
						s.setCONFIDENCELEVEL(rs.getString(20));
						s.setHEADIMAGEURL(rs.getString(21));
						s.setBODYIMAGEURL(rs.getString(22));
						s.setTAILIMAGEURL(rs.getString(23));
						s.setUPLOADTIME(rs.getString(24));
						s.setEQUIPMENTID(rs.getString(25));
						s.setBRIDGEID(rs.getString(26));
				
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
	
	
//	public static void main(String[] args) {
//		
//		ArrayList<LoadoMeterBean> allLoadoMeterBean = LoadoMeterOacle.getAllLoadoMeterBean("2017-05-28");
//		
//		
//		for (int i = 0; i < allLoadoMeterBean.size(); i++) {
//			LoadoMeterBean LoadoMeterBean = allLoadoMeterBean.get(i);
//			System.out.println(LoadoMeterBean.getPLATENO());
//			
//			
//		}
//		
//	}

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
