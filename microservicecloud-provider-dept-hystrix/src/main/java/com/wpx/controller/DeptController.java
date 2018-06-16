package com.wpx.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
	
	/**
	 * @HystrixCommand(fallbackMethod="processHystrix_Get")
	 * 发生异常执行processHystrix_Get方法
	 */
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id")Long id){
		 Dept dept = deptService.get(id);
		if(dept ==null){
			throw new RuntimeException("该ID: "+id+" 没有与之相对应的信息!!");
		}
		return dept;
	}
	
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Dept> list(){
		return deptService.list();
	}
	

}
