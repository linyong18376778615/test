package com.iotek.dao;

import java.util.List;

import com.iotek.entity.type;

public interface typeDao {
	public boolean saveType(type type) throws Exception;//添加类型
	public boolean updateType(type type) throws Exception;//更新类型
	public boolean delType(int typeId) throws Exception;//删除类型
	public List<type> queryAllType() throws Exception;//查询所有商品类型
}
