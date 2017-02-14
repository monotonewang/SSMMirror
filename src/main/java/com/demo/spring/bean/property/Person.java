package com.demo.spring.bean.property;

/**
 * Created by 7 on 2017/1/12.
 */
public class Person {
	private Car2 car2;
	private String name;

	public void setCar2(Car2 car2) {
		this.car2 = car2;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person{" +
				"car2=" + car2 +
				", name='" + name + '\'' +
				'}';
	}
}
