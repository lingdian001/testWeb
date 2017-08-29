package com.zyc.business.user.model;

import com.zyc.sys.base.model.BasePO;


public class UserPo extends BasePO {
	private String loginId;
	private String password;
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
