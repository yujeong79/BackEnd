package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	private DBUtil util = DBUtil.getInstance(); // 연결통로를 뚫어주는 클래스를 사용해서 편하게 뚫자!
	
	/////////////////////////////////////////////////////////////////////////////
	// 싱글턴으로 관리
	private static BoardDao dao = new BoardDaoImpl();
	
	private BoardDaoImpl() {}
	
	public static BoardDao getInstance() {
		return dao;
	}
	/////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Board> selectAll() {
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return list;
	
	}

	@Override
	public Board selectOne(int id) { // 게시글을 하나 가져오고시펑~
		Connection conn = null; // 이렇게 try문 밖으로 빼야 finally에서 close를 할 수 있음
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Board board = null;
		try {
			conn = util.getConnection();  // 드라이버에 연결 요청, DriveManager.getConnection()을 사용해서 접근했지만 우린 이미 util에 정의해놓음
//			Statement stmt = conn.createStatement();
//			String sql = "SELECT * FROM board WHERE id="+id; // selectOne의 parameter로 넘겨 받은 id의 게시글 가져오기
			
			String sql = "SELECT * FROM board WHERE id=?"; // preparedStatement 방식
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 몇번째 물음표부터 채울랭? 1번부터~ sql은 인덱스가 1부터 시작하니까~
			
			board = new Board();
			rs = pstmt.executeQuery(); // 여기서 sql문을 던져줄 필요가 없다, 이미 prepareStatement에서 sql문을 던져주었으니까
			while(rs.next()) {
				board.setId(rs.getInt(1)); // 이번엔 컬럼명 말고 인덱스로 가져와보장
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegDate(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 예외가 발생해도 무조건 close를 해줄 수 있도록!
			util.close(rs, pstmt, conn);
		}
		
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		// ResultSet은 필요없음 왜냐하면 데이터를 가져올 필요가 없으니까!!
		
		// 그런데 INSERT INTO 를 하기 위해서 여기에 SQL문을 다 쓰는 것이 생각보다 복잡하다...
		// 그래서 등장한 것이!!! PreparedStatement!!!
		String sql = "INSERT INTO board (title, writer, content) VALUES(?,?,?)";
		
		try {
			conn = util.getConnection(); // 연결 뚫기
			pstmt = conn.prepareStatement(sql); // 미리 셋팅
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			int result = pstmt.executeUpdate(); // int형을 반환, 지금 몇개를 건드렸는지가 반환 => 데이터를 몇 개 넣었는지
			
			//System.out.println(result); // 아~ 너가 데이터 1개를 넣었구나~ 이렇게 알 수 있음
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void deleteBoard(int id) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM board WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void updateBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE board SET title=?, writer=?, content=? WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(4, board.getId());
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			int result = pstmt.executeUpdate();
			System.out.println("변경된 행의 개수 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		
	}

	@Override
	public void updateViewCnt(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE board SET view_cnt=view_cnt+1 WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
			System.out.println("변경된 행의 개수 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		
	}

}
