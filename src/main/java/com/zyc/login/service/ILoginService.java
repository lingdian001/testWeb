package com.zyc.login.service;

import com.zyc.user.model.User;

public interface ILoginService {
	public User login(String loginId,String passward);
}
