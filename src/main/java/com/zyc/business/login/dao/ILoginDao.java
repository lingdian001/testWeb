package com.zyc.business.login.dao;

import java.util.Map;

import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.dao.IBaseDao;

public interface ILoginDao extends IBaseDao<UserPo, UserVo>{
	/**
	 * 根据login_id 查询用户信息
	 * @param param
	 * @return
	 */
	public UserPo findByLoginId(Map<String,String> param);

}
