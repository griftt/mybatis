package com.hello;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entity.User;

public class HelloMybatis {

	private static SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream input=HelloMybatis.class.getResourceAsStream("/SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession session=sqlSessionFactory.openSession();
		User user=session.selectOne("test.selectById", 1);
		System.out.println(user);	
		session.close();
	}
	

}
