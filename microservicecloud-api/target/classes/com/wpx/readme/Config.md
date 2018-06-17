#Spring Cloud Config

1.说明

	配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git以及Subversion。

2.创建配置仓库microservicecloud-config,添加配置文件

	spring:
	  profiles:
	    active:
	    - dev
	---
	spring:
	  profiles: dev     #开发环境
	  application: 
	    name: microservicecloud-config-dev
	---
	spring:
	  profiles: test   #测试环境
	  application: 
	    name: microservicecloud-config-test

3.创建Config Server端	
3.1 添加依赖
	
	<!-- springCloud Config -->
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-config-server</artifactId>
	</dependency>
	<!-- 避免Config的Git插件报错：org/eclipse/jgit/api/TransportConfigCallback -->
	<dependency>
		<groupId>org.eclipse.jgit</groupId>
		<artifactId>org.eclipse.jgit</artifactId>
		<version>4.10.0.201712302008-r</version>
	</dependency>

3.2 相关配置

	server:
	  port: 3344
	  
	spring:
	  application:
	    name: microservicecloud-config
	  cloud:
	    config:
	      server:
	        git:
	          uri: https://github.com/wang125631/microservicecloud-config.git
	          username: wang125631
	          #password: ********* 
3.3测试连接
	
4.Config 客户端
4.1 客户端依赖

	<!-- SpringCloud Config客户端 -->
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-config</artifactId>
	</dependency>

4.2 客户端配置
bootstrap.yml
	
	#bootstrap.yml 是系统的配置项,优先级别更高 如:在bootstrap.yml中指定端口,再在application.yml中指定,application.yml文件中端口不会生效
	spring:
	  cloud:
	    config:
	      name: microservicecloud-config-client  #需要从github上读取的资源名称
	      profile: dev #本次访问的配置项
	      label: master
	      uri: http://localhost:3344 #服务启动通过3344间接与github获取连接 
	
application.yml

	spring:
	  application:
	    name: microservicecloud-config-client
	
5.客户端控制层获取配置信息

	@RestController
	public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public String getConfig(){
		String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
		System.out.println("******str: " + str);
		return "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
	}
	}
	
6.主启动类启动测试

	@SpringBootApplication
	public class ConfigClient3355_App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigClient3355_App.class, args);
	}

}
	
	
 	