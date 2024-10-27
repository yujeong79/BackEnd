package com.ssafy.ws.step3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";;
	static final String user = "root";
	static final String pass = "rladbwjd79!";
	static final String drivername = "com.mysql.cj.jdbc.Driver"; 
	
	// 싱글턴 ////////////////////////////////////////////////////////////////
	// 1. 기본 생성자를 호출할 때 바로 driver를 메모리에 올리자
	private DBUtil() {
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static DBUtil instance = new DBUtil();
	
	public static DBUtil getInstance() {
		return instance;
	}		
	///////////////////////////////////////////////////////////////////////
	
	// 2. 메모리에 있는 driver와 연결
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
