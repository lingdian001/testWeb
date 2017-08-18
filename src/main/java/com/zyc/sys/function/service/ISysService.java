package com.zyc.sys.function.service;

import com.zyc.business.user.model.UserVo;

public interface ISysService {
	public UserVo login(String loginId,String passward);
}
