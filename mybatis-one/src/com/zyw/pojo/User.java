package com.zyw.pojo;

public class User {
	private int userid;
	private String user_name;
	private String user_password;
	private String user_phone;
	private String user_age;
	private String user_home;
	private Tright tright;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getUser_home() {
		return user_home;
	}
	public void setUser_home(String user_home) {
		this.user_home = user_home;
	}
	public Tright getTright() {
		return tright;
	}
	public void setTright(Tright tright) {
		this.tright = tright;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_phone=" + user_phone + ", user_age=" + user_age + ", user_home=" + user_home + ", tright="
				+ tright + "]";
	}	
	
	
	
}
