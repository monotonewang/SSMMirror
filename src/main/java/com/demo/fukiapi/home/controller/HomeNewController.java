package com.demo.fukiapi.home.controller;

import com.demo.fukiapi.home.po.HomeNew;
import com.demo.fukiapi.home.po.HomeNewCustom;
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
     * 查看最新的json
     *
     * @throws Exception
     */
    @RequestMapping(value = "/queryNew", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HomeNewCustom queryNew() throws Exception {

        List<HomeNew> itemsList = homeNewService.selectByExample(new HomeNewExample());
        HomeNewCustom homeNewCustom=new HomeNewCustom();
        homeNewCustom.setHomeNewList(itemsList);
        homeNewCustom.setResultCode("200");
        homeNewCustom.setReseaon("请求成功");
        return homeNewCustom;
    }

}
