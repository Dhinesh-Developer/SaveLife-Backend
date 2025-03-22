package com.saveLife.Model;

public class User {
	
	private int uId;
	private String name;
	private String email;
	private String passwd;
	
	private String role;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(int uId, String name, String email, String passwd,  String role) {
		super();
		this.uId = uId;
		this.name = name;
		this.email = email;
		this.passwd = passwd;

		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", name=" + name + ", email=" + email + ", passwd=" + passwd 
				+ ", role=" + role + "]";
	}
	public User(String name, String email, String passwd, String role) {
		super();
		this.name = name;
		this.email = email;
		this.passwd = passwd;
	
		this.role = role;
	}
	
	public User() {
	}

}
