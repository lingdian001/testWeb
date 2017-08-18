package com.zyc.business.user.dao;


import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.dao.IBaseDao;
import com.zyc.sys.base.model.CurrentPage;

public interface IUserDao extends IBaseDao<UserPo, UserVo>{
	public void save(UserVo user);  
	public boolean update(UserVo user);  
	public boolean delete(String loginId);  
	public UserVo findById(String loginId);  
	public CurrentPage<UserPo,UserVo> getUsersByPage(CurrentPage<UserPo,UserVo> pageObj); 
}
