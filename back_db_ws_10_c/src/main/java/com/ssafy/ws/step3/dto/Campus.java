package com.ssafy.ws.step3.dto;

// 캠퍼스 DTO 클래스
// DTO(Data Transfer Object) : 데이터를 객체로 전달하는 객체
public class Campus {
	private int id;
	private String loc;
	private int classNumber;

	public Campus() {
	}

	public Campus(int id, String loc, int classNumber) {
		this.id = id;
		this.loc = loc;
		this.classNumber = classNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

}
