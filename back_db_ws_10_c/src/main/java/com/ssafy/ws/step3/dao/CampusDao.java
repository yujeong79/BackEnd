package com.ssafy.ws.step3.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step3.dto.*;

// 캠퍼스 DAO 인터페이스
// DAO(Data Access Object) : 데이터베이스에 접근하여 데이터를 조회, 수정, 삭제, 추가하는 역할을 하는 객체
public interface CampusDao {

	List<Campus> selectAll() throws SQLException;

	Campus selectOne(int id) throws SQLException;
}
