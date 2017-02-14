package com.demo.springmvc.mapper;

import com.demo.springmvc.po.ItemCustom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 7 on 2017/2/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:springmvc/applicationContext-Dao.xml")
public class ItemsMapperCustomTest {

	private ApplicationContext applicationContext;

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Before
	public void setUp() throws Exception {
		// 创建spring容器
// 		applicationContext = new ClassPathXmlApplicationContext("springmvc/applicationContext-Dao.xml");
	}
	@Test
	public void testFindUserById() throws Exception {
//		ItemsMapperCustom itemsMapperCustom = (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
		List<ItemCustom> itemsList = itemsMapperCustom.findItemsList();
		System.out.println(itemsList);
	}

}
