package com.demo.spring.aop;

/**
 * Created by wang on 17-1-15.
 */
//目标对象
public class OrderDao {
	public void add() {
		System.out.println("add用户");
	}

	public void delete() {
		System.out.println("delete用户");
	}

	public void update() {
		System.out.println("update用户");
	}

	public void select() {
		System.out.println("select用户");
	}
}
