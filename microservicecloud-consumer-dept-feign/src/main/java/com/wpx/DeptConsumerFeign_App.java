package com.wpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用@RibbonClient注解使默认配置生效 自定义配置类不能放在@ComponentScan所扫描的当前包以及子包下
 * 否则我们自定义的这个配置类就会被所有的Ribbo客户端所共享,也就是说我们达不到特殊化定制的目的
 *
 * 
 * @author wangpx
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = { "com.wpx" })
@ComponentScan("com.wpx")
public class DeptConsumerFeign_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptConsumerFeign_App.class, args);
	}
}
