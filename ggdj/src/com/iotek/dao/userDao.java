package com.iotek.dao;

import java.util.List;

import com.iotek.entity.user;


public interface userDao {
	public boolean saveUser(user user) throws Exception;//添加用户
	public boolean updateUser(user user) throws Exception;//更新用户
	public boolean delUser(int userId) throws Exception;//删除用户
	public user queryUser1(user user) throws Exception;//查询用户
	public List<user> queryAlluser() throws Exception;//查询所有用户
	public user queryUser(int userId) throws Exception;//查询用户
	public List<user> findUser(String userName) throws Exception;//查找用户
}
