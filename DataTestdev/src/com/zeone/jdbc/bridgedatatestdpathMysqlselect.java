package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.zeone.bean.SensorData;
import com.zeone.bean.bridgedatatestdpath;
import com.zeone.io.FileOperation;

public class bridgedatatestdpathMysqlselect {

	public static ArrayList<bridgedatatestdpath> getbridgedatatestdpathBean() {

		ArrayList<bridgedatatestdpath> data = new ArrayList<bridgedatatestdpath>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM `bridgedatatestdpath` t WHERE  t.`leixing` IN ('位移','加速度','动态挠度','应变') AND t.name='实时值'   ORDER BY t.`bridgename`,t.`equipmentname`,t.`nowdate`";
		try {
			conn = MysqljdbcFactory.getConnection();
			
			rs = databiudmysql.findrs(conn, sql);
			while (rs.next()) {
				bridgedatatestdpath s = new bridgedatatestdpath();
				s.setId(rs.getInt(1));
				s.setBridgename(rs.getString(2));
				s.setEquipmentid(rs.getString(3));
				s.setGatewaynum(rs.getString(4));
				s.setEquipmentname(rs.getString(5));
				s.setPathnum(rs.getString(6));
				s.setModularnum(rs.getString(7));
				s.setLeixing(rs.getString(8));
				s.setNowdate(rs.getString(9));
				s.setNAME(rs.getString(10));
				s.setAvg(rs.getDouble(11));
				s.setFilerow(rs.getDouble(12));
				s.setMaxvle(rs.getDouble(13));
				s.setMinvle(rs.getDouble(14));
				data.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return data;

	}
	
	public static ArrayList<bridgedatatestdpath> getbridgedatatestdpathBean(String end) {

		ArrayList<bridgedatatestdpath> data = new ArrayList<bridgedatatestdpath>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MysqljdbcFactory ma = new MysqljdbcFactory();

		String sql = "SELECT * FROM `bridgedatatestdpath` t WHERE  t.`leixing` IN ('位移','加速度','动态挠度','应变') AND t.name='实时值'  AND t.`nowdate`<='"+end+"' ORDER BY t.`bridgename`,t.`equipmentname`,t.`nowdate`";
		try {
			conn = ma.getConnection();
			
			rs = databiudmysql.findrs(conn, sql);
			while (rs.next()) {
				bridgedatatestdpath s = new bridgedatatestdpath();
				s.setId(rs.getInt(1));
				s.setBridgename(rs.getString(2));
				s.setEquipmentid(rs.getString(3));
				s.setGatewaynum(rs.getString(4));
				s.setEquipmentname(rs.getString(5));
				s.setPathnum(rs.getString(6));
				s.setModularnum(rs.getString(7));
				s.setLeixing(rs.getString(8));
				s.setNowdate(rs.getString(9));
				s.setNAME(rs.getString(10));
				s.setAvg(rs.getDouble(11));
				s.setFilerow(rs.getDouble(12));
				s.setMaxvle(rs.getDouble(13));
				s.setMinvle(rs.getDouble(14));
				data.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return data;

	}
	
	
	

	public ArrayList<bridgedatatestdpath> getshebei(
			ArrayList<bridgedatatestdpath> data, SensorData s) {
		ArrayList<bridgedatatestdpath> db = new ArrayList<bridgedatatestdpath>();

		if (s.getLeixing().equals("位移") || s.getLeixing().equals("加速度")
				|| s.getLeixing().equals("动态挠度") || s.getLeixing().equals("应变"))

		{
			for (int i = 0; i < data.size(); i++) {
				bridgedatatestdpath temp = data.get(i);
				if (s.getGatewaynum().equals(temp.getGatewaynum())
						&& s.getModularnum().equals(temp.getModularnum())
						&& s.getPathnum().equals(temp.getPathnum()))

				{
					
					db.add(temp);

				}

			}

		}
		else{
			
			return null;
		}
//		Maths.getpaixubridgedatatestdpath(db);比较器产生错误 解决方案使用SQL自动排序解决；
		return db;

	}
	
	
	
	public  void test(ArrayList<bridgedatatestdpath> db)
	{		
		
if(db.size()>1)
{
	bridgedatatestdpath zuotian=db.get(db.size()-2);

	bridgedatatestdpath last=db.get(db.size()-1);

	double avg =zuotian.getAvg();
	 double avglast =last.getAvg();
	 if(avglast-avg>20)
	 {
		 StringBuffer sb1 = new StringBuffer();
			sb1.append(last.getBridgename() + "\t");
			sb1.append(last.getEquipmentname() + "\t");
			sb1.append(last.getModularnum()+ "\t");
			sb1.append(last.getPathnum()+ "\t");
			sb1.append(last.getLeixing() + "\t");
			sb1.append(zuotian.getNowdate()+"平均值"+zuotian.getAvg()  +"\t");
			sb1.append(last.getNowdate()+"平均值"+last.getAvg() + "\t");
			sb1.append("  差值"+(avglast-avg) + "\n");
//			sb1.append( " 波动比 "+(avglast-avg)/avg*100+ "\n");
			
			FileOperation.writeTxFile(sb1.toString(), last.getNowdate(),
					"数据跳动检测预警");
			sb1 = new StringBuffer();
		 
	 }
	 else if(avg-avglast>20)
	 {
		 StringBuffer sb1 = new StringBuffer();
			sb1.append(last.getBridgename() + "\t");
			sb1.append(last.getEquipmentname() + "\t");
			sb1.append(last.getModularnum()+ "\t");
			sb1.append(last.getPathnum()+ "\t");
			sb1.append(last.getLeixing() + "\t");
			sb1.append(zuotian.getNowdate()+"平均值"+zuotian.getAvg()  +"\t");
			sb1.append(last.getNowdate()+"平均值"+last.getAvg() + "\t");
			sb1.append("  差值"+(avglast-avg) + "\n");
//			sb1.append( " 波动比 "+(avglast-avg)/avg*100+ "\n");
			
			FileOperation.writeTxFile(sb1.toString(), last.getNowdate(),
					"数据跳动检测预警");
			sb1 = new StringBuffer();
		 
	 }

	 

}
		 
		 
	
		
		
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
