package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.zeone.bean.Sqlvlaue;
import com.zeone.io.FileOperation;

/**
 * 数据库相关操作
 */

public class sqlvlaueService {
	/**
	 * 获取传感器的数据的信息
	 * 
	 */
	public static final String Qingjiao = "Mon_Realtimedata_Dips";
	public static final String NAODU = "MON_REALTIMEDATA_DEFLECTION";
	public static final String Jiasudu = "MONREALD_ACCELERATION_UP";
	public static final String Diaoganli = "MON_REALTIMEDATA_SUSPENDER";
	public static final String Yingbian = "MONREALD_STRAIN_UP";
	public static final String Weiyi = "MONREALD_DISPLACE_UP";
	public static final String Wendu = "MON_REALTIMEDATA_TEM";
	public static final String DTNaodu = "MONREALD_DEFLECTIONDT_UP";
	public static final String Fengsu = "null";
	public static final String Fengxiang = "null";

	public static List<Sqlvlaue> getAllsqlrows(List<Sqlvlaue> data) {

		StringBuffer sb = new StringBuffer();
		sb.append("桥梁名称" + "\t");// 桥梁名称
		sb.append("桥梁主机号" + "\t");// 桥梁主机号
		sb.append("模块号" + "\t");// 模块号
		sb.append("通道号" + "\t");// 通道号
		sb.append("传感器名称" + "\t");// 传感器名称
		sb.append("频率" + "\t");// 频率
		sb.append("传感器类型" + "\t");// 传感器类型
		sb.append("数据时间" + "\t");// 数据时间
		sb.append("理论值" + "\t");// 理论值
		sb.append("采集平台条数" + "\t");// 采集平台条数
		sb.append("数据库条数" + "\n");// 数据条数

		FileOperation.writeTxFile(sb.toString(), data.get(0).getDatetime(),
				"_业务系统入库数据统计");
		for (int i = 0; i < data.size(); i++) {

			Sqlvlaue s = data.get(i);
			int sqlrow = getsqlrow(s);
			s.setSqlrow(sqlrow);
			StringBuffer sb2 = new StringBuffer();
			sb2.append(s.getBridgename() + "\t");// 桥梁名称
			sb2.append(s.getGatewaynum() + "\t");// 桥梁主机号
			sb2.append(s.getModularnum() + "\t");// 模块号
			sb2.append(s.getPathnum() + "\t");// 通道号
			sb2.append(s.getEquipmentname() + "\t");// 传感器名称
			sb2.append(s.getPl() + "\t");// 频率
			sb2.append(s.getLeixing() + "\t");// 传感器类型
			sb2.append(s.getDatetime() + "\t");// 数据时间
			sb2.append(s.getNum() + "\t");// 理论值
			sb2.append(s.getFilerow() + "\t");// 采集平台条数
			sb2.append(sqlrow + "\n");// 数据条数
			FileOperation.writeTxFile(sb2.toString(), s.getDatetime(),
					"_业务系统入库数据统计");

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
	static int i;
	public static int getsqlrow(Sqlvlaue s)

	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tablename = gettablename(s.getLeixing());
		String modularnum = s.getModularnum();
		String pathnum = s.getPathnum();
		String gatewaynum = s.getGatewaynum();
		String time = s.getDatetime();
		
		if (tablename != "null"&&s.getFilelx().equals("单测量值")) {
			String sql = "select count(monitortime) as Rownumber from "
					+ tablename
					+ " t where t.modularnum="
					+ modularnum
					+ " and t.pathnum="
					+ pathnum
					+ " and t.gatewaynum="
					+ "'"+gatewaynum+"'"
					+ " and t.monitortime between TO_TIMESTAMP('"
					+ time
					+ " 00:00:00.000000','YYYYMMDD HH24:MI:SS.ff6') and TO_TIMESTAMP('"
					+ time + " 23:59:59.000000','YYYYMMDD HH24:MI:SS.ff6')";
			
			try {
				conn = JdbcFactory.getConnection();
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					
					return Integer.parseInt((rs.getString("Rownumber")));
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				close(conn, stmt, rs);
			}
		}
		
		System.out.println(++i);
		return -1;

	}

	/**
	 * 
	 * 
	 * @param leixing
	 * @return
	 * 
	 * 
	 */
	public static String gettablename(String leixing)

	{

		if (leixing.equals("加速度")) {
			return Jiasudu;
		} else if (leixing.equals("位移")) {
			return Weiyi;
		} else if (leixing.equals("倾角")) {
			return Qingjiao;
		} else if (leixing.equals("挠度")) {
			return NAODU;
		} else if (leixing.equals("吊杆力")) {
			return Diaoganli;
		} else if (leixing.equals("应变")) {
			return Yingbian;
		} else if (leixing.equals("温度")) {
			return Wendu;
		} else if (leixing.equals("动态挠度")) {
			return DTNaodu;
		} else if (leixing.equals("风速")) {
			return Fengsu;
		} else if (leixing.equals("风向")) {
			return Fengxiang;
		}

		return "null";

	}
}
