package com.example.demo.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fanya on 2017/12/23.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "test.config", ignoreInvalidFields = true)
public class EnvConfigProperties {
    private String version;
    private List<String> uriIgnore;
}
