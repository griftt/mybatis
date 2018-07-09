package mybatis1;

import java.io.InputStream;
import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.entity.User;

public class testId {

	@Test
	public void test() {
		InputStream s=this.getClass().getResourceAsStream("/SqlMapConfig.xml");
		
		SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(s);
		SqlSession session=sf.openSession();
		User u=new User();
		u.setAddress("广松");
		u.setBirthday(Date.valueOf("1990-10-10"));
		u.setSex(1);
		u.setUsername("hello");
		int id=session.insert("test.in",u);
		
		System.out.println(u.getId());
		session.commit();
		session.close();
		
	}

}
