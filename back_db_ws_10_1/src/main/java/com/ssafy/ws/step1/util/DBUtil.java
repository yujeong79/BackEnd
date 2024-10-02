 package com.ssafy.ws.step1.util;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;


 /**
  * Mysql DB 연결 객체를 제공하주고, 사용했던 자원을 해제하는 기능을 제공하는 클래스입니다.
  */
 public class DBUtil {
	
 	// DB와 연결하기위해 필요한 DB의 URL
 	private final String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
 	// DB의 USER 이름
 	private final String username = "ssafy";
 	// 위 USER의 PASSWORD
 	private final String password = "ssafy";
 	// Mysql 드라이버 클래스 이름
 	private final String driverName = "com.mysql.cj.jdbc.Driver";

 	/**
      * Singleton Design Pattern을 적용해준다.
      */
 	private static DBUtil instance = new DBUtil();

     private DBUtil() {
         // JDBC 드라이버를 로딩한다. 드라이버 로딩은 객체 생성 시 한번만 진행하도록 하자.
         try {
         	Class.forName(driverName);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
    
     public static DBUtil getInstance() {
         return instance;
     }
    
     public Connection getConnection() throws SQLException{
     	return DriverManager.getConnection(url, username, password);
     }
	
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
