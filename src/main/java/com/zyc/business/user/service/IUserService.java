package com.zyc.business.user.service;

import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.model.CurrentPage;

public interface IUserService {
	public UserVo getUserById(String loginId);
	
	/**
	  * @Description: 分页查询用户信息
	  * @param @param currentPage
	  * @param @return
	 */
	public CurrentPage<UserPo,UserVo> getUsers(CurrentPage<UserPo,UserVo> currentPage);

}
