package com.zyc.shoping.sys.service;

import com.zyc.shoping.user.model.User;

public interface ISysService {
	public User login(String loginId,String passward);
}
