package com.ssafy.minsseam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.minsseam.model.dto.Minkyu;
import com.ssafy.minsseam.util.DBUtil;

public class MinkyuDaoImpl implements MinkyuDao {
	public DBUtil util;
	
	// 싱글턴 ////////////////////////////////////////////////////////////////////////////
	// 느슨한 결합을 위해 인터페이스로 받기
	private static MinkyuDao instance = new MinkyuDaoImpl();
	private MinkyuDaoImpl() {
		util = DBUtil.getInstance();
	}
	
	public static MinkyuDao getInstance() { // 객체 생성 없이 접근 하기 위해서 static
		return instance;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void InsertMinkyu(Minkyu minkyu) {
		String sql = "INSERT INTO minkyu (name, email) VALUES (?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, minkyu.getName());
			pstmt.setString(2, minkyu.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public List<Minkyu> selectAll() {
		List<Minkyu> list = new ArrayList<>();
		
		String sql = "SELECT * \n"
					+ "FROM minkyu";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Minkyu minkyu = new Minkyu();
				
				minkyu.setUserid(rs.getInt("user_id"));
				minkyu.setName(rs.getString("name"));
				minkyu.setEmail(rs.getString("email"));
				
				list.add(minkyu);
				System.out.println(minkyu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public Minkyu selectOne(int id) {
		Minkyu minkyu = null;
		String sql =  "SELECT * \n"
					+ "FROM minkyu \n"
					+ "WHERE user_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				minkyu = new Minkyu();
				minkyu.setUserid(rs.getInt("user_id"));
				minkyu.setName(rs.getString("name"));
				minkyu.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return minkyu;
	}

	@Override
	public void updateMinkyu(Minkyu minkyu) {
		String sql =  "UPDATE minkyu \n"
					+ "SET name = ? \n"
					+ "email = ? \n"
					+ "WHERE user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, minkyu.getName());
			pstmt.setString(2, minkyu.getEmail());
			pstmt.setInt(3, minkyu.getUserid());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void deleteMinkyu(int id) {
		String sql =  "DELETE FROM minkyu \n"
					+ "WHERE user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}
}
