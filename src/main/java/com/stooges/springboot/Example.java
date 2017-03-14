package com.stooges.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 最佳实践
 *  将包含main方法的类加上@EnableAutoConfiguration放在所有包的顶层就不需要指定basePackage属性
 *  @ComponentScan注解放在rootPackage 下的包含main方法的类上
 *
 *  @SpringBootApplication = @Configuration+ @EnableAutoConfiguration + @ComponentScan
 * @author 张超
 * @date 2017/2/28.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
public class Example {
    @RequestMapping("/")
    public String hello(){
        return "hello world";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Example.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
