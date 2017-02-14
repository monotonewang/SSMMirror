package com.demo.mybatis.dao;

import com.demo.mybatis.mapper.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by 7 on 2017/1/18.
 */
public class UserDaoImpl implements UserDao {

	private SqlSession sqlSession;

	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Integer selectCount() {
		return sqlSession.selectOne("userDao.selectCount");
	}

	public User queryUserById(int id) {
		return sqlSession.selectOne("userDao.queryUserById",id);
	}

	public List<User> findAllUser() {
		return sqlSession.selectList("userDaos.findAllUser");
	}

	public int addUser(User user) {
		return sqlSession.insert("userDao.addUser", user);
	}

	public int updateUser(User user) {
		return sqlSession.update("userDao.updateUser", user);
	}

	public int deleteUserById(int id) {
		return sqlSession.delete("userDao.deleteUserById", id);
	}
}
