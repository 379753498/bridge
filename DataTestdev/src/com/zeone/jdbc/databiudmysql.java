package com.zeone.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zeone.bean.bridgemathpath;
import com.zeone.bean.bridgetestbaobiao;
import com.zeone.data.databiud;
import com.zeone.io.FileOperation;

/**
 * 
 CREATE TABLE `bridgedatatestdev` (
 * 
 * `bridgename` VARCHAR (150), `equipmentname` VARCHAR (150), `Pathnum` VARCHAR
 * (150), `modularnum` VARCHAR (150), `leixing` VARCHAR (150),
 * `zhongduanshijian` VARCHAR (150), `nowdate` VARCHAR (150),
 * `chongfushujugeshu` DOUBLE, `leijizhongduanshijian` DOUBLE, `filerow` DOUBLE,
 * `lilunfilerow` DOUBLE, `timesize` DOUBLE, `lilunsize` DOUBLE, `pl` DOUBLE,
 * `lilunpl` DOUBLE, `zhongduanshuju` DOUBLE, `chaochuliangchenggeshu` DOUBLE,
 * `lishishujutiaoshu`DOUBLE, `weilaishujutiaoshu`DOUBLE,
 * `shujujieshoushijianyichangzongshu`DOUBLE, `cuowuPLzhanbi`DOUBLE,
 * `leijizhongduanshijianzhanbi`DOUBLE, `chongfushujzhanbi`DOUBLE,
 * `chaochuliangchengfanweizhanbi`DOUBLE, `jieshouyichangzongshuzhanbi` DOUBLE
 * 
 * );
 * 
 */

public class databiudmysql {
	static String name;

