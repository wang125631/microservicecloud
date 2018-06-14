package com.wpx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpx.dao.DeptDao;
import com.wpx.pojo.Dept;
import com.wpx.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService{

	@Resource
	private DeptDao deptDao;

	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		List<Dept> findAll = deptDao.findAll();
		if(findAll == null){
			return null;
		}
		return findAll;
	}
	

}
