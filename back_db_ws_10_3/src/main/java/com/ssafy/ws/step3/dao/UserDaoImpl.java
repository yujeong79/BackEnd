package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ssafy.ws.step3.dto.User;
import com.ssafy.ws.step3.util.DBUtil;

/**
 * UserDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
public class UserDaoImpl implements UserDao{
	
	private DBUtil util = DBUtil.getInstance();

	// 싱글턴 ///////////////////////////////////////////////////////////
	private UserDaoImpl() {}
	
	private static UserDao instance = new UserDaoImpl();
	
	public static UserDao getInstance() {
		return instance;
	}
	///////////////////////////////////////////////////////////////////
	
	@Override
	public boolean insert(User user) {
		String sql = "INSERT INTO `user` (`id`, `name`, `pass`) VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean success = false;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPass());
			
			success = pstmt.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
		System.out.println("회원가입 : " + success);
		return success;
	}

	@Override
	public User select(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
