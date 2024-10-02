package com.ssafy.ws.step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8080/context-root/main 경로와 JdbcServlet 클래스를 매핑
@WebServlet("/main")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// GET 요청을 처리하기 위한 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 응답 컨텐츠 타입을 text/html과 UTF-8로 설정 (한글깨짐 방지)
		response.setContentType("text/html;charset=UTF-8");
		
		Connection conn = null; // DB 연결 객체
		Statement stmt = null; // SQL 수행 객체

		// 조회 결과를 출력
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>JDBC 연결 테스트</title></head><body>");
		out.println("<h1>SSAFY DB 연결 테스트</h1><hr>");

		try {
			
			
			/* 
			 * 
			 * [참고]
			 * java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver 오류가 발생하면
			 * maven update project 를 수행하여 mysql-connector-j 의존성을 다운로드 받아야 합니다.
			 * 
			 */
			
			
			
			
			/*
			 * 
			 * JDBC 드라이버 로드
			 * "com.mysql.cj.jdbc.Driver"는 MySQL JDBC 드라이버 클래스 이름입니다.
			 * Java 애플리케이션과 MySQL 데이터베이스 간의 통신이 가능해집니다.
			 * 
			 */
			
			
			// Q.MySQL JDBC 드라이버 클래스를 로드해 봅시다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.println("<h1>드라이버 로딩 성공</h1>");
			
			
			
			/*
			 * 
			 * DB 연결하기
			 * 데이터베이스에 연결하기 위해 데이터베이스 Connection 객체를 생성해야 합니다.
			 * 이때, 데이터베이스의 주소, 아이디, 패스워드 3가지 정보가 필요합니다.
			 * 
			 */
			
			// DB 연결 정보 설정
			String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
			String id = "ssafy";
			String pw = "ssafy";
			
			
			// Q. DriverManager의 특정 메서드를 사용하여 데이터베이스에 연결해 봅시다.
			conn = DriverManager.getConnection(url, id, pw);
			out.println("<h1>데이터베이스 연결 성공</h1>");

			
			/*
			 * 
			 * SQL 실행 객체 생성
			 * 연결된 데이터베이스 객체를 통해 SQL을 실행할 수 있는 객체를 생성하고, SQL을 작성해야 합니다.
			 * 
			 */

			// Q. conn 객체로부터 특정 메서드를 사용하여 Statement 객체를 생성해 봅시다.
			stmt = conn.createStatement();
			out.println("<h1>Statement 객체 생성 성공</h1>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			out.println("<h1>연결 중 오류가 발생했습니다!</h1>");
			
		} finally {
			
			// 리소스는 생성의 역순으로 해제
			// Statement가 null이 아닌 경우 (즉, Statement가 생성되어 있다면) 닫아서 리소스를 해제합니다.
			if (stmt != null) {
				try {
					
					// Statement를 해제합니다. 이는 데이터베이스와의 연결을 종료하며, 리소스를 해제하는 작업입니다.
					// Q. stmt 객체를 해제해 봅시다.
					stmt.close();
					
					
				} catch (SQLException e) {
					
				}
			}
			
			// Connection이 null이 아닌 경우 (즉, 데이터베이스 연결이 성립되어 있다면) 닫아서 리소스를 해제합니다.
			if (conn != null) {
				try {
					
					// Connection을 해제합니다. 이는 데이터베이스와의 연결을 종료하며, 리소스를 해제하는 작업입니다.
					// Q. conn 객체를 해제해 봅시다.
					conn.close();
					
				} catch (SQLException e) {
					
				}
			}
			
			out.println("<h1>DB 리소스를 모두 해제했습니다.</h1>");
		}
		
		out.println("</body></html>");
	}
}
