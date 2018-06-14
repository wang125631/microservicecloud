package com.wpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 
 * @EnableEurekaServer
 * 使用Eureka服务
 * 
 * @author wangpx
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001_App {
public static void main(String[] args) throws Exception {
	SpringApplication.run(EurekaServer7001_App.class, args);
}

}
