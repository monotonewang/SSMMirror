package com.demo.spring.bean.xmlorAnno;

import javax.annotation.Resource;

/**
 * Created by 7 on 2017/1/13.
 */
public class CustomerService {
	@Resource
	private CustomerDao customerDao;

	@Override
	public String toString() {
		return "CustomerService{" +
				"customerDao=" + customerDao +
				'}';
	}
}
