package com.ssafy.ws.step2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mysql DB 연결 객체를 제공하주고, 사용했던 자원을 해제하는 기능을 제공하는 클래스입니다.
 */
public class DBUtil {
	private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
	private final String username = "ssafy";
	private final String password = "ssafy";
	private final String drivername = "com.mysql.cj.jdbc.Driver";
	
	private static DBUtil instance = new DBUtil();
	
	public DBUtil() { // 기본 생성자 안에서 드라이버 로드
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBUtil getInstance() {
		return instance;
	}
	
	// 연결
	public Connection getConnection() throws SQLException { 
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

