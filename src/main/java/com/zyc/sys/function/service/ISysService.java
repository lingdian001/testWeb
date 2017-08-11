package com.zyc.sys.function.service;

import com.zyc.user.model.User;

public interface ISysService {
	public User login(String loginId,String passward);
}
