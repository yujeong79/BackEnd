package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public class JdbcTest {
	
	public JdbcTest() { 
		// Class는 java.lang 안에 있는 객체인데 java.lang은 자동으로 import됨
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // "" 드라이버를 메모리 상에 올려 두겠다. 
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) { // 해당 이름을 가진 드라이버가 없을 수 있다는 에러가 뜰 수 있어서
			e.printStackTrace();
		} 
	}
	
	// JdbcTest 클래스에 내용을 사용하기 위해서..
	public static void main(String[] args) {
		JdbcTest db = new JdbcTest();
		
		for(Board b : db.selectAll()) {
			System.out.println(b);
		}
	}
	
	// 전체 게시글을 조회하기 위한 메소드를 만들어보자
	// 게시글에 대한 데이터는 MySQL에서 가져와보자!!
	private List<Board> selectAll() {
		List<Board> list = new ArrayList<>(); // 데이터베이스에서 가져온 각각의 데이터를 여기에 저장하자~
		
		// 이제 진짜 데이터베이스 연결도 하고 데이터도 가져오자
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "ssafy", "ssafy");
		
			Statement stmt = conn.createStatement(); // stmt 객체에 SQL문을 담아서 DBMS에 보내자!
			
			String sql = "SELECT * FROM board"; // 게시글을 전체 조회하는 SQL문
			ResultSet rs = stmt.executeQuery(sql); // sql문의 결과 테이블을 저장
			
			while(rs.next()) { // 초기 커서는 Begin of File를 가리킴, 하나씩 데이터를 받아와서 End of File이 되면 종료
				Board board = new Board(); // 빈 바구니를 하나 생성하자
				
				board.setId(rs.getInt("id")); // `id`라는 라벨(컬럼명)로 가져옴
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				
				list.add(board);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return list;
	}

}
