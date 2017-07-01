package com.iotek.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.trolleyDao;
import com.iotek.entity.goods;
import com.iotek.entity.trolley;

public class trolleyDaoImpl extends BaseDao implements trolleyDao{

	@Override
	public boolean saveTrolley(trolley trolley) throws Exception{
		// TODO Auto-generated method stub
		String sql="insert into trolley (userName) values(?)";
		List<Object> params=new ArrayList<Object>();
		params.add(trolley.getUserName());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateTrolley(trolley trolley) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delTrolley(int trolley)  throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public trolley queryTrolley(String userName)  throws Exception{
		// TODO Auto-generated method stub
		String sql="select * from trolley where userName=?";
		List<trolley> List=null;
		List<Object> params=new ArrayList<Object>();
		params.add(userName);
		try {
			List=this.operQuery(sql, params, trolley.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List.get(0);
	}

}
