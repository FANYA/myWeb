package com.example.demo.client.util;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.client.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by fanya on 2018/4/19.
 */
public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static BaseRequest getBaseRequest(HttpServletRequest request) {
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setParamJson(HttpUtils.getParamJson(request));
        baseRequest.setBodyString(HttpUtils.getBodyString(request));
        return baseRequest;
    }

    private static String getBodyString(HttpServletRequest request) {
        try {
            ServletInputStream is = request.getInputStream();
            ByteArrayOutputStream e = new ByteArrayOutputStream(128);
            byte[] bytes = new byte[128];

            int len;
            while((len = is.read(bytes)) != -1) {
                e.write(bytes, 0, len);
            }

            return e.toString("UTF-8");
        } catch (IOException var5) {
            log.error("ERROR when getting body content", var5);
            return null;
        }
    }

    private static JSONObject getParamJson(HttpServletRequest request) {
        JSONObject paramJson=new JSONObject();
        Enumeration paramKeys = request.getParameterNames();
        while (paramKeys.hasMoreElements()){
            String paramNames=(String)paramKeys.nextElement();
            paramJson.put(paramNames,request.getParameter(paramNames));
        }
        return paramJson;
    }

    public static String getToken(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("TOKEN");
    }
}
