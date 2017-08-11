package com.zyc.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.login.dao.ILoginDao;
import com.zyc.login.service.ILoginService;
import com.zyc.user.model.User;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private ILoginDao loginDao;
	
	/**
	  * @Description: 根据用户名和密码登录
	  * @param @param loginId
	  * @param @param passward
	  * @param @return    
	 */
	public User login(String loginId,String passward) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("loginId", loginId);
		param.put("passward", passward);
		return loginDao.findByLoginId(param);
	}

}
