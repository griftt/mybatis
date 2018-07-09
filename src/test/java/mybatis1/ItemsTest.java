package mybatis1;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entity.Items;
import com.mapper.ItemsMapper;

public class ItemsTest {
	private static SqlSessionFactory ssf;
	private SqlSession op;
	private ItemsMapper mapper;
	private Items items;

	@BeforeClass
	public static void find() {
		ssf = new SqlSessionFactoryBuilder().build(selectone.class.getResourceAsStream("/SqlMapConfig.xml"));

	}

	@Test
	public void selectAlltest() {
		op = ssf.openSession();
		mapper = op.getMapper(ItemsMapper.class);
		List<Items> items=mapper.selectAll();
		System.out.println(items.size());
		
	}
	
	
	@Test
	public void insertTest(){
		op = ssf.openSession();
		mapper = op.getMapper(ItemsMapper.class);
		items = new Items();
		items.setName("hello");
		items.setDetail("more");
		items.setPrice(100.1);
		items.setCreateTime(Date.valueOf("2019-10-10"));
		mapper.insertOne(items);
		op.commit();
		op.close();
	}
	@Test
	public void updateTest(){
		op = ssf.openSession();
		mapper = op.getMapper(ItemsMapper.class);
		items = new Items();
		items.setId(4);
		items.setName("hello");
		items.setDetail("more");
		items.setPrice(200.1);
		items.setCreateTime(Date.valueOf("2019-10-10"));
		mapper.update(items);
		op.commit();
		op.close();
	}
	@Test
	public void deleteTest(){
		op = ssf.openSession();
		mapper = op.getMapper(ItemsMapper.class);
		
		mapper.deleteById(4);;
		op.commit();
		op.close();
	}

}
