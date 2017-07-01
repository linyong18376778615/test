package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.orderDao;
import com.iotek.dao.impl.orderDaoImpl;
import com.iotek.entity.oQuantity;
import com.iotek.entity.order;
import com.iotek.service.admin_orderService;

public class admin_orderServiceImpl implements admin_orderService {
	orderDao dao=new orderDaoImpl();
	public admin_orderServiceImpl() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<order> qureAllOrder() throws Exception{
		// TODO Auto-generated method stub
		
		return dao.queryAllOrder();
	}


	@Override
	public boolean modifyOrder(order order) throws Exception{
		// TODO Auto-generated method stub
		return dao.updateOrder(order);
	}

	@Override
	public boolean delOrder(String orderId) throws Exception{
		// TODO Auto-generated method stub
		return dao.delOrder(orderId);
	}

	@Override
	public order orderQueryById(String orderId) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryOrder(orderId);
	}

	@Override
	public List<order> qureOrder(String date) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryOrderByDate(date);
	}

	

}