	public static void insertintotable(ArrayList<databiud> databiud)
			throws Exception {
		MysqljdbcFactory ma = new MysqljdbcFactory();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tablename = "bridgedatatestdev";
		StringBuffer sb = new StringBuffer("insert into ");
		sb.append(tablename + " ");
		sb.append("(bridgename,equipmentname,Pathnum,modularnum,leixing,zhongduanshijian,nowdate,chongfushujugeshu,leijizhongduanshijian,filerow,lilunfilerow,timesize,lilunsize,pl,lilunpl,zhongduanshuju,chaochuliangchenggeshu,lishishujutiaoshu,weilaishujutiaoshu,shujujieshoushijianyichangzongshu,cuowuPLzhanbi,leijizhongduanshijianzhanbi,chongfushujzhanbi,chaochuliangchengfanweizhanbi,jieshouyichangzongshuzhanbi)");
		sb.append(" ");
		sb.append("values ");
		sb.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String sql = sb.toString();

		try {
			conn = ma.getConnection();

			for (databiud da : databiud) {

				stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setString(1, da.getBridgename());
				stmt.setString(2, da.getEquipmentname());
				stmt.setString(3, da.getPathnum());
				stmt.setString(4, da.getModularnum());
				stmt.setString(5, da.getLeixing());
				stmt.setString(6, da.getZhongduanshijian());
				stmt.setString(7, da.getNowdate());
				stmt.setDouble(8, da.getChongfushujugeshu());
				stmt.setDouble(9, da.getLeijizhongduanshijian());
				stmt.setDouble(10, da.getFilerow());
				stmt.setDouble(11, da.getLilunfilerow());
				stmt.setDouble(12, da.getTimesize());
				stmt.setDouble(13, da.getLilunsize());
				stmt.setDouble(14, da.getPl());
				stmt.setDouble(15, da.getLilunpl());
				stmt.setDouble(16, da.getZhongduanshuju());
				stmt.setDouble(17, da.getChaochuliangchenggeshu());
				stmt.setDouble(18, da.getLishishujutiaoshu());
				stmt.setDouble(19, da.getWeilaishujutiaoshu());
				stmt.setDouble(20, da.getShujujieshoushijianyichangzongshu());
				stmt.setDouble(21, da.getCuowuPLzhanbi());
				stmt.setDouble(22, da.getLeijizhongduanshijianzhanbi());
				stmt.setDouble(23, da.getChongfushujzhanbi());
				stmt.setDouble(24, da.getChaochuliangchengfanweizhanbi());
				stmt.setDouble(25, da.getJieshouyichangzongshuzhanbi());
				stmt.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public static void insertintotable(databiud da)
			throws Exception {
		MysqljdbcFactory ma = new MysqljdbcFactory();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tablename = "bridgedatatestdev";
		StringBuffer sb = new StringBuffer("insert into ");
		sb.append(tablename + " ");
		sb.append("(bridgename,equipmentname,Pathnum,modularnum,leixing,zhongduanshijian,nowdate,chongfushujugeshu,leijizhongduanshijian,filerow,lilunfilerow,timesize,lilunsize,pl,lilunpl,zhongduanshuju,chaochuliangchenggeshu,lishishujutiaoshu,weilaishujutiaoshu,shujujieshoushijianyichangzongshu,cuowuPLzhanbi,leijizhongduanshijianzhanbi,chongfushujzhanbi,chaochuliangchengfanweizhanbi,jieshouyichangzongshuzhanbi)");
		sb.append(" ");
		sb.append("values ");
		sb.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String sql = sb.toString();

		try {
			conn = ma.getConnection();

		

				stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setString(1, da.getBridgename());
				stmt.setString(2, da.getEquipmentname());
				stmt.setString(3, da.getPathnum());
				stmt.setString(4, da.getModularnum());
				stmt.setString(5, da.getLeixing());
				stmt.setString(6, da.getZhongduanshijian());
				stmt.setString(7, da.getNowdate());
				stmt.setDouble(8, da.getChongfushujugeshu());
				stmt.setDouble(9, da.getLeijizhongduanshijian());
				stmt.setDouble(10, da.getFilerow());
				stmt.setDouble(11, da.getLilunfilerow());
				stmt.setDouble(12, da.getTimesize());
				stmt.setDouble(13, da.getLilunsize());
				stmt.setDouble(14, da.getPl());
				stmt.setDouble(15, da.getLilunpl());
				stmt.setDouble(16, da.getZhongduanshuju());
				stmt.setDouble(17, da.getChaochuliangchenggeshu());
				stmt.setDouble(18, da.getLishishujutiaoshu());
				stmt.setDouble(19, da.getWeilaishujutiaoshu());
				stmt.setDouble(20, da.getShujujieshoushijianyichangzongshu());
				stmt.setDouble(21, da.getCuowuPLzhanbi());
				stmt.setDouble(22, da.getLeijizhongduanshijianzhanbi());
				stmt.setDouble(23, da.getChongfushujzhanbi());
				stmt.setDouble(24, da.getChaochuliangchengfanweizhanbi());
				stmt.setDouble(25, da.getJieshouyichangzongshuzhanbi());
				stmt.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void insertintotabletz(ArrayList<databiud> databiud)
			throws Exception {
		MysqljdbcFactory ma = new MysqljdbcFactory();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tablename = "bridgedatatestdevtz";
		StringBuffer sb = new StringBuffer("insert into ");
		sb.append(tablename + " ");
		sb.append("(bridgename,equipmentname,Pathnum,modularnum,leixing,zhongduanshijian,nowdate,chongfushujugeshu,leijizhongduanshijian,filerow,lilunfilerow,timesize,lilunsize,pl,lilunpl,zhongduanshuju,chaochuliangchenggeshu,lishishujutiaoshu,weilaishujutiaoshu,shujujieshoushijianyichangzongshu,cuowuPLzhanbi,leijizhongduanshijianzhanbi,chongfushujzhanbi,chaochuliangchengfanweizhanbi,jieshouyichangzongshuzhanbi)");
		sb.append(" ");
		sb.append("values ");
		sb.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String sql = sb.toString();

		try {
			conn = ma.getConnection();

			for (databiud da : databiud) {

				stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setString(1, da.getBridgename());
				stmt.setString(2, da.getEquipmentname());
				stmt.setString(3, da.getPathnum());
				stmt.setString(4, da.getModularnum());
				stmt.setString(5, da.getLeixing());
				stmt.setString(6, da.getZhongduanshijian());
				stmt.setString(7, da.getNowdate());
				stmt.setDouble(8, da.getChongfushujugeshu());
				stmt.setDouble(9, da.getLeijizhongduanshijian());
				stmt.setDouble(10, da.getFilerow());
				stmt.setDouble(11, da.getLilunfilerow());
				stmt.setDouble(12, da.getTimesize());
				stmt.setDouble(13, da.getLilunsize());
				stmt.setDouble(14, da.getPl());
				stmt.setDouble(15, da.getLilunpl());
				stmt.setDouble(16, da.getZhongduanshuju());
				stmt.setDouble(17, da.getChaochuliangchenggeshu());
				stmt.setDouble(18, da.getLishishujutiaoshu());
				stmt.setDouble(19, da.getWeilaishujutiaoshu());
				stmt.setDouble(20, da.getShujujieshoushijianyichangzongshu());
				stmt.setDouble(21, da.getCuowuPLzhanbi());
				stmt.setDouble(22, da.getLeijizhongduanshijianzhanbi());
				stmt.setDouble(23, da.getChongfushujzhanbi());
				stmt.setDouble(24, da.getChaochuliangchengfanweizhanbi());
				stmt.setDouble(25, da.getJieshouyichangzongshuzhanbi());
				stmt.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close(conn, stmt, rs);
		}

	}

	public static void insertintotabletz(databiud da)
			throws Exception {
		MysqljdbcFactory ma = new MysqljdbcFactory();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tablename = "bridgedatatestdevtz";
		StringBuffer sb = new StringBuffer("insert into ");
		sb.append(tablename + " ");
		sb.append("(bridgename,equipmentname,Pathnum,modularnum,leixing,zhongduanshijian,nowdate,chongfushujugeshu,leijizhongduanshijian,filerow,lilunfilerow,timesize,lilunsize,pl,lilunpl,zhongduanshuju,chaochuliangchenggeshu,lishishujutiaoshu,weilaishujutiaoshu,shujujieshoushijianyichangzongshu,cuowuPLzhanbi,leijizhongduanshijianzhanbi,chongfushujzhanbi,chaochuliangchengfanweizhanbi,jieshouyichangzongshuzhanbi)");
		sb.append(" ");
		sb.append("values ");
		sb.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		String sql = sb.toString();

		try {
			conn = ma.getConnection();

		

				stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setString(1, da.getBridgename());
				stmt.setString(2, da.getEquipmentname());
				stmt.setString(3, da.getPathnum());
				stmt.setString(4, da.getModularnum());
				stmt.setString(5, da.getLeixing());
				stmt.setString(6, da.getZhongduanshijian());
				stmt.setString(7, da.getNowdate());
				stmt.setDouble(8, da.getChongfushujugeshu());
				stmt.setDouble(9, da.getLeijizhongduanshijian());
				stmt.setDouble(10, da.getFilerow());
				stmt.setDouble(11, da.getLilunfilerow());
				stmt.setDouble(12, da.getTimesize());
				stmt.setDouble(13, da.getLilunsize());
				stmt.setDouble(14, da.getPl());
				stmt.setDouble(15, da.getLilunpl());
				stmt.setDouble(16, da.getZhongduanshuju());
				stmt.setDouble(17, da.getChaochuliangchenggeshu());
				stmt.setDouble(18, da.getLishishujutiaoshu());
				stmt.setDouble(19, da.getWeilaishujutiaoshu());
				stmt.setDouble(20, da.getShujujieshoushijianyichangzongshu());
				stmt.setDouble(21, da.getCuowuPLzhanbi());
				stmt.setDouble(22, da.getLeijizhongduanshijianzhanbi());
				stmt.setDouble(23, da.getChongfushujzhanbi());
				stmt.setDouble(24, da.getChaochuliangchengfanweizhanbi());
				stmt.setDouble(25, da.getJieshouyichangzongshuzhanbi());
				stmt.execute();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close(conn, stmt, rs);
		}

	}
	
	public static void insertbridgedatatestdpath(bridgemathpath da)
			throws Exception {
		MysqljdbcFactory ma = new MysqljdbcFactory();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String tablename = "bridgedatatestdpath";
		StringBuffer sb = new StringBuffer("insert into ");
		sb.append(tablename + " ");
		sb.append("(bridgename,equipmentid,gatewaynum,equipmentname,Pathnum,modularnum ,leixing,nowdate,NAME,avg,filerow)");
		sb.append(" ");
		sb.append("values ");
		sb.append("(?,?,?,?,?,?,?,?,?,?,?)");
		String sql = sb.toString();

		try {
			conn = ma.getConnection();
				stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setString(1, da.getBridgename());
				stmt.setString(2, da.getEquipmentid());
				stmt.setString(3, da.getGatewaynum());
				stmt.setString(4, da.getEquipmentname());
				stmt.setString(5, da.getPathnum());
				stmt.setString(6, da.getModularnum());
				stmt.setString(7, da.getLeixing());
				stmt.setString(8, da.getNowdate());
				stmt.setString(9, da.getName());
				stmt.setDouble(10, da.getAvg());
				stmt.setDouble(11, da.getFilerow());
				stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close(conn, stmt, rs);
		}

	}
	
	
	
	public  void testbaobiao(String bridgename, String date,
			String tablename) throws SQLException, InterruptedException {
		// 实现思路
		// 1、查询该桥梁当天有没有数据；｛有，没有｝
		// 2、查询该桥梁历史有没有数据｛有，没有｝
		
		bridgetestbaobiaoservice bg= new bridgetestbaobiaoservice();
		// 3、
	
		if (tablename.equals("bridgedatatestdevtz")) {

			name = "特征值";
		} else {
			name = "实时值";
		}

		MysqljdbcFactory ma = new MysqljdbcFactory();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = ma.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}

		StringBuffer sb = new StringBuffer("select ");
		sb.append("COUNT(*) AS countnum FROM ");
		sb.append(tablename + " t");
		sb.append("  WHERE t.`nowdate`='" + date + "' ");
		sb.append("AND t.`bridgename`='" + bridgename + "'");
		String jintianyoushujuma = sb.toString();

//		String lishiyoushujma = "SELECT   COUNT(*) AS countnum FROM  `"
//				+ tablename + "` t WHERE   t.`bridgename`='" + bridgename + "'";

		rs = findrs(conn, jintianyoushujuma);
		 ArrayList<bridgetestbaobiao> bridgetestbaobiao = bg.getlist(bridgename);

		while (rs.next()) {

			
			if (rs.getInt("countnum") > 0) {

				String sql = "SELECT   COUNT(*) AS countnum FROM  " + tablename
						+ " t WHERE t.`nowdate`='" + date
						+ "' AND t.`bridgename`='" + bridgename
						+ "'  AND t.`leijizhongduanshijianzhanbi`!=0";
				rs = findrs(conn, sql);
				sql = null;

				while (rs.next()) {

					if (rs.getInt("countnum") > 0) {
						String sql1 = "SELECT a.bridgename, a.`leixing`,c.v zts, SUM(a.`leijizhongduanshijianzhanbi`)/b.v avgzd ,b.v zdts  FROM  (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "'  AND t.`leijizhongduanshijianzhanbi`!=0 GROUP BY t.`leixing` ) b LEFT JOIN "
								+ tablename
								+ " AS a ON b.b=a.`leixing` LEFT JOIN (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "' GROUP BY t.`leixing` ) c ON b.b=c.b WHERE a.`nowdate`='"
								+ date
								+ "' AND a.`bridgename`='"
								+ bridgename
								+ "'  AND a.`leijizhongduanshijianzhanbi`!=0 GROUP BY a.`leixing`";

						rs = findrs(conn, sql1);
						sql1 = null;
						while (rs.next()) {

							for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
								if (bgbb.getLeixing().equals(
										rs.getString("leixing"))) {

									bgbb.setAvgzd(rs.getString("avgzd"));
									bgbb.setZdts(rs.getString("zdts"));
									break;
								}

							}

						}
						
						
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("中断数据" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
						bridgetestbaobiao =bg.getlist(bridgename);;
				
					}

					else {
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("中断数据" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
					}

					bridgetestbaobiao =bg.getlist(bridgename);
					
				}

				String sql1 = "SELECT   COUNT(*) AS countnum FROM  "
						+ tablename + " t WHERE t.`nowdate`='" + date
						+ "' AND t.`bridgename`='" + bridgename
						+ "'  AND t.`cuowuPLzhanbi`!=0";
				rs = findrs(conn, sql1);

				sql1 = null;
				while (rs.next()) {
					if (rs.getInt("countnum") > 0) {
						String sql11 = "SELECT a.bridgename, a.`leixing`,c.v zts, SUM(a.`cuowuPLzhanbi`)/b.v avgzd ,b.v zdts  FROM  (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "'  AND t.`cuowuPLzhanbi`!=0  GROUP BY t.`leixing` ) b  LEFT JOIN "
								+ tablename
								+ " AS a ON b.b=a.`leixing` LEFT JOIN (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "' GROUP BY t.`leixing` ) c ON b.b=c.b WHERE a.`nowdate`='"
								+ date
								+ "' AND a.`bridgename`='"
								+ bridgename
								+ "'  AND a.`cuowuPLzhanbi`!=0 GROUP BY a.`leixing`";
						rs = findrs(conn, sql11);
						sql11 = null;
						while (rs.next()) {

							for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
								if (bgbb.getLeixing().equals(
										rs.getString("leixing"))) {

									bgbb.setAvgzd(rs.getString("avgzd"));
									bgbb.setZdts(rs.getString("zdts"));
									break;
								}

							}

						}
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("错误频率" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
						bridgetestbaobiao =bg.getlist(bridgename);
				
					}

					else {
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("错误频率" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
					}

					bridgetestbaobiao =bg.getlist(bridgename);
					
				}

				String sql1a = "SELECT   COUNT(*) AS countnum FROM  "
						+ tablename + " t WHERE t.`nowdate`='" + date
						+ "' AND t.`bridgename`='" + bridgename
						+ "'  AND t.`chongfushujzhanbi`!=0";
				rs = findrs(conn, sql1a);

				sql1a = null;
				while (rs.next()) {
					if (rs.getInt("countnum") > 0) {
						String sql1b = "SELECT a.bridgename, a.`leixing`,c.v zts, SUM(a.`chongfushujzhanbi`)/b.v avgzd ,b.v zdts  FROM  (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "'  AND t.`chongfushujzhanbi`!=0  GROUP BY t.`leixing` ) b LEFT JOIN "
								+ tablename
								+ " AS a ON b.b=a.`leixing` LEFT JOIN (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "' GROUP BY t.`leixing` ) c  ON b.b=c.b WHERE a.`nowdate`='"
								+ date
								+ "' AND a.`bridgename`='"
								+ bridgename
								+ "' AND a.`chongfushujzhanbi`!=0 GROUP BY a.`leixing`";
						rs = findrs(conn, sql1b);
						sql1b = null;
						while (rs.next()) {

							for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
								if (bgbb.getLeixing().equals(
										rs.getString("leixing"))) {

									bgbb.setAvgzd(rs.getString("avgzd"));
									bgbb.setZdts(rs.getString("zdts"));
									break;
								}

							}

						}
						
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("重复数据" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
						bridgetestbaobiao =bg.getlist(bridgename);
						
					}

					else {
						bridgetestbaobiao=bg.getlist(bridgename);
						bridgetestbaobiao=bg.getlist(bridgename);
						for (bridgetestbaobiao bgbb :  bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("重复数据" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
					}

					bridgetestbaobiao =bg.getlist(bridgename);
				}

				String sql1c = "SELECT   COUNT(*) AS countnum FROM  "
						+ tablename + " t WHERE t.`nowdate`='" + date
						+ "' AND t.`bridgename`='" + bridgename
						+ "'  AND t.`chaochuliangchengfanweizhanbi`!=0";
				rs = findrs(conn, sql1c);
				sql1c = null;
				while (rs.next()) {
					if (rs.getInt("countnum") > 0) {

						String sql1d = "SELECT a.bridgename, a.`leixing`,c.v zts, SUM(a.`chaochuliangchengfanweizhanbi`)/b.v avgzd ,b.v zdts  FROM  (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "'  AND t.`chaochuliangchengfanweizhanbi`!=0 GROUP BY t.`leixing` ) b LEFT JOIN "
								+ tablename
								+ " AS a ON b.b=a.`leixing` LEFT JOIN (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "' GROUP BY t.`leixing` ) c ON b.b=c.b WHERE a.`nowdate`='"
								+ date
								+ "' AND a.`bridgename`='"
								+ bridgename
								+ "'  AND a.`chaochuliangchengfanweizhanbi`!=0 GROUP BY a.`leixing`";
						rs = findrs(conn, sql1d);
						sql1d = null;
						while (rs.next()) {

							for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
								if (bgbb.getLeixing().equals(
										rs.getString("leixing"))) {

									bgbb.setAvgzd(rs.getString("avgzd"));
									bgbb.setZdts(rs.getString("zdts"));
									break;
								}

							}

						}
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("超出量程" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
						bridgetestbaobiao =bg.getlist(bridgename);
					}

					else {
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("超出量程" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
					}

					bridgetestbaobiao =bg.getlist(bridgename);

				}

				String sql1f = "SELECT   COUNT(*) AS countnum FROM  "
						+ tablename + " t WHERE t.`nowdate`='" + date
						+ "' AND t.`bridgename`='" + bridgename
						+ "'  AND t.`jieshouyichangzongshuzhanbi`!=0";
				rs = findrs(conn, sql1f);
				sql1f = null;
				while (rs.next()) {
					if (rs.getInt("countnum") > 0) {

						String sql1g = "SELECT a.bridgename, a.`leixing`,c.v zts, SUM(a.`jieshouyichangzongshuzhanbi`)/b.v avgzd ,b.v zdts  FROM  (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "'  AND t.`jieshouyichangzongshuzhanbi`!=0  GROUP BY t.`leixing` ) b LEFT JOIN "
								+ tablename
								+ " AS a ON b.b=a.`leixing` LEFT JOIN (SELECT   t.`leixing` b,COUNT(*) v FROM  `"
								+ tablename
								+ "`  t WHERE t.`nowdate`='"
								+ date
								+ "' AND t.`bridgename`='"
								+ bridgename
								+ "' GROUP BY t.`leixing` ) c ON b.b=c.b WHERE a.`nowdate`='"
								+ date
								+ "' AND a.`bridgename`='"
								+ bridgename
								+ "'  AND a.`jieshouyichangzongshuzhanbi`!=0 GROUP BY a.`leixing`";
						rs = findrs(conn, sql1g);
						sql1g = null;
						while (rs.next()) {

							for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
								if (bgbb.getLeixing().equals(
										rs.getString("leixing"))) {

									bgbb.setAvgzd(rs.getString("avgzd"));
									bgbb.setZdts(rs.getString("zdts"));
									break;
								}

							}

						}
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("接收异常" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
						bridgetestbaobiao =bg.getlist(bridgename);					}

					else {
						for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
							StringBuffer sb1 = new StringBuffer();
							sb1.append(bgbb.getBridgename() + "\t");
							sb1.append(name + "\t");
							sb1.append("接收异常" + "\t");
							sb1.append(bgbb.getLeixing() + "\t");
							sb1.append(bgbb.getZts() + "\t");
							sb1.append(bgbb.getAvgzd() + "\t");
							sb1.append(bgbb.getZdts() + "\n");
							FileOperation.writeTxFile(sb1.toString(), date,
									"桥梁整体数据汇总");
							sb1 = new StringBuffer();

						}
					}

					bridgetestbaobiao =bg.getlist(bridgename);
				}

			}

			else {
				for (bridgetestbaobiao bgbb : bridgetestbaobiao) {
					StringBuffer sb1 = new StringBuffer();
					sb1.append(bgbb.getBridgename() + "\t");
					sb1.append(name + "\t");
					sb1.append("没有数据" + "\t");
					sb1.append(bgbb.getLeixing() + "\t");
					sb1.append(bgbb.getZts() + "\t");
					sb1.append(bgbb.getAvgzd() + "\t");
					sb1.append(bgbb.getZdts() + "\n");
					FileOperation.writeTxFile(sb1.toString(), date, "桥梁整体数据汇总");
					sb1 = new StringBuffer();

				}
				bridgetestbaobiao =bg.getlist(bridgename);
			}
		}

		close(conn, stmt, rs);
	}

	public static ResultSet findrs(java.sql.Connection conn, String sql)
			throws SQLException {

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		return rs;

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
