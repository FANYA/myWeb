package com.example.demo.config.property;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * Created by fanya on 2017/12/23.
 */

@Configuration
@Validated
@Data
@ConfigurationProperties(prefix = "project.swagger", ignoreInvalidFields = true)
public class SwaggerProperties {
    @NotBlank
    private String basePackage;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String termsOfServiceUrl;
    @NotBlank
    private String version;
    @NotBlank
    private String contactName;
    @NotBlank
    private String contactUrl;
    @NotBlank
    private String contactEmail;
}

