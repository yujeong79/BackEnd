package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Campus;
import com.ssafy.ws.step3.dto.Curriculum;
import com.ssafy.ws.step3.dto.Student;
import com.ssafy.ws.step3.util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	DBUtil util = DBUtil.getInstance();
	
	private static StudentDao dao = new StudentDaoImpl();
	private StudentDaoImpl() {}
	
	public static StudentDao getInstance() {
		return dao;
	}

	public Student selectOne(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = new Student();
		try {
			conn = util.getConnection();
			String sql = "SELECT * FROM ssafy_student "
					+ "LEFT JOIN ssafy_campus "
					+ "ON ssafy_student.campus = ssafy_campus.id "
					+ "LEFT JOIN ssafy_curriculum "
					+ "ON ssafy_student.curriculum = ssafy_curriculum.id "
					+ "WHERE ssafy_student.id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				Campus campus = new Campus();
				campus.setId(rs.getInt("campus"));
				campus.setLoc(rs.getString("loc"));
				campus.setClassNumber(rs.getInt("class"));
				student.setCampus(campus);
				Curriculum curriculum = new Curriculum();
				curriculum.setId(rs.getInt("curriculum"));
				curriculum.setName(rs.getString("ssafy_curriculum.name"));
				student.setCurriculum(curriculum);
				student.setBirthDate(rs.getString("birth_date"));
				student.setMajor(rs.getString("major"));
				student.setInSsafy(rs.getInt("in_ssafy"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB 연결을 해제합니다.
			util.close(conn, pstmt, rs);
		}
		return student;
	}

	@Override
	public List<Student> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<>();
		try {
			// DB에 연결하고, 학생 목록을 조회합니다.
			conn = util.getConnection();
			String sql = "SELECT * FROM ssafy_student"
					+ " LEFT JOIN ssafy_campus "
					+ " ON ssafy_student.campus = ssafy_campus.id "
					+ " LEFT JOIN ssafy_curriculum "
					+ " ON ssafy_student.curriculum = ssafy_curriculum.id;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setBirthDate(rs.getString("birth_date"));
				student.setMajor(rs.getString("major"));
				student.setInSsafy(rs.getInt("in_ssafy"));
				
				Campus campus = new Campus();
				campus.setId(rs.getInt("campus"));
				campus.setLoc(rs.getString("loc"));
				campus.setClassNumber(rs.getInt("class"));
				student.setCampus(campus);
				
				Curriculum curriculum = new Curriculum();
				curriculum.setId(rs.getInt("curriculum"));
				curriculum.setName(rs.getString("ssafy_curriculum.name"));
				student.setCurriculum(curriculum);
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB 연결을 해제합니다.
			util.close(conn, pstmt, rs);
		}
		return students;
	}

	@Override
	public void update(String id, String name, String gender, int campus, int curriculum, String birth_date,
			String major, int in_ssafy) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = util.getConnection();
			String sql = "UPDATE ssafy_student SET name = ?, gender = ?, campus = ?, curriculum = ?, birth_date = ?, major = ?, in_ssafy = ? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setInt(3, campus);
			pstmt.setInt(4, curriculum);
			pstmt.setString(5, birth_date);
			pstmt.setString(6, major);
			pstmt.setInt(7, in_ssafy);
			pstmt.setString(8, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// DB에 연결하고, 학생 정보를 삭제합니다.
			conn = util.getConnection();
			String sql = "DELETE FROM ssafy_student WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB 연결을 해제합니다.
			util.close(conn, pstmt);
		}
	}

	@Override
	public void insert(String id, String name, String gender, int campus, int curriculum, String birth_date,
			String major, int in_ssafy) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// DB에 연결하고, 학생 정보를 등록합니다.
			conn = util.getConnection();
			String sql = "INSERT INTO ssafy_student (id, name, gender, campus, curriculum, birth_date, major, in_ssafy) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setInt(4, campus);
			pstmt.setInt(5, curriculum);
			pstmt.setString(6, birth_date);
			pstmt.setString(7, major);
			pstmt.setInt(8, in_ssafy);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB 연결을 해제합니다.
			util.close(conn, pstmt);
		}
	}

}
