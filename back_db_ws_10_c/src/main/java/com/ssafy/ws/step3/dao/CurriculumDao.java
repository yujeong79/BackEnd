package com.ssafy.ws.step3.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step3.dto.Curriculum;

//커리큘럼 DAO 인터페이스
//DAO(Data Access Object) : 데이터베이스에 접근하여 데이터를 조회, 수정, 삭제, 추가하는 역할을 하는 객체
public interface CurriculumDao {
	List<Curriculum> selectAll() throws SQLException;

	Curriculum selectOne(int id) throws SQLException;
}
