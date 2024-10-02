package com.ssafy.ws.step2;

import java.sql.Date;

public class Student {
    private int id; // 학번
    private String name; // 이름
    private String phone; // 전화번호
    private Date created_at; // 생성일시
    private Date updated_at; // 수정일시
    
	public Student(int id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
    
	public Student(int id, String name, String phone, Date created_at, Date updated_at) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}
