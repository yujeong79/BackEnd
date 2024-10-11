package com.ssafy.minsseam.model.dto;

// [이 파일은 수정금지] 오류없음
public class Minkyu {
	private int userid;
	private String name;
	private String email;

	public Minkyu() {
	}

	public Minkyu(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public Minkyu(int userid, String name, String email) {
		this.userid = userid;
		this.name = name;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Minkyu [userid=" + userid + ", name=" + name + ", email=" + email + "]";
	}
}