package com.zyc.business.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.zyc.business.user.dao.IUserDao;
import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.dao.impl.BaseDaoImpl;
import com.zyc.sys.base.model.CurrentPage;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserPo,UserVo> implements IUserDao{

	@Override
	public void save(UserVo user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(UserVo user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String loginId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVo findById(String loginId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	  * @Description:分页查询用户
	  * @param @param pageObj
	  * @param @return
	 */
	@Override
	public CurrentPage<UserPo,UserVo> getUsersByPage(CurrentPage<UserPo,UserVo> pageObj) {
		return queryForPage("getUsersCount", "getUsersByPage",pageObj,null);
	}

	

}
