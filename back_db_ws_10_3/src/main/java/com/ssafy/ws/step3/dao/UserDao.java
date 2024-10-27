package com.ssafy.ws.step3.dao;

import com.ssafy.ws.step3.dto.User;

public interface UserDao {
	
	boolean insert(User user); // 회원가입 시 새로운 사용자 데이터를 DB에 추가하는 메서드
	
	User select(String id); // 사용자가 로그인 시도를 하는 경우 같은 아이디의 사용자를 반환하는 메서드
}
