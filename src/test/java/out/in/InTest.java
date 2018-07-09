package out.in;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entity.IdList;
import com.entity.Items;
import com.entity.ItemsParam;
import com.mapper.ItemsMapper;

public class InTest {
	private static SqlSessionFactory ssf;
	private SqlSession op;
	private ItemsMapper mapper;
	private Items items;
	

	
		@BeforeClass
		public static void find() {
			try {
				ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Test
		public void selectMore() {
			op = ssf.openSession();
			mapper = op.getMapper(ItemsMapper.class);
			ItemsParam param=new ItemsParam();
			param.setBeginId(1);
			param.setOverId(3);
			List<Items> items=mapper.selectMore(param);
			for(Items i:items){
				System.out.println(i);
			}
		}
		
		
		
		@Test
		public void countTest() {
			op = ssf.openSession();
			mapper = op.getMapper(ItemsMapper.class);
			System.out.println(mapper.count());
		}
		
		

		@Test
		public void selectAll2Test() {
			op = ssf.openSession();
			mapper = op.getMapper(ItemsMapper.class);
			System.out.println(mapper.selectAll2().size());
		}
		@Test
		public void selectDSQLTest() {
			op = ssf.openSession();
			mapper = op.getMapper(ItemsMapper.class);
			ItemsParam param =new ItemsParam();
			param.setBeginId(1);
			param.setOverId(3);
			param.setName("");
			System.out.println(mapper.selectDSQL(param ));
		}
		@Test
		public void selectIdList() {
			op = ssf.openSession();
			mapper = op.getMapper(ItemsMapper.class);
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			IdList i=new IdList();
			i.setList(list);
			System.out.println(mapper.selectIdList(i));
		}
		
	
	
}
