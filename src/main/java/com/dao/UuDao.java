package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.entity.User;

public class UuDao {
 private SqlSessionFactory factory;
 	
 public UuDao(SqlSessionFactory factory){
	 this.factory=factory;
 }
	
	public String insert(Uu uu) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession();
		session.insert("test2.insert",uu);
		session.commit();
		
		return  uu.getId();
	}
	

}
