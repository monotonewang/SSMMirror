package com.demo.springmvc.controller;

import com.demo.springmvc.po.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2017/2/8.
 */
public class ItemController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

		// 使用静态数据将商品信息列表显示在jsp页面
		// 商品列表
		List<Items> itemsList = new ArrayList<Items>();

		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);


		ModelAndView modelAndView = new ModelAndView();
		//将数据填充到request
//		request.setAttribute("itemsList", itemsList);
		modelAndView.addObject("itemsList", itemsList);
		//指定转发的jsp页面
		modelAndView.setViewName("/jsp/springmvc/itemList.jsp");
		return modelAndView;
	}
}
