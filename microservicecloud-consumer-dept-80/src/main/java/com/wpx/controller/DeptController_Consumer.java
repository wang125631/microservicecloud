package com.wpx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wpx.pojo.Dept;

/**
 * 
 * SpringMVC中RestFul要结合HiddenHttpMethodFilter使用, 在post表单中指定name="_method"
 * 的值为delete,put
 * 
 * restTemplate在此基础加以封装 访问接口(url.requestMap,ResponseBean.class)
 * 三个参数分别为Rest请求地址,请求参数,HTTP响应转化被转化成的对象类型
 * 
 * @author wangpx
 *
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@Resource
	private RestTemplate restTemplate;

	@RequestMapping(value="/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value="/get/{id}")
	public Dept get(@PathVariable("id")Long id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
}
