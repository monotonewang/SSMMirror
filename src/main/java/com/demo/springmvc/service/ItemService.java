package com.demo.springmvc.service;

import com.demo.springmvc.po.ItemCustom;

import java.util.List;

/**
 * Created by 7 on 2017/2/9.
 */
public interface ItemService {

	//商品查询列表
	List<ItemCustom> findItemsList() throws Exception;

	//根据商品id查询商品信息
	ItemCustom findItemsById(int id) throws Exception;

	//更新商品信息
	/**
	 * 定义service接口，遵循单一职责，将业务参数细化（不要使用包装类型，比如map）
	 *
	 * @param id         修改商品的id
	 * @param itemCustom 修改商品的信息
	 * @throws Exception
	 */
	void updateByPrimaryKeyWithBLOBs(Integer id, ItemCustom itemCustom) throws Exception;


}
