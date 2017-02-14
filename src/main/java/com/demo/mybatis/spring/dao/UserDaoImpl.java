package com.demo.mybatis.spring.dao;

import com.demo.mybatis.spring.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by 7 on 2017/1/18.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    @Test
    public User findUserById(int id){
        SqlSession sqlSession = this.getSqlSession();
        User user = sqlSession.selectOne("userDaos.findUserById", id);
        return user;
    }
}