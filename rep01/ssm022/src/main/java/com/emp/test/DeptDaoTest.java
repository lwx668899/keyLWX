package com.emp.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.DeptDao;
import com.emp.dao.DeptLazyDao;
import com.emp.dao.EmpDao;
import com.emp.entity.Dept;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class DeptDaoTest {
	@Resource
   private DeptDao deptDao;
	@Test//查询所有
	public void testQueryAll() {
	       List<Dept> depts = deptDao.queryAll();
	       for(Dept d:depts){
	    	    System.out.println(d.getDeptno()+","+d.getDname()
	    	    		+","+d.getLocation());
	       }
	}
	@Test//根据编号查询
	public void testQueryById() {
	       Dept dept = deptDao.queryById("d001");
	      System.out.println(dept);
	}
	@Test//增
	public void testAddDept() {
	       Dept dept = new Dept();
	       dept.setDeptno("d009");
	       dept.setDname("公关部");
	       dept.setLocation("长沙");
	       deptDao.addDept(dept);
	      System.out.println("插入成功");
	      List<Dept> depts = deptDao.queryAll();
	       for(Dept d:depts){
	    	    System.out.println(d.getDeptno()+","+d.getDname()
	    	    		+","+d.getLocation());
	       }
	}
	@Test//删
	public void testDeleteDept() {
	      deptDao.deleteDept("d009");
	      System.out.println("删除成功");
	      List<Dept> depts = deptDao.queryAll();
	       for(Dept d:depts){
	    	    System.out.println(d.getDeptno()+","+d.getDname()
	    	    		+","+d.getLocation());
	       }
	}
	@Test//改
	public void testUpdateDept() {
	       Dept dept = deptDao.queryById("d009");
	       dept.setDeptno("d008");
	       dept.setDname("秘书部");
	       dept.setLocation("韶关");
	       deptDao.updateDept(dept);
	       System.out.println(dept);
	}
	//懒加载
	@Resource
	private DeptLazyDao deptLazyDao;
	@Test
	public void testLazyQueryDeptno() {
		Dept d=deptLazyDao.queryLazyDeptno("d001");
	       System.out.println(d.getDeptno()+","+d.getDname()
	       		+","+d.getLocation()+","+d.getEmps());
	}
	@Test//查全部
	public void testLazyQueryDeptnoAll() {
		List<Dept> ds=deptLazyDao.queryLazyDeptnoAll();
		for(Dept d:ds){
	       System.out.println(d.getDname());		
		   System.out.println("~~~~~~~~~~~");
		   List<Emp> list=d.getEmps();
		for(Emp l:list){
			System.out.println(l.getEname());
		}
		}
	}
	
}