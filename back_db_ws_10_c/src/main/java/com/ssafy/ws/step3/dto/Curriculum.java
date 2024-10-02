package com.ssafy.ws.step3.dto;

// 커리큘럼 DTO 클래스
//DTO(Data Transfer Object) : 데이터를 객체로 전달하는 객체
public class Curriculum {
	private int id;
	private String name;

	public Curriculum() {
	}

	public Curriculum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
