package com.zyc.sys.function.dao;

import java.util.Map;

import com.zyc.business.user.model.UserVo;

public interface ISysDao {
	/**
	 * 根据login_id 查询用户信息
	 * @param param
	 * @return
	 */
	public UserVo findByLoginId(Map<String,String> param);

}
