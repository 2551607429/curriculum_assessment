package com.dsa.as.service.impl;

import com.dsa.as.dao.UserMapper;
import com.dsa.as.model.User;
import com.dsa.as.service.UserService;
import com.dsa.common.utils.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> findAll(Map<String, Object> param_map) {
        Page page = (Page) param_map.get("page");
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<User> userList = userMapper.findAll();
        //PageInfo<User> info = new PageInfo<>(userList);

        Integer countNums = userMapper.countAll();
        Page<User> data = new Page<>(page.getCurrentPage(),page.getPageSize(),countNums);

        Map<String, Object> map = new HashMap<>();
        map.put("page",data);
        map.put("list",userList);
        return map;
    }
}
