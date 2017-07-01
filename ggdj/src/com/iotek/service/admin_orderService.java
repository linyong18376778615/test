package com.iotek.service;
import com.iotek.entity.oQuantity;
import com.iotek.entity.order;

import java.util.List;
public interface admin_orderService {
	public List<order> qureAllOrder() throws Exception;//查询所有订单
	public boolean delOrder(String orderId) throws Exception;//删除订单
	public boolean modifyOrder(order order) throws Exception;//修改订单
	public order orderQueryById(String orderId) throws Exception;//查询对应订单
	public List<order> qureOrder(String date) throws Exception;//根据日期模糊查询

}
