package mybatis1;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.Uu;
import com.dao.UuDao;

public class UUIDtest {
	private static SqlSessionFactory ssf;

	@BeforeClass
	public static void find() {
		ssf = new SqlSessionFactoryBuilder().build(selectone.class.getResourceAsStream("/SqlMapConfig.xml"));

	}

	@Test
	public void test() {
		UuDao uudao=new UuDao(ssf);
		Uu uu=new  Uu();
		String a=uudao.insert(uu);
		System.out.println(a);
		
	}

}
