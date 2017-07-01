package com.iotek.service;

import java.util.List;

import com.iotek.entity.user;

public interface admin_userService {

	public List<user> queryAlluser() throws Exception;//查询所有用户
	public boolean modify(user user) throws Exception;//修改用户的个人信息
	public void regist(user user) throws Exception;//注册用户
	public boolean delUser(int userId) throws Exception;//删除用户
	public user queryUser(int userId) throws Exception;//查询用户的个人信息
	public List<user> findUser(String userName) throws Exception;//查找用户
}
