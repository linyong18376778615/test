package com.iotek.dao;

import java.util.List;

import com.iotek.entity.order;

public interface orderDao {
	public boolean saveOrder(order order) throws Exception;//添加订单
	public boolean delOrder(String orderId) throws Exception;//删除订单
	public List<order> queryAllOrder() throws Exception;//查询所有订单
	public order queryOrder(String orderId) throws Exception;//根据订单号查询订单表
	
	public List<order> queryUserOrder(int userId) throws Exception;//根据用户ID号查询该用户所拥有的订单
	public boolean updateOrder(order order) throws Exception;//修改对应订单
	public List<order> queryOrderByUserDate(String date,int userId) throws Exception;//根据用户ID号，日期查询该用户当天的订单
	public List<order> queryOrderByDate(String date) throws Exception;//根据日期模糊查询
	
	
}
