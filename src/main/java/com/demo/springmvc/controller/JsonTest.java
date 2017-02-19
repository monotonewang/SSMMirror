package com.demo.springmvc.controller;

import com.demo.springmvc.po.ItemCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by WangTest on 2017/2/19.
 */
@Controller
public class JsonTest {

    //请求json相应json
    @RequestMapping("/requestJson")
    public  @ResponseBody ItemCustom requestJson(@RequestBody ItemCustom itemCustom){


        return itemCustom;
    }


    //请求key/value。响应json
    @RequestMapping("/responseJson")
    public @ResponseBody ItemCustom responseJson(ItemCustom itemCustom){

        return itemCustom;
    }
}
