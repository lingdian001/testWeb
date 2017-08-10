package com.zyc.shoping.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.shoping.user.dao.IUserDao;
import com.zyc.shoping.user.model.User;
import com.zyc.shoping.user.service.IUserService;

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
	public User getUserById(String loginId) {
		return userDao.findById(loginId);
	}

}
