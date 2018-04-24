package com.example.demo.client.annotation;

import com.example.demo.client.check.CommonChecker;

import java.lang.annotation.*;

/**
 * Created by fanya on 2018/4/24.
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    Class<? extends CommonChecker>[] checkerClass();
}
