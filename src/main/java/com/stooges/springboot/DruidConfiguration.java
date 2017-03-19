package com.stooges.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
/**
 * @author 张超
 * @date 2017/3/15.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:datasource.properties")
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfiguration {
//    @Value("${spring.datasource.url}")
    private String url;
    private String username;
    private String password;
//    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean
    @Primary
    public DataSource dataSource(){
        System.out.println(driverClassName+"测试 ");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName.trim());
        dataSource.setUrl(url.trim());
        dataSource.setUsername(username.trim());
        dataSource.setPassword(password.trim());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
