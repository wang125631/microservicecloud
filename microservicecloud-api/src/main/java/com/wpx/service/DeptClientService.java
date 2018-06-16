package com.wpx.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wpx.pojo.Dept;
/**
 * 
 * @FeignClient(value="MICROSERVICECLOUD-DEPT")注解进行服务的熔断
 * 
 * @FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
 * 指定特定备用工厂,对服务进行降级处理 降级,该备用工厂需要实现FallbackFactory接口
 * @author wangpx
 *
 */
//@FeignClient(value="MICROSERVICECLOUD-DEPT")
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
}
