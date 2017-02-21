package com.demo.springmvc.service.impl;

import com.demo.springmvc.mapper.UserMapper;
import com.demo.springmvc.mapper.UserMapperCustom;
import com.demo.springmvc.po.User;
import com.demo.springmvc.po.UserExample;
import com.demo.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/2/21.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Autowired
    private UserMapper userMapper;

    public List<User> selectByExample(UserExample example) {
//         List<User> users = userMapperCustom.selectByExample(example);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }
}
