#Hystix

1. 说明
	
	Zuul是Netflix开源的微服务网关
	
2. 添加依赖

	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-zuul</artifactId>
	</dependency>

3. yml文件配置路由规则

	zuul:
	  prefix: /wpx/
	  ignored-services: "*"   # 使用"*"注解表示所有程序原始访问服务路径忽略      microservicecloud-dept
	  routes:
	    mydept.serviceId: microservicecloud-dept
	    mydept.path: /mydept/**
	 
4. 测试通过自定义路由规则访问路径