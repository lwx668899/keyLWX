package com.emp.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.dao.UserDao;
import com.emp.entity.User;
import com.emp.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    
    @Resource
    private UserDao userDao;
	@Override
	public User queryUser(String username) {
		User user=userDao.getByUserame(username);
		return user;
	}

	@Override
	public Set<String> queryRoles(String username) {
		Set<String> roles=userDao.queryRoles(username);
		return roles;
	}

	@Override
	public Set<String> queryPermissions(String username) {
		Set<String> permissions =userDao.getPermissions(username);
		return permissions;
	}

	@Override
	public void addUser(User user) {
		//加盐,加密
		//MD5常用加密算法
		//加密密码
		String password//算法 需要加密 的密码  盐 加密的次数
		= new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024).toString();
		//password就是加密后的密码
		//用户加密后的密码置换原来从页面传来 的密码
		user.setPassword(password);
		//将user保存到数据库中
		userDao.save(user);
	}
  
}
