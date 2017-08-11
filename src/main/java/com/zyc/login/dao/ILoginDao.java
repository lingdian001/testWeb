package com.zyc.login.dao;

import java.util.Map;

import com.zyc.user.model.User;

public interface ILoginDao {
	/**
	 * 根据login_id 查询用户信息
	 * @param param
	 * @return
	 */
	public User findByLoginId(Map<String,String> param);

}
