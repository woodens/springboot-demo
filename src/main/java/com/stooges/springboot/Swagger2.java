package com.stooges.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建api文档
 * @author 张超
 * @date 2017/3/14.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * 创建restapi
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//该api基本信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stooges.springboot"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多项目请关注：https://github.com/woodens")
                .termsOfServiceUrl("http://git.oschina.net/gowork")
                .contact(new Contact("zhangchao","https://github.com/woodens","tombsky@163.com"))
                .version("1.0")
                .build();
    }
}
