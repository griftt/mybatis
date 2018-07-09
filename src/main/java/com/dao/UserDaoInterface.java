package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDaoInterface {

	public User selectById(int id);
	public List<User> selectByNamne(String name);
	public int insert(User user);	
	
}
