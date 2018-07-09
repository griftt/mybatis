package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.entity.User;

public class UserDao implements UserDaoInterface {
 private SqlSessionFactory factory;
 	
 public UserDao(SqlSessionFactory factory){
	 this.factory=factory;
 }
	@Override
	public User selectById(int id) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession();
		User user=session.selectOne("selectById",id);
		session.close();
		return user;
	}
	@Override
	public List<User> selectByNamne(String name) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession();
		List<User> list=session.selectList("selectByName","%"+name+"%");
		return list;
	}
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession();
		int a=session.insert("in", user);
		session.commit();
		
		return  user.getId();
	}

}
