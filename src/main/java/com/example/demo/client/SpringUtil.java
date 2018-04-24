package com.example.demo.client;/*
package com.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

*/
/**
 * Created by fanya on 2017/6/26.
 *//*

@Configuration
public class SpringUtil implements ApplicationContextAware {
    private transient final static Logger LOGGER = LoggerFactory.getLogger(SpringUtil.class);
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null)
            SpringUtil.applicationContext = applicationContext;
    }
    */
/**
     * 获取applicationContext
     * @return
     *//*

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    */
/**
     * 通过name获取 Bean
     * @param name
     * @return
     *//*

    public static Object getBean(String name) {
        try {
            return getApplicationContext().getBean(name);
        }catch(BeansException e){
            LOGGER.warn("error occured when try get spring bean, beanName[{}],error msg[{}]",name,e.getMessage());
            return null;
        }
    }

    */
/**
     * 通过class获取Bean
     * @param clazz
     * @param <T>
     * @return
     *//*

    public static <T> T getBean(Class<T> clazz) {
        try {
            return getApplicationContext().getBean(clazz);
        }catch(BeansException e){
            LOGGER.warn("error occured when try get spring bean, beanClass[{}],error msg[{}]",clazz.getSimpleName(),e.getMessage());
            return null;
        }
    }

    */
/**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     *//*

    public static <T> T getBean(String name, Class<T> clazz) {
        try {
            return getApplicationContext().getBean(name,clazz);
        }catch(BeansException e){
            LOGGER.warn("error occured when try get spring bean, beanName[{}], beanClass[{}],error msg[{}]",name,clazz.getSimpleName(),e.getMessage());
            return null;
        }
    }
}
*/
