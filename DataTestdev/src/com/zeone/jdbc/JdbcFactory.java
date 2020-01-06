package com.zeone.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcFactory {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.5.4.13:1521:LIFELINE";
		String user = "LIFELINEDEV";
		String pass = "LIFELINEDEV";
		Connection conn = DriverManager.getConnection(url, user, pass);
	
		return conn;
	}
	
	
	public static Connection getConnection14() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.5.4.14:1521:LIFELINEGIS";
		String user = "PLATFORM";
		String pass = "PLATFORM";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
	
		
		return conn;
	}
	
	
	
	
	public static Connection getConnection15() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.5.4.15:1521:LIFELINE";
		String user = "SCDPLATFORM";
		String pass = "SCDPLATFORM";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
	
		return conn;
	}
	
	
	public static Connection getConnection43() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.100.96.43:1521:LIFELINE";
		String user = "PLATFORM";
		String pass = "PLATFORM";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
	
		return conn;
	}
	public static Connection getConnection25() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.5.4.25:1521:XZLIFELINE";
		String user = "PLATFORM";
		String pass = "PLATFORM";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
	
		return conn;
	}
}
