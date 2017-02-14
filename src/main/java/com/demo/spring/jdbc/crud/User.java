package com.demo.spring.jdbc.crud;

import java.io.Serializable;

/**
 * Created by 7 on 2017/1/16.
 */
class User implements Serializable {
	private Integer id;
	private String name;

	User() {
	}

	User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
