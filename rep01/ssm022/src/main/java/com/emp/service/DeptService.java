package com.emp.service;

import java.util.List;

import com.emp.entity.Dept;
import com.emp.entity.Emp;

public interface DeptService {
   //查询所有部门
	List<Dept> queryAllDepts();
	//查询所有员工
	List<Emp> queryAllEmps();
	//依据员工编号查询员工
	Emp queryEmpById(String empno);
	//添加员工
	void addEmp(Emp emp);
	//修改员工
	void updateEmp(Emp emp);
	//删除员工
	void deleteEmp(String empno);	
}
