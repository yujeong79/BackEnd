 package com.ssafy.hw.step2.util;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;

 /**
  * Mysql DB 연결 객체를 제공해주고, 사용했던 자원을 해제하는 기능을 제공하는 클래스입니다.
  *
  */
 public class DBUtil {
 	// DB와 연결하기위해 필요한 DB의 URL
 	private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
 	// DB의 USER 이름
 	private final String username = "ssafy";
 	// 위 USER의 PASSWORD
 	private final String password = "ssafy";
 	// Mysql 드라이버 클래스 이름
 	private final String drivername = "com.mysql.cj.jdbc.Driver";

 	private static DBUtil instance = new DBUtil();
	
 	private DBUtil() {
 		try {
 			Class.forName(drivername);
 		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
 		}
 	}
	
 	public static DBUtil getInstance() {
 		return instance;
 	}

 	public Connection getConnection() throws SQLException {
 		return DriverManager.getConnection(url, username, password);
 	}
	
 	// 자원 해제
 	public static void close(Connection conn, PreparedStatement pstmt) {

 		try {
 			if (pstmt != null)
 				pstmt.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 		try {
 			if (conn != null)
 				conn.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 	}

 	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

 		try {
 			if (rs != null)
 				rs.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 		try {
 			if (pstmt != null)
 				pstmt.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 		try {
 			if (conn != null)
 				conn.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 	}

 }
