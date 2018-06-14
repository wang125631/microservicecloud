package com.wpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @springBootAppliction 注解会自动扫描其子包
 * @author wangpx
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient 
public class DeptProvider8002_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptProvider8002_App.class, args);
	}

}
