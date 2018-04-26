package com.example.demo.controller;

import com.example.demo.client.BaseRequest;
import com.example.demo.client.annotation.Check;
import com.example.demo.client.check.TokenChecker;
import com.example.demo.config.property.EnvConfigProperties;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by fanya on 2017/12/23.
 */
@RestController
@RequestMapping(value = {"/test"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Log4j
public class TestControll {

    @Autowired
    EnvConfigProperties envConfigProperties;

    @Autowired
    UserService userService;

    @Check(checkerClass =TokenChecker.class)
    @RequestMapping(value = {"/getVersion"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "data", value = "{\n" +
                    "  \"data\": {\n" +
                    "    \"companyName\": \"新新贷(上海)金融信息有限公司\",\n" +
                    "    \"buslicenseno\": \"5454561151321321321\",\n" +
                    "  }\n" +
                    "}", required = true, dataType = "string")})
    @ApiOperation(value = "测试获得版本号", notes = "测试获得版本号")
    public String testGetVersion(@ApiIgnore @RequestAttribute BaseRequest baseRequest) {
        log.info("getVersion");
        String result = userService.returnVersion();

        return result;
    }

}
