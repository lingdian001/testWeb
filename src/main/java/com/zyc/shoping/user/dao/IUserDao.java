package com.zyc.shoping.user.dao;

import java.util.List;

import com.zyc.shoping.user.model.User;

public interface IUserDao {
	public void save(User user);  
	public boolean update(User user);  
	public boolean delete(String loginId);  
	public User findById(String loginId);  
	public List<User> findAll(); 
}
