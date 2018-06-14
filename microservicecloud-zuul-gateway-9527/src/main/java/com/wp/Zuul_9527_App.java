package com.wp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Zuul_9527_App {
public static void main(String[] args) throws Exception {
	SpringApplication.run(Zuul_9527_App.class, args);
}

}
