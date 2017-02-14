package com.demo.mybatis.spring.mapper;


import com.demo.mybatis.spring.pojo.Items;
import com.demo.mybatis.spring.pojo.ItemsExample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2017/2/8.
 */
public class ItemsMapperTest {

	private ApplicationContext applicationContext;

	private ItemsMapper itemsMapper;
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建spring容器
		applicationContext = new ClassPathXmlApplicationContext("mybatis/spring/applicationContextMyBatis.xml");
		itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
	}

	@Test
	public void testCountByExample() throws Exception {

	}

	@Test
	public void testDeleteByExample() throws Exception {

	}

	@Test
	public void testDeleteByPrimaryKey() throws Exception {
		itemsMapper.deleteByPrimaryKey(4);
	}

	@Test
	public void testInsert() throws Exception {
		Items items = new Items();
		items.setName("洗衣机");
		items.setPrice(3000.0f);
		items.setCreatetime(new Date());
		itemsMapper.insert(items);

	}

	@Test
	public void testInsertSelective() throws Exception {

	}

	@Test
	public void testSelectByExampleWithBLOBs() throws Exception {

	}

	@Test
	public void testSelectByExample() throws Exception {
		ItemsExample itemsExample=new ItemsExample();
		ItemsExample.Criteria criteria=itemsExample.createCriteria();
		criteria.andNameEqualTo("笔记本");
		List<Items> itemses = itemsMapper.selectByExample(itemsExample);
		System.out.println(itemses);
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(1);
		System.out.println(items);

	}

	@Test
	public void testUpdateByExampleSelective() throws Exception {
		// 如果更新对象的属性不为空才更新到数据库
		// 常用于指定字段更新，不用先查询出，可以直接new一个对象，此对象一定要设置id主键，再设置更新字段的值
		Items items = new Items();
		items.setId(1);
		items.setName("笔记 本5");
		itemsMapper.updateByPrimaryKeySelective(items);
	}

	@Test
	public void testUpdateByExampleWithBLOBs() throws Exception {

	}

	@Test
	public void testUpdateByExample() throws Exception {

	}

	@Test
	public void testUpdateByPrimaryKeySelective() throws Exception {

	}

	@Test
	public void testUpdateByPrimaryKeyWithBLOBs() throws Exception {

	}

	@Test
	public void testUpdateByPrimaryKey() throws Exception {
		// 将更新对象的内容全部更新到数据库
		// updateByPrimaryKey通过是先查询再设置更新字段的值
		Items items = itemsMapper.selectByPrimaryKey(1);
		items.setName("笔记 本4");

		itemsMapper.updateByPrimaryKey(items);
		//自定义条件更新，example设置条件，record是更新对象
//		itemsMapper.updateByExample(record, example)
		//可以更新大文本字段
//		itemsMapper.updateByExampleWithBLOBs(record, example)
	}

}