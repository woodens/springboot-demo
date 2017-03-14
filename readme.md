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
- `@ComponentScan`注解一般放在根目录下包含main方法的启动类上  用于扫描该包下的类文件
- `@SpringBootApplication = @Configuration+ @EnableAutoConfiguration + @ComponentScan`
- 继承自 spring-boot-starter-parent 会有很多默认配置
	1. 默认编译级别为Java 1.6
	2. 源码编码为UTF-8
	3. 一个Dependency management节点，允许你省略常见依赖的 <version> 标签，继承自 spring-boot-dependencies POM。 
	4. 恰到好处的资源过滤
	5. 恰到好处的插件配置（ exec插件，surefire，Git commit ID，shade）
	6. 恰到好处的对 application.properties 和 application.yml 进行筛选，
	7. 包括特定profile（ profile-specific） 的文件，比如 applicationfoo.properties 和 application-foo.yml
    8. 只需在`parent`标签下设定`version`版本号，导入其他starters就可以省略版本号