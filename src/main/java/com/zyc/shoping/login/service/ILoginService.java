package com.zyc.shoping.login.service;

import com.zyc.shoping.user.model.User;

public interface ILoginService {
	public User login(String loginId,String passward);
}
