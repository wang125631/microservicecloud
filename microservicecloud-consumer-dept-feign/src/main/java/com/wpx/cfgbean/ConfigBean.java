package com.wpx.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 
 * @Configuration相当于其xml配置
 * 
 * 
 * @author wangpx
 *
 */
/**
 * @author wangpx
 *
 */
@Configuration
public class ConfigBean {

	
	/**
	 * 相当于
	 * <bean id="deptService" class="com.wpx.service.impl.DeptServiceImpl">
	 * 
	 * @return 返回要注入的接口
	 */
//	@Bean
//	public DeptService getDeptService(){
//		return new DeptServiceImpl();
//	} 

	/**
	 * @LoadBalanced 
	 * 
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	/**
	 * 
	 * 策略:
	 * 
	 * RoundRobinRule 轮询
	 * RandomRule 随机
	 * 
	 */
	@Bean
	public IRule myRule(){
		//return new RandomRule();
		return new RetryRule();
	}
	
	
}
