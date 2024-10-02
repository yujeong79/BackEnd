package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Curriculum;
import com.ssafy.ws.step3.util.DBUtil;

public class CurriculumDaoImpl implements CurriculumDao {

	private DBUtil util = DBUtil.getInstance();

	@Override
	public List<Curriculum> selectAll() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Curriculum> curriculums = new ArrayList<>();

		try {
			conn = util.getConnection();
			String sql = "SELECT * FROM ssafy_curriculum";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Curriculum curriculum = new Curriculum();
				curriculum.setId(rs.getInt("id"));
				curriculum.setName(rs.getString("name"));
				curriculums.add(curriculum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, rs);
		}
		return curriculums;
	}

	@Override
	public Curriculum selectOne(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Curriculum curriculum = new Curriculum();
		try {
			conn = util.getConnection();
			String sql = "SELECT * FROM ssafy_curriculum WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				curriculum.setId(rs.getInt("id"));
				curriculum.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, rs);
		}
		return curriculum;
	}

}
