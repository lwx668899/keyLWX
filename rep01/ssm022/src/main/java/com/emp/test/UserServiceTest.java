package com.emp.test;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.entity.User;
import com.emp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class UserServiceTest {
    //×¢ÈëÒµÎñ²ã
	@Resource
	private UserService userService;
	@Test
	public void testQueryUser(){
		User user=userService.queryUser("ls");
		System.out.println(user);
		
	}
	@Test
	public void testQueryRoles(){
		
		Set<String> roles=userService.queryRoles("ls");
		System.out.println(roles);
	}
	@Test
	public void testQueryPers(){
		Set<String> pers=userService.queryPermissions("ls");
		System.out.println(pers);
	}
	@Test
	public void testAdd(){
		
		User user=new User();
		user.setUsername("mm");
		user.setPassword("123");
		userService.addUser(user);
		System.out.println();
	}
}
