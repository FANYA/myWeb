package com.example.demo.config.property;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;




@Configuration
@Validated
@Data @ConfigurationProperties(prefix = "spring.datasource")
@ConditionalOnProperty(name = "spring.datasource.type",havingValue = "com.alibaba.druid.pool.DruidDataSource")
public class DruidConfigProperties {
    @NotBlank
    private String type;
    @NotBlank
    private String driverClassName;
    @NotBlank
    private String name;
    @NotBlank
    private String url;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    //配置初始化大小、最小、最大
    @NotNull private Integer initialSize;
    @NotNull private Integer minIdle;
    @NotNull private Integer maxActive;
    //配置获取连接等待超时的时间
    @NotNull private Long maxWait;
    //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private Long timeBetweenEvictionRunsMillis;
    //配置一个连接在池中最小生存的时间，单位是毫秒
    private Long minEvictableIdleTimeMillis;
    private String validationQuery;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean removeAbandoned;
    private Integer removeAbandonedTimeout;
    private Boolean logAbandoned;
    //打开PSCache，并且指定每个连接上PSCache的大小
    private Boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    //配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    private String filters;
    //通过connectProperties属性来打开mergeSql功能；慢SQL记录
    @NotBlank
    private String connectionProperties;
    //合并多个DruidDataSource的监控数据
    private Boolean useGlobalDataSourceStat;
    //监控配置项
    private String monitorAllow;
    private String monitorDeny;

}
