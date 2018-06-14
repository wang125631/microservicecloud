package com.wpx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wpx.pojo.Dept;
import com.wpx.service.DeptClientService;

/**
 * 
 * @author wangpx
 *
 */
@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {
	@Resource
	private DeptClientService service;
	
	@RequestMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.service.get(id);
	}

	@RequestMapping(value = "/dept/list")
	public List<Dept> list()
	{
		return this.service.list();
	}

	@RequestMapping(value = "/dept/add")
	public Object add(Dept dept)
	{
		return this.service.add(dept);
	}

}
