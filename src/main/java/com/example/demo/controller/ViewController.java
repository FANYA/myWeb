package com.example.demo.controller;

import com.example.demo.client.BaseRequest;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fanya on 2018/4/23.
 */
@Log4j
@RequestMapping(value = {"/view"})
@Controller
public class ViewController {

    @RequestMapping(value = {"/page"}, method = {RequestMethod.POST,RequestMethod.GET})
    public String viewPage(@ApiIgnore @RequestAttribute BaseRequest baseRequest,ModelMap map){
        map.addAttribute("time",new SimpleDateFormat("yyyy-mm-dd hh:MM:ss").format(new Date()));
        return "index";
    }
}
