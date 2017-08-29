package com.zyc.business.user.dao;


import java.util.List;

import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.dao.IBaseDao;
import com.zyc.sys.base.model.CurrentPage;

public interface IUserDao extends IBaseDao<UserPo, UserVo>{
	public UserPo save(UserPo userPo);  
	public int update(UserPo userPo);  
	public boolean delete(List<UserPo> userPoList);  
	public UserPo findById(String loginId);  
	public CurrentPage<UserPo,UserVo> getUsersByPage(CurrentPage<UserPo,UserVo> pageObj); 
}
