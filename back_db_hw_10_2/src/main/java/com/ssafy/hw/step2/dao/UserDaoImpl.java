 package com.ssafy.hw.step2.dao;

 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Connection;
 import java.util.ArrayList;
 import java.util.List;

// import com.ssafy.backend.dao.____; => 이게 멍미?
 import com.ssafy.hw.step2.dto.User;
 import com.ssafy.hw.step2.util.DBUtil;

 public class UserDaoImpl implements UserDao{
	
 	private final DBUtil util = DBUtil.getInstance();
	
 	private static UserDaoImpl instance = new UserDaoImpl();
	
 	private UserDaoImpl() {}
	
 	public static UserDaoImpl getInstance() {
 		return instance;
 	}
	
 	//DB에 저장된 모든 User정보 가져오기
 	public List<User> selectAllUsers() throws SQLException {
 		//사용할 sql문
 		String sql = "SELECT * FROM users";
 		//모든 User정보를 저장할 list
 		ArrayList<User> result = new ArrayList<User>();
 		//DB 연결 객체
 		Connection conn = null;
 		//sql문 실행 객체
 		PreparedStatement pstmt = null;
 		//sql문 실행 결과 집합
 		ResultSet rs = null;
		
 		try {
 			// 연결 객체 얻기
 			conn = util.getConnection();
 			// 위에서 사용할 sql문을 통해 pstmt 구문 객체 생성
 			pstmt = conn.prepareStatement(sql);
 			// sql 실행 ( 처리할 결과가 있는 경우 )
 			rs = pstmt.executeQuery();
			
 			// sql 실행 결과 처리
 			while (rs.next()) {
 				User user = new User();
 				user.setId(rs.getString("id"));
 				user.setPassword(rs.getString("password"));
 				user.setName(rs.getString("name"));
 				user.setAge(rs.getInt("age"));
 				user.setEmail(rs.getString("email"));
 				result.add(user);
 			}
			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} finally {
 			//자원 해제
 			util.close(conn, pstmt, rs);
 		}
		
 		// list 반환
 		return result;
		
 	}

 	//DB에 User 정보 삽입
 	public boolean insertUser(User user) throws SQLException {
 		String sql = "INSERT INTO users (id, password, name, email, age) VALUES(?,?,?,?,?)";

 		Connection conn = null;
 		PreparedStatement pstmt = null;
 		boolean result = false;

 		try {
 			conn = util.getConnection();
 			pstmt = conn.prepareStatement(sql);
 			pstmt.setString(1, user.getId());
 			pstmt.setString(2, user.getPassword());
 			pstmt.setString(3, user.getName());
 			pstmt.setString(4, user.getEmail());
 			pstmt.setInt(5, user.getAge());
 			// sql 실행 결과 영향받은 행 수가 0 이상인 경우 정상 실행
 			result = pstmt.executeUpdate() > 0 ? true : false;

			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		} finally {
 			util.close(conn, pstmt);
 		}
		
 		return result;
 	}
	
 	//DB에 등록된 User정보 갯수
 	public int userCount() throws SQLException {
 		String sql = "SELECT COUNT(*) FROM users";

 		Connection conn = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;

 		int result = 0;

 		try {
 			conn = util.getConnection();
 			pstmt = conn.prepareStatement(sql);
 			rs = pstmt.executeQuery();

 			if (rs.next()) {
 				result = rs.getInt(1);
 			}

			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		} finally {
 			util.close(conn, pstmt, rs);
 		}
		
 		return result;
 	}
	
	
 }