package com.iotek.service;

import java.util.List;

import com.iotek.entity.oQuantity;
import com.iotek.entity.order;

public interface orderService {
	public int[] StringToInt(String[] arrs);//将String数组转成int数组
	public List<order> queryOrderByDate(String date,int userId) throws Exception;//根据用户ID号，日期查询该用户当天的订单
	public  boolean saveOrder(order order) throws Exception;//创建一个订单
	public boolean saveOQuantity(oQuantity oQuantity) throws Exception;//将选择购买的商品插入订单中
	public List<order> queryUserOrder(int userId) throws Exception;//根据用户Id查询用户的所有订单
	public List<oQuantity> queryUserOrderInfo(String orderId) throws Exception;//根据订单号查询该订单详情（连接订单表与订单数量表）
	public order queryOrder(String orderId) throws Exception;//根据订单号查询订单表相应的信息
	public boolean delOrder(String orderId) throws Exception;//删除订单
}
