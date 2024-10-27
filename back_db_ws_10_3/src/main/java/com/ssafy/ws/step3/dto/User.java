package com.ssafy.ws.step3.dto;

public class User {
	String id;
	String name;
	String pass;
	String rec_id;
	
	public User() {}
	
	public User(String id, String name, String pass, String rec_id) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.rec_id = rec_id;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRec_id() {
		return rec_id;
	}

	public void setRec_id(String rec_id) {
		this.rec_id = rec_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", rec_id=" + rec_id + "]";
	}
	
}
