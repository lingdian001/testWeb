package com.zyc.shoping.user.dao;

import java.util.List;

import com.zyc.shoping.user.model.User;

public interface IUserDao {
	public void save(User user);  
	public boolean update(User user);  
	public boolean delete(int id);  
	public User findById(int id);  
	public List<User> findAll(); 
}
