package com.example.demo.client.check;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fanya on 2018/4/24.
 */
public  interface CommonChecker {
    boolean doCheck(HttpServletRequest httpServletRequest);
}
