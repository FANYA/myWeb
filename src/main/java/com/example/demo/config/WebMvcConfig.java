package com.example.demo.config;

import com.example.demo.client.interceptor.CommonInterceptor;
import com.example.demo.config.property.EnvConfigProperties;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fanya on 2018/4/19.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(WebMvcConfig.class);
    @Autowired
    private EnvConfigProperties projectProperties;

    public
    @Override
    void addInterceptors(InterceptorRegistry registry) {
        log.info("Mapping interceptor: 'CommonInterceptor' to [/**], exclude path patterns according to settings in yml");
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new CommonInterceptor());
        interceptorRegistration.addPathPatterns("/**").excludePathPatterns("/swagger-resources/**", "/v2/api-docs/**", "/swagger-ui.html", "/error", "/errorHtml");
        if (CollectionUtils.isNotEmpty(projectProperties.getUriIgnore())) {
            interceptorRegistration.excludePathPatterns(projectProperties.getUriIgnore().toArray(new String[]{}));
        }
    }
}
