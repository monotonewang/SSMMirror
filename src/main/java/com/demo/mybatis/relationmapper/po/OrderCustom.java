package com.demo.mybatis.relationmapper.po;

/**
 * 订单扩展对象
 * Created by 7 on 2017/2/6.
 */
public class OrderCustom extends Orders {

	//补充用户信息
	private String username;
	private String sex;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "OrderCustom{" +
				", username='" + username + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
