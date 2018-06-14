package com.wpx.service;

import java.util.List;

import com.wpx.pojo.Dept;

public interface DeptService {

	public boolean add(Dept dept);
	
	public Dept get(Long id);

	public List<Dept> list();

}
