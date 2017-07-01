package com.iotek.service;

import com.iotek.entity.trolley;
import com.iotek.entity.user;

public interface userService {
		public boolean login(String userName,String userPass) throws Exception;//验证登录
		public int getType() throws Exception;//获取用户类型名
		public void regist(user user) throws Exception;//注册用户
		
		public user query(user user) throws Exception;//查询用户的个人信息
		public void modify(user user) throws Exception;//修改用户的个人信息
}
