package com.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emp.entity.Dept;

public interface DeptDao {
   //查询所有信息
	@Select(" select deptno,dname,location "
			+ " from t_dept")
	@Results(id="deptMapper",value={
			@Result(id=true,column="deptno",property="deptno"),
			@Result(id=true,column="dname",property="dname"),
			@Result(id=true,column="location",property="location"),
	})
	List<Dept> queryAll();
	//根据编号查询
	@Select(" select deptno,dname,location "
			+ " from t_dept"
			+ " where deptno=#{deptno}")
	@ResultMap("deptMapper")
	Dept queryById(String deptno);
	//增
	@Insert(" insert into t_dept values(#{deptno},#{dname},#{location})")
	void addDept(Dept dept);
	//删
	@Delete(" delete from t_dept where deptno=#{deptno}")
	void deleteDept(String deptno);
	//改
	@Update("update t_dept set deptno=#{deptno},dname=#{dname},location=#{location}"
			+ " where deptno=#{deptno}")
	void updateDept(Dept deptno);
}
