package com.mapper;

import java.util.List;

import com.entity.IdList;
import com.entity.Items;
import com.entity.ItemsParam;
import com.entity.User;

public interface ItemsMapper {
	public List<Items> selectAll();
	public void deleteById(int id);
	public int insertOne(Items items );
	public void update(Items items);
	public List<Items> selectMore(ItemsParam param);
	public int count();
	public List<Items> selectAll2();
	public List<Items> selectDSQL(ItemsParam param);
	public List<Items> selectIdList(IdList param);
	
}
