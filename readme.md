### 开发步骤

-  `File->New ->Project...->Spring Initializr`使用Spring Initialzr创建springboot项目
- 项目最佳目录结构
	- Springboot-demo
		- src
			- main
				- java
					- com.company.myproject
						- Application.java
						- domain
							- `Customer.java`
							- `CustomerReposity.java`
						- service
							- `CustomerService.java`
						- web
							- `CustomerController.java`
				- resources
					- `application.properties`
			- `test`
		- pom.xml 
### 技术总结
- **`@ComponentScan`注解一般放在根目录下包含main方法的启动类上  用于扫描该包下的类文件**

- **`@SpringBootApplication = @Configuration+ @EnableAutoConfiguration + @ComponentScan`**

- **继承自 spring-boot-starter-parent 会有很多默认配置**
	1. 默认编译级别为Java 1.6
	2. 源码编码为UTF-8
	3. 一个Dependency management节点，允许你省略常见依赖的 <version> 标签，继承自 spring-boot-dependencies POM。 
	4. 恰到好处的资源过滤
	5. 恰到好处的插件配置（ exec插件，surefire，Git commit ID，shade）
	6. 恰到好处的对 application.properties 和 application.yml 进行筛选，
	7. 包括特定profile（ profile-specific） 的文件，比如 applicationfoo.properties 和 application-foo.yml
    8. 只需在`parent`标签下设定`version`版本号，导入其他starters就可以省略版本号
- **@ModelAttribute和@RequestBody**
    1. @ModelAttribute会将`name='测试'&age=1`映射为`user={name='测试',age=1}`传入方法参数
    2. @RequestBody是直接将`user={name='测试',age=1}`传入方法参数
- **@PropertySource、@ConfigurationProperties、@Value**
	1. `@PropertySource`是导入配置文件
	2. `@ConfigurationProperties`是将对象属性直接注入该配置类，一般设置`prefix`属性来分开对象，对象属性需要实现getter setter方法，但是@Value不需要实现getter setter方法，需要在属性上加@Value("${}")来一个一个导入
- **profile**

  该配置是针对不同环境提供不同配置支持的
  
  >	在`application.properties`文件中配置`spring.profile.active=pro`则会将`application-pro.properties`文件配置生效，舍弃`application-{other}.properties`文件内容