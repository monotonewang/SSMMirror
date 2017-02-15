package com.demo.springmvc.controller;

import com.demo.springmvc.po.ItemCustom;
import com.demo.springmvc.po.Items;
import com.demo.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2017/2/9.
 */
@Controller
@RequestMapping("/item")
public class GoodController {

	//这两句代码的意思是获取itemService bean 同理与@Autowired
//	ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("springmvc/applicationContext-Service.xml");
//	itemService = (ItemService) applicationContext.getBean("itemService");
	//下面是通过注解获取bean
	@Autowired
	private ItemService itemService;

	/**
	 * 查看所有的商品列表
	 *
	 * @return 模型和视图
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryItem", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView queryItem() throws Exception {

//		//调用service查询商品列表
		List<ItemCustom> itemList = itemService.findItemsList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemList);
//		System.out.println("xxx"+itemList);
		// 指定逻辑视图名
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}

	/**
	 * Controller返回值-为String/修改单个sql
	 *
	 * @param model 模型
	 * @return jsp地址
	 * @throws Exception
	 */
	@RequestMapping(value = "/editItem", method = {RequestMethod.GET})
	public String editItems(Model model, HttpServletRequest request) throws Exception {
		//获取商品id;
		String id = request.getParameter("id");
		Integer integer = Integer.valueOf(id);
		ItemCustom itemList = itemService.findItemsById(integer);
		model.addAttribute("item", itemList);
		return "editItem";
	}

	//商品修改提交
	//itemsQueryVo是包装类型的pojo
//	public String editItemSubmit(Integer id,ItemsCustom itemsCustom,
//			ItemsQueryVo itemsQueryVo)throws Exception{
	@RequestMapping(value = "/editItemSubmit",method = {RequestMethod.POST})
	public String editItemSubmit(HttpServletRequest request,Integer id, ItemCustom itemCustom) throws Exception {

		//调用service更新商品信息
		itemService.updateByPrimaryKeyWithBLOBs(id, itemCustom);
		//重定向。
//		return "redirect:queryItem.action";

		//转发
		return "forward:queryItem.action";
	}

	/**
	 * Controller返回值-返回值为空
	 * @param request
	 * @param response
	 * @throws Exception
	 */
/*	@RequestMapping(value = "/editItem",method = RequestMethod.GET)
	public void editItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemCustom itemList=itemService.findItemsById(1);
		request.setAttribute("item",itemList);
		//使用request转发页面，需要些完整路径
		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request,response);
	}*/

	/**
	 * spring mvc入门案例。自行封装数据
	 *
	 * @return 模型和视图
	 */
	@RequestMapping("/queryItems1")
	public ModelAndView queryItems1() {
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

		Items items_3 = new Items();
		items_3.setName("苹果手机");
		items_3.setPrice(5000f);
		items_3.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		itemsList.add(items_3);

		ModelAndView modelAndView = new ModelAndView();
		//将数据填充到request
//		request.setAttribute("itemsList", itemsList);
		modelAndView.addObject("itemsList", itemsList);
		//指定转发的jsp页面
		modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
		return modelAndView;
	}

//	这种方式无法实现多个Controller共用
	//自定义属性编辑器
//	@InitBinder
//	public void initBinder(WebDataBinder binder) throws Exception {
//		// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
//	}

}
