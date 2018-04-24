package com.example.demo.client.interceptor;


import com.example.demo.client.BaseRequest;
import com.example.demo.client.annotation.Check;
import com.example.demo.client.check.CommonChecker;
import com.example.demo.client.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanya on 2018/4/19.
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BaseRequest baseRequest= HttpUtils.getBaseRequest(request);
        request.setAttribute("baseRequest", baseRequest);
        try {
          boolean  result = doPreCheckers( request, (HandlerMethod) handler);
        }catch (Exception ex){
        }
        return true;
    }

    private boolean doPreCheckers(HttpServletRequest request, HandlerMethod handler) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<Class<?extends CommonChecker>> checkList=getCheckList(handler);
        return doCheck(checkList,request);
    }

    private boolean doCheck(List<Class<? extends CommonChecker>> checkList,HttpServletRequest request) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        for(Class<? extends  CommonChecker> check : checkList){
          check.getMethod("doCheck",HttpServletRequest.class).invoke(check.newInstance(),request);
        }
        return true;
    }

    private List<Class<? extends CommonChecker>> getCheckList(HandlerMethod handler) {
        List<Class<? extends CommonChecker>> checkList=new ArrayList<Class<? extends CommonChecker>>();
        Check checks=handler.getMethod().getAnnotation(Check.class);
        for(Class<? extends  CommonChecker> check : checks.checkerClass()){
            checkList.add(check);
        }
        return checkList;
    }

}
