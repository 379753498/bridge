package com.zeone.bean.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.zeone.Config;
import com.zeone.bean.sqlbean;
import com.zeone.bean.waterbasequipment;
import com.zeone.jdbc.JdbcFactory;
import com.zeone.lifeline.collector.util.StringUtil;

public class SqlReaderLineService {

	/*
	 * 
	 * select t.bh,count(*)as counts from WATERDB.PERMANET t left join
	 * waterdb.water_bas_equipment b on t.bh=b.equipmentcode where t.uptime
	 * between to_date('2017-02-15 00:00:00','yyyy-mm-dd hh24:mi:ss') and
	 * to_date('2017-03-13 23:59:59','yyyy-mm-dd hh24:mi:ss') group by t.bh
	 */
	private static sqlbean sqlbean = new sqlbean();
	private static TreeMap<String, Map<String, String>> data = new TreeMap<String, Map<String, String>>();
	public static TreeMap<String, Map<String, String>> getSqlReaderLine(String date) {
		
		
		Map<String, String> values = new HashMap<String, String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder("select");
		sql.append(" t.equipmentid, d.counts");
		sql.append(" from");
		sql.append(" water_bas_equipment t ");
		sql.append("  left join (select b.EQUIPMENTNAME, count(*) as counts from WATERDB.PERMANET t left join waterdb.water_bas_equipment b on t.bh = b.equipmentcode where t.uptime between to_date('"
				+ date
				+ " 00:00:00', 'yyyy-mm-dd hh24:mi:ss') and to_date('"
				+ date
				+ " 23:59:59', 'yyyy-mm-dd hh24:mi:ss') group by b.EQUIPMENTNAME) d");
		sql.append(" on d.EQUIPMENTNAME = t.EQUIPMENTNAME");
		sql.append(" left join datadic_items b");
		sql.append(" on b.id = t.equiptypecode");
		sql.append(" left join CODE_BAS_DISTRICT c");
		sql.append(" on t.DISTRICTCODE = c.DISTRICTCODE");
		sql.append(" where");
		sql.append(" b.DATA_NAME = '漏失监测仪'");
		sql.append(" order by t.EQUIPMENTNAME asc");

		StringBuilder sql1 = new StringBuilder("select");
		sql1.append(" t.equipmentid, d.counts");
		sql1.append(" from");
		sql1.append(" water_bas_equipment t ");
		sql1.append("left join (select t.equipmentid,count(t.equipmentid) as counts from WATERDB.MON_REALTIMEDATA_UP t left join waterdb.water_bas_equipment b on t.equipmentid = b.equipmentid where t.monitortime between to_date('"
				+ date
				+ " 00:00:00','yyyy-mm-dd hh24:mi:ss') and to_date('"
				+ date
				+ " 23:59:59','yyyy-mm-dd hh24:mi:ss') group by t.equipmentid ) d");
		sql1.append(" on d.equipmentid = t.equipmentid");
		sql1.append(" left join datadic_items b");
		sql1.append(" on b.id = t.equiptypecode");
		sql1.append(" left join CODE_BAS_DISTRICT c");
	    sql1.append("  on t.DISTRICTCODE = c.DISTRICTCODE");
		sql1.append(" where");
		sql1.append(" b.DATA_NAME != '漏失监测仪'");
		sql1.append(" order by  t.EQUIPMENTNAME asc");
		try {
			conn = JdbcFactory.getConnection();
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				sqlbean.setEQUIPMENTNAME(rs.getString("equipmentid"));
				if (StringUtil.isNullOrEmpty(rs.getString("counts"))) {
					sqlbean.setSQlrow("0");
				}else{
				sqlbean.setSQlrow(rs.getString("counts"));
				}
				values.put(sqlbean.getEQUIPMENTNAME(), sqlbean.getSQlrow());
			}
			rs=null;
			stmt = conn.prepareStatement(sql1.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				sqlbean.setEQUIPMENTNAME(rs.getString("equipmentid"));
				if (StringUtil.isNullOrEmpty(rs.getString("counts"))) {
					sqlbean.setSQlrow("0");
				}
				else{
				sqlbean.setSQlrow(rs.getString("counts"));
				}
				values.put(sqlbean.getEQUIPMENTNAME(), sqlbean.getSQlrow());

			}

			data.put(date.toString(), values);
			System.out.println(data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}
		return data;
	}

	public static TreeMap<String, Map<String, String>> getsqlmap( )
	{
		
		String str[]=getdate();
		for (int i = 0; i < Config.day-1; i++) {
			
			getSqlReaderLine(str[i]);
		}
		
		return data;
		
	}
	
	
	@SuppressWarnings("null")
	public static String[] getdate()
	{

		   String str[] =new String [99];
		   
		   for (int i = 0; i < Config.day-1; i++) {
			   
			   
			   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		        Calendar lastDate = Calendar.getInstance();
		        lastDate.roll(Calendar.DATE, -i);//日期回滚7天
		        String a=sdf.format(lastDate.getTime());
		        str[i]=new String(a);
		        System.out.println(a);
		      
			
		}
	       
			return str;


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
