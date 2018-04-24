package com.example.demo.client.check;

import com.example.demo.client.util.HttpUtils;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fanya on 2018/4/24.
 */
@Log4j
public class TokenChecker implements   CommonChecker {
    @Override
    public boolean doCheck(HttpServletRequest httpServletRequest) {
        String token= HttpUtils.getToken(httpServletRequest);
        if(StringUtils.isNotBlank(token)){
            log.info("success");
            return true;
        }else{
            return false;
        }
    }
}
