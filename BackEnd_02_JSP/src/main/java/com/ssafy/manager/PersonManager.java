package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

// 아직 DB를 배우지 않았으니까 메모리에 저장해보자
public class PersonManager {
	private List<Person> list = new ArrayList<>();
	
	private static PersonManager manager = new PersonManager();
	
	// 싱글턴 처리
	private PersonManager() {} // 기본생성자를 private으로
	
	public static PersonManager getInstance() { // 바깥에서 PersonManager 객체에 접근할 수 있도록
		return manager;
	}
	
	// 등록
	public void regist(Person p) {
		list.add(p);
	}
	
	// 목록 조회
	public List<Person> getList() {
		return list;
	}
}
