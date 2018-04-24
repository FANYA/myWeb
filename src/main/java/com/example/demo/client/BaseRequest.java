package com.example.demo.client;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by fanya on 2018/4/19.
 */
public class BaseRequest {
    private JSONObject paramJson;
    private String bodyString;

    public JSONObject getParamJson() {
        return paramJson;
    }

    public void setParamJson(JSONObject paramJson) {
        this.paramJson = paramJson;
    }

    public String getBodyString() {
        return bodyString;
    }

    public void setBodyString(String bodyString) {
        this.bodyString = bodyString;
    }
}
