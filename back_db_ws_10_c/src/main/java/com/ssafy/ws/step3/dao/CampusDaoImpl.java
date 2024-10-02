package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Campus;
import com.ssafy.ws.step3.util.DBUtil;

public class CampusDaoImpl implements CampusDao {

	private DBUtil util = DBUtil.getInstance();

	@Override
	public List<Campus> selectAll() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Campus> campuses = new ArrayList<>();

		try {
			conn = util.getConnection();
			String sql = "SELECT * FROM ssafy_campus";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Campus campus = new Campus();
				campus.setId(rs.getInt("id"));
				campus.setLoc(rs.getString("loc"));
				campus.setClassNumber(rs.getInt("class"));
				campuses.add(campus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, rs);
		}
		return campuses;
	}

	@Override
	public Campus selectOne(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Campus campus = new Campus();
		try {
			conn = util.getConnection();
			String sql = "SELECT * FROM ssafy_campus WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				campus.setId(rs.getInt("id"));
				campus.setLoc(rs.getString("loc"));
				campus.setClassNumber(rs.getInt("class"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}
		return campus;
	}

}
