package com.demo.spring.aop;

/**
 * Created by 7 on 2017/1/13.
 */
public class CustomerDaoImpl implements CustomerDao {

	public void add() {
		System.out.println("添加用户...");
	}


	public void delete() {
		System.out.println("删除用户...");
	}


	public void update() {
		System.out.println("更新用户...");
	}


	public void select() {
		System.out.println("查找用户...");
	}
}
