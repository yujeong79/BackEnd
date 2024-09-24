package com.ssafy.ws.step1;

// Member 클래스는 회원 정보를 담는 DTO 클래스
// DTO(Data Transfer Object)는 데이터를 전송하는 객체를 의미
// DTO는 데이터를 객체로 만들어 다른 계층(특정 기능을 수행하는 단위)으로 전달하는 역할 수행
public class Member {
    private String name;
    private int age;
	    
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public String hello() {
		return "안녕하세요! 저는 " + name + "입니다.";
	}
}