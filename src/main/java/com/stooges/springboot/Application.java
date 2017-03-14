package com.stooges.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 最佳实践
 *  将包含main方法的类加上@EnableAutoConfiguration放在所有包的顶层就不需要指定basePackage属性
 *  @ComponentScan注解放在rootPackage 下的包含main方法的类上
 *
 *  @SpringBootApplication = @Configuration+ @EnableAutoConfiguration + @ComponentScan
 * @author 张超
 * @date 2017/2/28.
 */
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
//        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
