package com.zyc.sys.function.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyc.business.login.dao.ILoginDao;
import com.zyc.business.user.model.UserPo;

@Service("sysService")
public class SysServiceImpl {
	@Autowired
	private ILoginDao loginDao;
	
	/**
	  * @Description: 根据用户名和密码登录
	  * @param @param loginId
	  * @param @param passward
	  * @param @return    
	 */
	public UserPo login(String loginId,String passward) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("loginId", loginId);
		param.put("passward", passward);
		return loginDao.findByLoginId(param);
	}

}
