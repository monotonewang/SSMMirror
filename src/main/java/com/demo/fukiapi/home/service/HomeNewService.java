package com.demo.fukiapi.home.service;

import com.demo.fukiapi.home.po.HomeNew;
import com.demo.fukiapi.home.po.HomeNewExample;

import java.util.List;

/**
 * Created by dell on 2017/4/7.
 */

public interface HomeNewService {

    List<HomeNew> selectByExample(HomeNewExample example);
}
