package com.demo.mybatis.mapper.pojo;

import java.util.List;

/**
 * Created by 7 on 2017/2/3.
 */
public class UserQueryVo {
	private User user;
	private UserCustom userCustom;
	private List<Integer> ids;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
