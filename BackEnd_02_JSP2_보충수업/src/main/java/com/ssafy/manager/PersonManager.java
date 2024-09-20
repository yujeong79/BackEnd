package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

//아직 DB를 배우지 않아서... 메모리에 저장하도록 매니저를 두겠다.
//매니저는 여러명 있어서는 X list가 꼬일 수 있어!
public class PersonManager {
	private List<Person> list = new ArrayList<>();
	
	private static PersonManager manager = new PersonManager();
	
	//싱글턴 처리
	private PersonManager() {
	}
	
	public static PersonManager getInstance() {
		return manager;
	}
	
	
	//등록
	public void regist(Person p) {
		list.add(p);
	}
	
	//목록조회
	public List<Person> getList(){
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
