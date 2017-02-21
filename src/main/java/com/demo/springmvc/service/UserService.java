package com.demo.springmvc.service;

        import com.demo.springmvc.po.User;
        import com.demo.springmvc.po.UserExample;

        import java.util.List;

/**
 * Created by dell on 2017/2/21.
 */
public interface UserService {
    List<User> selectByExample(UserExample example);
}
