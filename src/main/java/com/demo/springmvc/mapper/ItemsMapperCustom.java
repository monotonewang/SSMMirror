package com.demo.springmvc.mapper;

import com.demo.springmvc.po.ItemCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 7 on 2017/2/10.
 */
@Repository
public interface ItemsMapperCustom  {
	// 商品查询列表
	List<ItemCustom> findItemsList()
			throws Exception;

	ItemCustom selectByPrimaryKey(int id) throws  Exception;

	void updateByPrimaryKeyWithBLOBs(Integer id, ItemCustom itemCustom);
}
