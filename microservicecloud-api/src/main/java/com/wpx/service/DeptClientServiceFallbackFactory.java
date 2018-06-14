package com.wpx.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wpx.pojo.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 针对DeptClientService接口进行降级处理
 * 大坑 不要忘记@Component注解
 * @author wangpx
 *
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(long id) {
				return null;
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
