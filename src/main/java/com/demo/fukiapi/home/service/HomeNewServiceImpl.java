package com.demo.fukiapi.home.service;

import com.demo.fukiapi.home.mapper.HomeNewMapper;
import com.demo.fukiapi.home.po.HomeNew;
import com.demo.fukiapi.home.po.HomeNewExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2017/4/7.
 */
@Service("homeNewService")
public class HomeNewServiceImpl implements HomeNewService {

    @Autowired
    private HomeNewMapper homeNewMapper;

    @Override
    public List<HomeNew> selectByExample(HomeNewExample example) {
        List<HomeNew> homeNews = homeNewMapper.selectByExample(example);
        return homeNews;
    }

}
