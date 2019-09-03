package com.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emp.dao.DeptDao;
import com.emp.dao.EmpDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;
import com.emp.service.DeptService;
import com.emp.service.EmpService;
import com.emp.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeptServiceImpl implements DeptService {
   //×¢ÈëÔ±¹¤Dao 
	@Resource
	private DeptDao deptDao;

	@Override
	public List<Dept> queryAllDepts() {
		List<Dept> depts=deptDao.queryAll();
		return depts;
	}


	@Override
	public List<Emp> queryAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp queryEmpById(String empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmp(String empno) {
		// TODO Auto-generated method stub
		
	}
	
	
}
