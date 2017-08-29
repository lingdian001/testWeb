package com.zyc.business.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zyc.business.user.dao.IUserDao;
import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.dao.impl.BaseDaoImpl;
import com.zyc.sys.base.model.CurrentPage;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserPo,UserVo> implements IUserDao{

	@Override
	public UserPo save(UserPo userPo) {
		return this.createObject("save", userPo);
	}

	@Override
	public int update(UserPo userPo) {
		return this.updateObjectReturnInt("update", userPo);
	}

	@Override
	public boolean delete(List<UserPo> userPoList) {
		return this.batchDelete("delete", userPoList);
	}

	@Override
	public UserPo findById(String loginId) {
		return this.queryById("selectById", loginId);
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
