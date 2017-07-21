package com.zyc.shoping.user.model;

public class User {
	private String loginId;
	private String passward;
	private String userName;
	private String sex;
	private String age;
	private String telphone;
	private String email;

	public String getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassward() {
		return passward;
	}

	public String getSex() {
		return sex;
	}

	public String getTelphone() {
		return telphone;
	}

	public String getUserName() {
		return userName;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
