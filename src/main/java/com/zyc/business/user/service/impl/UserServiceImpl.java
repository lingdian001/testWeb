package com.zyc.business.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.business.user.dao.IUserDao;
import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.business.user.service.IUserService;
import com.zyc.sys.base.model.CurrentPage;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	/**
	  * @Description: 根据登录id查询用户信息
	  * @param @param loginId
	  * @param @return
	 */
	@Override
	public UserVo getUserById(String loginId) {
		return userDao.findById(loginId);
	}
	
	
	/**
	  * @Description: 分页查询用户信息
	  * @param @param currentPage
	  * @param @return
	 */
	public CurrentPage<UserPo,UserVo> getUsers(CurrentPage<UserPo,UserVo> currentPage){
		return userDao.getUsersByPage(currentPage);
	}

}
