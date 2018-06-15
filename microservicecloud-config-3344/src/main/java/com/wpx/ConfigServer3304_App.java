package com.wpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * 
 * @EnableConfigServer注解说明该类为配置服务类
 * 
 * @author wangpx
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer3304_App {
public static void main(String[] args) throws Exception {
	SpringApplication.run(ConfigServer3304_App.class, args);
}

}
