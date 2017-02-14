package com.demo.springmvc.service.impl;

import com.demo.springmvc.mapper.ItemsMapper;
import com.demo.springmvc.mapper.ItemsMapperCustom;
import com.demo.springmvc.po.ItemCustom;
import com.demo.springmvc.po.Items;
import com.demo.springmvc.service.ItemService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 7 on 2017/2/10.
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	private ApplicationContext applicationContext;

	public List<ItemCustom> findItemsList() throws Exception {
		// 创建spring容器
//		applicationContext = new ClassPathXmlApplicationContext("springmvc/applicationContext-Dao.xml");
//		itemsMapperCustom = (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
		List<ItemCustom> itemsList = itemsMapperCustom.findItemsList();
//		System.out.println("xxx"+itemsList);
		return itemsList;
	}

	/**
	 * 根据id查找相应的pojo
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ItemCustom findItemsById(int id) throws Exception {
		return  itemsMapperCustom.selectByPrimaryKey(id);
	}

	/**
	 * 更新商品信息
	 * @param id         修改商品的id
	 * @param itemCustom 修改商品的信息
	 * @throws Exception
	 */
	public void updateByPrimaryKeyWithBLOBs(Integer id, ItemCustom itemCustom) throws Exception {
		//写业务代码

		Items items=new Items();
		//拷贝属性
		BeanUtils.copyProperties(items,itemCustom);


		System.out.println("service"+items);

		//对于关键业务数据的非空校验
		if(id == null){
			//抛出异常，提示调用接口的用户，id不能为空
			//...
		}
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}

	/**
	 * 测试数据
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {
				/*List<Items> itemsList=new ArrayList<Items>();
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		Items items_3 = new Items();
		items_3.setName("苹果手机");
		items_3.setPrice(5000f);
		items_3.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		itemsList.add(items_3);*/
	}
}
