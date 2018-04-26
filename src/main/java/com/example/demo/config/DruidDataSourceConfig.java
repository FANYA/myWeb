package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.example.demo.config.property.DruidConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by yq on 2017/3/26.
 */
@Configuration
@ConditionalOnProperty(name = "spring.datasource.type",havingValue = "com.alibaba.druid.pool.DruidDataSource")
public class DruidDataSourceConfig {
    private transient final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DruidConfigProperties druidConfigProperties;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        //必填项
        datasource.setUrl(druidConfigProperties.getUrl());
        datasource.setUsername(druidConfigProperties.getUsername());
        datasource.setPassword(druidConfigProperties.getPassword());
        datasource.setDriverClassName(druidConfigProperties.getDriverClassName());
        datasource.setInitialSize(druidConfigProperties.getInitialSize());
        datasource.setMinIdle(druidConfigProperties.getMinIdle());
        datasource.setMaxActive(druidConfigProperties.getMaxActive());
        datasource.setMaxWait(druidConfigProperties.getMaxWait());
        datasource.setConnectionProperties(druidConfigProperties.getConnectionProperties());
        datasource.setDefaultAutoCommit(false);
        //非必填项
        if(druidConfigProperties.getTimeBetweenEvictionRunsMillis() != null){ datasource.setTimeBetweenEvictionRunsMillis(druidConfigProperties.getTimeBetweenEvictionRunsMillis());}
        if(druidConfigProperties.getMinEvictableIdleTimeMillis() != null){ datasource.setMinEvictableIdleTimeMillis(druidConfigProperties.getMinEvictableIdleTimeMillis());}
        if(druidConfigProperties.getValidationQuery() != null){ datasource.setValidationQuery(druidConfigProperties.getValidationQuery());}
        if(druidConfigProperties.getTestWhileIdle() != null){ datasource.setTestWhileIdle(druidConfigProperties.getTestWhileIdle());}
        if(druidConfigProperties.getTestOnBorrow() != null){ datasource.setTestOnBorrow(druidConfigProperties.getTestOnBorrow());}
        if(druidConfigProperties.getTestOnReturn() != null){ datasource.setTestOnReturn(druidConfigProperties.getTestOnReturn());}
        if(druidConfigProperties.getRemoveAbandoned() != null){ datasource.setRemoveAbandoned(druidConfigProperties.getRemoveAbandoned());}
        if(druidConfigProperties.getRemoveAbandonedTimeout() != null){  datasource.setRemoveAbandonedTimeout(druidConfigProperties.getRemoveAbandonedTimeout());}
        if(druidConfigProperties.getLogAbandoned() != null){ datasource.setLogAbandoned(druidConfigProperties.getLogAbandoned());}
        if(druidConfigProperties.getPoolPreparedStatements() != null){  datasource.setPoolPreparedStatements(druidConfigProperties.getPoolPreparedStatements());}
        if(druidConfigProperties.getMaxPoolPreparedStatementPerConnectionSize() != null){  datasource.setMaxPoolPreparedStatementPerConnectionSize(druidConfigProperties.getMaxPoolPreparedStatementPerConnectionSize());}
        if(druidConfigProperties.getUseGlobalDataSourceStat() != null){  datasource.setUseGlobalDataSourceStat(druidConfigProperties.getUseGlobalDataSourceStat());}
        if(druidConfigProperties.getFilters() != null){
            try {
                datasource.setFilters(druidConfigProperties.getFilters());
            } catch (SQLException e) {
                logger.error("druid configuration initialization filter", e);
            }
        }
        return datasource;
    }

    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druidMonitor/*");

        //添加初始化参数：initParams

        //白名单：
        if(druidConfigProperties.getMonitorAllow() != null) servletRegistrationBean.addInitParameter("allow",druidConfigProperties.getMonitorAllow());
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        if(druidConfigProperties.getMonitorDeny() != null) servletRegistrationBean.addInitParameter("deny",druidConfigProperties.getMonitorDeny());
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");

        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druidMonitor/*");
        return filterRegistrationBean;
    }

}
