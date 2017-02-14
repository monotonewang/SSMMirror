package com.demo.mybatis.relationmapper.mapper;

import com.demo.mybatis.relationmapper.po.Orders;
import com.demo.mybatis.relationmapper.po.User;
import com.demo.mybatis.relationmapper.po.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> testLevelOneCache(int id);

    User testUpdateCache(int id);

    void updateUser(User user);

    User lazyLoading(String number);

    User lazyLoading1(String number);

    List<Orders> lazyLoadingTest2();

}