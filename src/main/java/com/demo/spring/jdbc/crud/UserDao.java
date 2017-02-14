package com.demo.spring.jdbc.crud;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 7 on 2017/1/16.
 */
public class UserDao extends JdbcDaoSupport {

	public void add(User user) {
		String sql = "INSERT INTO USERSpring VALUES (null,?)";
		this.getJdbcTemplate().update(sql, user.getName());
	}

	public int delete(int id) {
		String sql = "DELETE FROM USERSpring WHERE id=?";
		return this.getJdbcTemplate().update(sql, id);
	}

	public void update(User user) {
		String sql = "UPDATE USERSpring SET NAME=? where id=?";
		this.getJdbcTemplate().update(sql, user.getName(), user.getId());
	}

	int fingByCount() {
		String sql = "SELECT count(*) FROM USERSpring";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	/**
	 * 多条记录查询
	 *
	 * @return
	 */
	List<User> findByList() {
		String sql = "select * from USERSpring";
		List<User> query = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<User>(User.class));
//		return query;
//		return mapToList(sql);
		return this.getJdbcTemplate().query(sql, new UserRowMapper());
	}

	private List<User> mapToList(String sql) {
		List<Map<String, Object>> lists = this.getJdbcTemplate().queryForList(sql);
		List<User> userInfos = new ArrayList<User>();
		for (Map<String, Object> map : lists) {
			Integer id = (Integer) map.get("id");
			String name = (String) map.get("NAME");
			userInfos.add(new User(id, name));
		}
		return userInfos;
	}

	private class UserRowMapper implements RowMapper<User> {
		/**
		 * rs:结果集.
		 * rowNum:行号
		 */
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		}
	}

}
