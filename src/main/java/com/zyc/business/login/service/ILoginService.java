package com.zyc.business.login.service;

import com.zyc.business.user.model.UserPo;

public interface ILoginService {
	public UserPo login(String loginId,String passward);
}
