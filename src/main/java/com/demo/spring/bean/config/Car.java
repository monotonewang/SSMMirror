package com.demo.spring.bean.config;

/**
 * Created by 7 on 2017/1/13.
 */
public class Car {
	private String name;
	private Double price;

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
