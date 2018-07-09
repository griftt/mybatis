package mybatis1;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.UserDao;
import com.entity.User;

public class selectone {
	private static SqlSessionFactory ssf;

	@BeforeClass
	public static void find() {
		ssf = new SqlSessionFactoryBuilder().build(selectone.class.getResourceAsStream("/SqlMapConfig.xml"));

	}

	@Test
	public void testSelectByName() {
		UserDao u = new UserDao(ssf);
		List<User> list = u.selectByNamne("小明");
		System.out.println(list.size());
	}

	@Test
	public void testInsert() {
		UserDao dao = new UserDao(ssf);
		User user = new User();
		user.setBirthday(Date.valueOf("1990-10-10"));
		user.setAddress("cami");
		user.setSex(2);
		user.setUsername("tom");
		int a = dao.insert(user);
		
		User user2=dao.selectById(a);
		System.out.println(a+"a");
		System.out.println(user2);
		
	}

}
