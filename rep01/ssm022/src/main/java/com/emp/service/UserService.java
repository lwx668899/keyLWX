package com.emp.service;

import java.util.Set;

import com.emp.entity.User;

public interface UserService {
  //用户名查询用户
  User queryUser(String username);
  //添加用户(注册使用)
  void addUser(User user);
  //用户名查找该用户所有的角色
  Set<String> queryRoles(String username);
  //用户名查找该用户所有的权限
  Set<String> queryPermissions(String username);
}
