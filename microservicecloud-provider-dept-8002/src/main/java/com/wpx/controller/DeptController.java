package com.wpx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wpx.pojo.Dept;
import com.wpx.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Resource
	private DeptService deptService;
	@Resource
	private DiscoveryClient client;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public boolean add(Dept dept){
		return deptService.add(dept);
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id")Long id){
		return deptService.get(id);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Dept> list(){
		return deptService.list();
	}
	
	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
