package com.demo.springmvc.controller;

import com.demo.springmvc.po.User;
import com.demo.springmvc.po.UserExample;
import com.demo.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by dell on 2017/2/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/queryUser")
    public String queryUser(Model model) {
        List<User> usersList = userService.selectByExample(new UserExample());
        System.out.println(usersList);
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i).getBirthday().toString());
        }
        model.addAttribute("usersList", usersList);
        return "/user/usersList";
//        return "/user/testDate";
    }


    @RequestMapping("/queryUserJSON")
    @ResponseBody
    public List<User> queryUserJSON() {
        List<User> usersList = userService.selectByExample(new UserExample());
        System.out.println(usersList);
        return usersList;
    }
}
