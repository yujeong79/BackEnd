package com.ssafy.ws.step3.dto;

//학생 DTO 클래스
//DTO(Data Transfer Object) : 데이터를 객체로 전달하는 객체
public class Student {
	private String id;
	private String name;
	private String gender;
	private String birthDate;
	private String major;
	private int inSsafy;

	private Campus campus;
	private Curriculum curriculum;

	public Student() {

	}

	public Student(String id, String name, String gender, Campus campus, Curriculum curriculum, String birthDate,
			String major, int inSsafy) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.campus = campus;
		this.curriculum = curriculum;
		this.birthDate = birthDate;
		this.major = major;
		this.inSsafy = inSsafy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getInSsafy() {
		return inSsafy;
	}

	public void setInSsafy(int inSsafy) {
		this.inSsafy = inSsafy;
	}

}
