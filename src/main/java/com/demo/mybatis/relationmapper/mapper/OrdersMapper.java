package com.demo.mybatis.relationmapper.mapper;

import com.demo.mybatis.relationmapper.po.OrderCustom;
import com.demo.mybatis.relationmapper.po.Orders;
import com.demo.mybatis.relationmapper.po.OrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
	int countByExample(OrdersExample example);

	int deleteByExample(OrdersExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Orders record);

	int insertSelective(Orders record);

	List<Orders> selectByExample(OrdersExample example);

	Orders selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

	int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

	//自定义一对一映射
	List<OrderCustom> findOrderUser();

	List<Orders> findResultMapOrder();

	List<Orders> findOrderDetailNumber(String number);

	List<Orders> findOrderMore();

}