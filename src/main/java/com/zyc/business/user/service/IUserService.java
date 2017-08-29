package com.zyc.business.user.service;

import java.util.List;

import com.zyc.business.user.model.UserPo;
import com.zyc.business.user.model.UserVo;
import com.zyc.sys.base.model.CurrentPage;

public interface IUserService {
	/**
	  * @Description: 根据登录账号查询用户
	  * @param @param loginId
	  * @param @return
	 */
	public UserPo getUserById(String loginId);
	
	/**
	  * @Description: 分页查询用户信息
	  * @param @param currentPage
	  * @param @return
	 */
	public CurrentPage<UserPo,UserVo> getUsers(CurrentPage<UserPo,UserVo> currentPage);
	
	/**
	  * @Description: 保存用户信息
	  * @param @param userPo
	  * @param @return
	 */
	public boolean saveUser(UserPo userPo);
	
	/**
	  * @Description: 更新用户信息
	  * @param @param userPo
	  * @param @return
	 */
	public boolean updateUser(UserPo userPo);
	
	/**
	  * @Description: 更新用户信息
	  * @param @param userPoList
	  * @param @return
	 */
	public boolean deleteUser(List<UserPo> userPoList);
	
	

}
