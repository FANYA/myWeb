package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.entity.User;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		userService.returnVersion();
		User user =userMapper.selectByPrimaryKey("%","root");
		log.info(JSONObject.toJSONString(user));
	}

}
