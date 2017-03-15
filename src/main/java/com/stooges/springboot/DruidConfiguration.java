package com.stooges.springboot;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author 张超
 * @date 2017/3/15.
 */
//@Configuration
public class DruidConfiguration {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

}
