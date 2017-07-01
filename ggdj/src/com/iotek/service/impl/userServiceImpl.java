package com.iotek.service.impl;

import com.iotek.dao.trolleyDao;
import com.iotek.dao.userDao;
import com.iotek.dao.impl.trolleyDaoImpl;
import com.iotek.dao.impl.userDaoImpl;
import com.iotek.entity.trolley;
import com.iotek.entity.user;
import com.iotek.service.userService;

public class userServiceImpl implements userService{
	userDao dao=new userDaoImpl();
	trolleyDao dao1=new trolleyDaoImpl();
	
	private int type=0;
	@Override
	public boolean login(String userName, String userPass) throws Exception{		//验证登录信息
		// TODO Auto-generated method stub
	   System.out.print(userName);
		user user1=new user();
		user1.setUserName(userName);
		user1=dao.queryUser1(user1);
		if(userPass.equals(user1.getUserPass())){
			this.type=user1.getUserType();
			return true;
			}
		else{
			return false;
		}
	}
	
	@Override
	public int getType() {					//获取用户权限类型
		return this.type;
	}

	@Override
	public void regist(user user) throws Exception{	 //注册用户
	
		dao.saveUser(user);
	}

	@Override
	public void modify(user user)  throws Exception{              //修改用户信息
		// TODO Auto-generated method stub
		 dao.updateUser(user);
	}

	@Override
	public user query(user user) throws Exception{				//查询用户个人信息
		return dao.queryUser1(user);
		
	}

	

	

}
