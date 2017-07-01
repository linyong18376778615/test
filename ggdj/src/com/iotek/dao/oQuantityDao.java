package com.iotek.dao;

import java.util.List;

import com.iotek.entity.oQuantity;


public interface oQuantityDao {
	public boolean saveOQuantity(oQuantity oQuantity) throws Exception;//添加数量关系
	public boolean updateOQuantity(oQuantity oQuantity) throws Exception;//更新数量关系
	public boolean delOQuantity(String orderId) throws Exception;//删除数量关系
	public List<oQuantity> queryNumById(int orderId) throws Exception;//通过订单编号查询商品数量
	public List<oQuantity> queryUserOrderInfo(String orderId) throws Exception;//通过订单编号查询商品详情
}
