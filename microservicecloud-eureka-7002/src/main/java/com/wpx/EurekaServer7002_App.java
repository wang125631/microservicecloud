package com.wpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 
 *  本地测试修改hosts文件 C:\Windows\System32\drivers\etc
 * 	将eureka7001.com 映射为本地ip
 * 
 * @author wangpx
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002_App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServer7002_App.class, args);
	}

}
