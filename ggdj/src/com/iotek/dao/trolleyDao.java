package com.iotek.dao;

import com.iotek.entity.trolley;

public interface trolleyDao {
	public boolean saveTrolley(trolley trolley) throws Exception;//添加购物车
	public boolean updateTrolley(trolley trolley) throws Exception;//更新购物车
	public boolean delTrolley(int trolley) throws Exception;//清空购物车
	public trolley queryTrolley(String userName) throws Exception;//根据用户名查询该用户的购物车信息
}
