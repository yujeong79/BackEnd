package com.ssafy.ws.step2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*
JDBC 클래스와 중요 메서드들에 대해 알아보기

- java.sql.Connection
    - createStatement(): Statement 객체를 생성합니다.
    - prepareStatement(String sql): 주어진 SQL 문을 PreparedStatement 객체로 컴파일합니다.
    - close(): 데이터베이스 연결을 종료합니다.
    - commit(): 트랜잭션의 모든 변경사항을 데이터베이스에 반영합니다.
    - rollback(): 트랜잭션의 모든 변경사항을 취소합니다.
    
- java.sql.Statement
    - executeQuery(String sql) : 주어진 SQL 명령이 SELECT 문인 경우, SQL 문을 실행하고 ResultSet 객체를 반환합니다.
    - executeUpdate(String sql) : 주어진 SQL 명령이 INSERT, UPDATE 또는 DELETE 문이거나 DDL(Data Definition Language) 명령인 경우, SQL 문을 실행합니다.
    - close() : Statement 객체를 닫습니다.
    
- java.sql.PreparedStatement
    - executeUpdate(): INSERT, UPDATE 또는 DELETE 문 또는 SQL DDL(Data Definition Language) 문을 실행합니다.
    - setString(int parameterIndex, String x): 지정된 인덱스의 위치홀더에 String 값을 설정합니다.
    - setInt(int parameterIndex, int x): 지정된 인덱스의 위치홀더에 int 값을 설정합니다.
    - executeQuery(): SQL 문을 실행하고, 그 결과를 ResultSet 객체에 저장합니다.

- java.sql.ResultSet
    - next(): 결과의 다음 행으로 이동하고, 다음 행이 있는 경우 true를 반환합니다.
    - getString(String columnName): 지정된 열의 String 값을 반환합니다.
    - getInt(String columnName): 지정된 열의 int 값을 반환합니다.
    - getDate(String columnName): 지정된 열의 Date 값을 반환합니다.
    - close(): ResultSet 객체를 닫고, 이와 관련된 모든 리소스를 해제합니다.
 */

// http://localhost:8080/context-root/main 경로와 JdbcServlet 클래스를 매핑
@WebServlet("/main")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// GET 요청을 처리하기 위한 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 응답 컨텐츠 타입을 text/html과 UTF-8로 설정 (한글깨짐 방지)
		response.setContentType("text/html;charset=UTF-8");
		Connection conn = null; // DB 연결 객체
		Statement stmt = null; // SQL 수행 객체
		PreparedStatement pstmt = null; // SQL 수행 객체
		ResultSet rs = null; // 조회 결과 객체

		// action 파라미터를 통해 요청을 구분하여 처리
		String action = request.getParameter("action");

		try {
			
			/*
			 * 
			 * JDBC 드라이버 로딩 (MySQL 기준) java.lang.ClassNotFoundException:
			 * com.mysql.cj.jdbc.Driver 오류가 발생하면 maven update project 를 수행하여
			 * mysql-connector-j 의존성을 다운로드 받아야 합니다.
			 * 
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB 연결 정보 설정
			String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
			String id = "ssafy";
			String pw = "ssafy";

			// DB 연결
			conn = DriverManager.getConnection(url, id, pw);

			// SQL 수행 객체 생성
			stmt = conn.createStatement();

			if ("selectAll".equals(action)) {
				
				/*
				 * 
				 * 테이블을 조회하여 제대로 연결되었는지 확인 java.sql.SQLSyntaxErrorException: Table
				 * 'ssafydb.ssafy_student' doesn't exist 오류가 발생하면 SSAFY_DB.sql 파일을 이용하여 
				 * ssafydb 데이터베이스와 ssafy_student 테이블을 생성해야 합니다.
				 * 
				 */
				String sql = "select * from ssafy_student";
				
				
				// Q. SQL 문을 즉시 실행하고 결과를 반환하는 메서드를 호출해 봅시다.
				rs = stmt.executeQuery(sql);

				// 조회 결과를 리스트에 담아 포워드 (전달)
				List<Student> students = new ArrayList<Student>(); // 조회 결과를 담을 리스트

				// Q. ResultSet 객체의 결과의 다음 행으로 이동하고, 다음 행이 있는 경우 true를 반환하는 메서드를 호출해 봅시다. (다음 행이 없으면 false)
				while (rs.next()) {
					students.add(new Student(
							// Q. ResultSet 객체에서 정수 타입의 컬럼의 값을 가져오는 메서드를 호출해 봅시다.
							rs.getInt("id"),
							// Q. ResultSet 객체에서 문자열 타입의 컬럼의 값을 가져오는 메서드를 호출해 봅시다.
							rs.getString("name"),
							rs.getString("phone")));
				}
				

				// 조회 결과를 list.jsp로 전달
				request.setAttribute("students", students);
				request.getRequestDispatcher("list.jsp").forward(request, response);
				
			} else if ("selectOne".equals(action)) {
				// 단일 학생 조회
				// SQL 쿼리를 미리 준비합니다. '?'는 위치홀더로, 나중에 실제 값으로 대체됩니다.
				String sql = "select * from ssafy_student where id = ?";
				
				// Q. 미리 준비된 SQL 쿼리를 실행할 PreparedStatement 객체를 생성하는 메서드를 호출해 봅시다.
				pstmt = conn.prepareStatement(sql);

				int studentId = Integer.parseInt(request.getParameter("id"));

				pstmt.setInt(1, studentId); // 첫 번째 위치홀더에 studentId 값을 대체
				rs = pstmt.executeQuery(); // SQL 수행 결과를 rs에 저장

				Student student = null;
				// Q. ResultSet 객체의 결과의 다음 행으로 이동하고, 다음 행이 있는 경우 true를 반환하는 메서드를 호출해 봅시다. (다음 행이 없으면 false)
				if (rs.next()) {
					student = new Student(
							// Q. ResultSet 객체에서 정수 타입의 컬럼의 값을 가져오는 메서드를 호출해 봅시다.
							rs.getInt("id"), 
							// Q. ResultSet 객체에서 문자열 타입의 컬럼의 값을 가져오는 메서드를 호출해 봅시다.
							rs.getString("name"), 
							rs.getString("phone"),
							// Q. ResultSet 객체에서 날짜 타입의 컬럼의 값을 가져오는 메서드를 호출해 봅시다.
							rs.getDate("created_at"), 
							rs.getDate("updated_at"));
				}

				// 조회 결과를 result.jsp로 전달
				request.setAttribute("student", student);
				request.getRequestDispatcher("result.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 생성의 역순으로 객체를 닫음
			if (rs != null)
				try {
					// 조회 결과 객체 닫기
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					// SQL 수행 객체 닫기
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					// DB 연결 객체 닫기
					conn.close();
				} catch (SQLException e) {
				}
		}
	}
}
