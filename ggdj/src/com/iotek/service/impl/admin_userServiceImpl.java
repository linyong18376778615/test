package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.userDao;
import com.iotek.dao.impl.userDaoImpl;
import com.iotek.entity.user;
import com.iotek.service.admin_userService;

public class admin_userServiceImpl implements admin_userService {
	userDao dao=new userDaoImpl();
	public admin_userServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<user> queryAlluser() throws Exception{
		// TODO Auto-generated method stub
		return dao.queryAlluser();
	}

	@Override
	public boolean modify(user user) throws Exception{
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public void regist(user user) throws Exception{
		// TODO Auto-generated method stub
		dao.saveUser(user);
	}

	@Override
	public boolean delUser(int userId) throws Exception{
		// TODO Auto-generated method stub
		return dao.delUser(userId);
	}

	@Override
	public user queryUser(int userId) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryUser(userId);
	}


	@Override
	public List<user> findUser(String userName) throws Exception{
		// TODO Auto-generated method stub
		return dao.findUser(userName);
	}



}
