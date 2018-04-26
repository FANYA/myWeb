package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.property.EnvConfigProperties;
import com.example.demo.dao.entity.User;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fanya on 2018/4/20.
 */
@Service
@Slf4j
@SuppressWarnings("SpringJavaAutowiringInspection")
public class UserServiceImpl  implements UserService{
    @Autowired
    EnvConfigProperties envConfigProperties;

    @Autowired
    UserMapper userMapper;

    @Override
    public String returnVersion() {
        User user =userMapper.selectByPrimaryKey("%","root");
        log.info(JSONObject.toJSONString(user));
        return JSONObject.toJSONString(user);
    }
    /*public String  returnResult(){
        User user =userMapper.selectByPrimaryKey("%","root");
        log.info(JSONObject.toJSONString(user));
        return JSONObject.toJSONString(user);
    }*/
}
