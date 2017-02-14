package com.demo.spring.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 7 on 2017/1/13.
 */
@Configuration
public class BeanConfig {

	@Bean(name="configcar")
	public Car showCar(){
		Car car=new Car();
		car.setName("baoma");
		car.setPrice(200.01);
		return car;
	}
}
