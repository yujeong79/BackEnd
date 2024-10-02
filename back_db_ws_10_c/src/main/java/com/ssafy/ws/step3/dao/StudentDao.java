package com.ssafy.ws.step3.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step3.dto.Student;

//학생 DAO 인터페이스
//DAO(Data Access Object) : 데이터베이스에 접근하여 데이터를 조회, 수정, 삭제, 추가하는 역할을 하는 객체
public interface StudentDao {

	// 학생 정보를 조회하는 메소드
	Student selectOne(String id) throws SQLException;

	// 학생 정보를 모두 조회하는 메소드
	List<Student> selectAll() throws SQLException;

	// 학생 정보를 수정하는 메소드
	void update(String id, String name, String gender, int campus, int curriculum, String birth_date, String major,
			int in_ssafy) throws SQLException;

	// 학생 정보를 삭제하는 메소드
	void delete(String id) throws SQLException;

	// 학생 정보를 추가하는 메소드
	void insert(String id, String name, String gender, int campus, int curriculum, String birth_date, String major,
			int in_ssafy) throws SQLException;

}
