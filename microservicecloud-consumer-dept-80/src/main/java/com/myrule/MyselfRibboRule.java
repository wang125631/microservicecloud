package com.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MyselfRibboRule {

	@Bean
	public IRule getIRule(){
		return new RandomRule_5();
	}
}
