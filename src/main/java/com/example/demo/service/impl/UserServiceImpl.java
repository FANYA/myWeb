package com.example.demo.service.impl;

import com.example.demo.config.property.EnvConfigProperties;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fanya on 2018/4/20.
 */
@Service
@Transactional
public class UserServiceImpl  implements UserService{
    @Autowired
    EnvConfigProperties envConfigProperties;

    @Override
    public String returnVersion() {

        return envConfigProperties.getVersion();
    }
}
