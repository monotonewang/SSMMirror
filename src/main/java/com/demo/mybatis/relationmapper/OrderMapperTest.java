package com.demo.mybatis.relationmapper;

import com.demo.mybatis.dao.UserDao;
import com.demo.mybatis.mapper.mapper.UserMapper;
import com.demo.mybatis.relationmapper.mapper.OrdersMapper;
import com.demo.mybatis.relationmapper.po.OrderCustom;
import com.demo.mybatis.relationmapper.po.Orderdetail;
import com.demo.mybatis.relationmapper.po.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 7 on 2017/2/6.
 */
public class OrderMapperTest {
	private SqlSession sqlSession;
	private UserMapper mapper;
	private UserDao userDao;

	@Before
	public void setUp() throws IOException {
		//配置全局的mybatis-config.xml
		String resource = "mybatis-config.xml";
		//获取输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		sqlSession = sqlSessionFactory.openSession();
	}

	//一对一查询，查询订单信息关联查询用户信息
	//主表：订单查询表
	//关联查询表：用户表 --通过resultType完成手动映射
	//	select orders.*,user.username,`user`.sex from orders,user where orders.user_id=user.id
	@Test
	public void findOrderUser() {
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrderCustom> orderUser = mapper.findOrderUser();
		for (OrderCustom orderCustom : orderUser) {
			System.out.println(orderCustom.getCreatetime());
			System.out.println(orderCustom.getNumber());
		}
	}

	@Test
	public void findResultMapOrder(){
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> resultMapOrder = mapper.findResultMapOrder();
		for (Orders orderCustom : resultMapOrder) {
			System.out.println(orderCustom.getCreatetime());
			System.out.println(orderCustom.getNumber());
		}
	}

	//Tip:mybatis会自动去重
	//一对多查询，根据订单号查询出来下单人信息，并查询出来订单详细
//	select * from orders left join orderdetail  on orders.id=orderdetail.orders_id LEFT JOIN user on user.id=orders.user_id where number='1000010'
	@Test
	public void findOrderDetailNumber(){
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> orderDetailNumber = mapper.findOrderDetailNumber("1000010");
		System.out.println("count="+orderDetailNumber.size());
		for (Orders orderCustom : orderDetailNumber) {
			System.out.println(orderCustom);
			List<Orderdetail> orderdetails = orderCustom.getOrderdetails();
			System.out.println("size="+orderdetails.size()+"detail="+orderdetails);
		}
	}

	//一对多查询
	//查询用户的信息并查询订单详情中的商品数据
//	select * from orders,orderdetail,user,items where orders.user_id=user.id and  orders.id=orderdetail.orders_id and orderdetail.items_id=items.id
	@Test
	public void findOrderMore(){
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> orderMore = mapper.findOrderMore();
		for (Orders orderCustom : orderMore) {
			System.out.println(orderMore.size());
			System.out.println(orderCustom);
		}
	}


}
