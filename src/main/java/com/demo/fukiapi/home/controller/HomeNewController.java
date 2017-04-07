package com.demo.fukiapi.home.controller;

import com.demo.fukiapi.home.po.HomeNew;
import com.demo.fukiapi.home.po.HomeNewExample;
import com.demo.fukiapi.home.service.HomeNewService;
import com.demo.springmvc.po.ItemCustom;
import com.demo.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by dell on 2017/4/7.
 */
@Controller
@RequestMapping("/home")
public class HomeNewController {

    @Autowired
    private HomeNewService homeNewService;

    /**
     * 查看所有的商品列表
     *
     * @return 模型和视图
     * @throws Exception
     */
    @RequestMapping(value = "/queryNew", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<HomeNew> queryNew() throws Exception {

//		//调用service查询商品列表
        List<HomeNew> itemsList = homeNewService.selectByExample(new HomeNewExample());


        return itemsList;
    }

}
