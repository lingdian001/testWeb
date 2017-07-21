package com.zyc.shoping.login.dao;

import java.util.Map;

import com.zyc.shoping.user.model.User;

public interface ILoginDao {
	/**
	 * 根据login_id 查询用户信息
	 * @param param
	 * @return
	 */
	public User findByLoginId(Map<String,String> param);

}
