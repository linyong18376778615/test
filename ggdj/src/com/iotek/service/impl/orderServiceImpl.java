package com.iotek.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.oQuantityDao;
import com.iotek.dao.orderDao;
import com.iotek.dao.impl.oQuantityDaoImpl;
import com.iotek.dao.impl.orderDaoImpl;
import com.iotek.entity.oQuantity;
import com.iotek.entity.order;
import com.iotek.service.orderService;

public class orderServiceImpl implements orderService{
	orderDao dao=new orderDaoImpl();
	oQuantityDao dao1=new oQuantityDaoImpl();
	@Override
	public List<order> queryOrderByDate(String date, int userId) throws Exception{
		//根据用户ID号，日期查询该用户当天的订单
		return dao.queryOrderByUserDate(date, userId);
	}
	
	@Override
	public int[] StringToInt(String[] arrs) {
		//将String数组转成int数组
		List<String> list=new ArrayList<String>();
	    for(int i=0;i<arrs.length;i++){
	    	if(!(arrs[i].equals("a")))
	    	{
	    		list.add(arrs[i]);
	    	}
	    	}
	    int[] ints = new int[list.size()];
	    //System.out.println(list.size());
	      for(int i=0;i<list.size();i++)
	    	  ints[i] = Integer.parseInt(list.get(i));
		return ints;
	}

	@Override
	public boolean saveOrder(order order) throws Exception{					
		//创建一个订单
		
		return dao.saveOrder(order);
	}
	
	@Override
	public boolean saveOQuantity(oQuantity oQuantity) throws Exception{  
		//将选择购买的商品插入订单中
		return dao1.saveOQuantity(oQuantity);
	}
	
	@Override
	public List<order> queryUserOrder(int userId) throws Exception{ 				
		//根据用户Id查询用户的所有订单
		return dao.queryUserOrder(userId);
	}

	@Override
	public List<oQuantity> queryUserOrderInfo(String orderId) throws Exception{
		// 根据订单号查询某一个详细的订单
		return dao1.queryUserOrderInfo(orderId);
	}

	@Override
	public order queryOrder(String orderId) throws Exception{
		//根据订单号查询订单表相应的信息
		return dao.queryOrder(orderId);
	}

	@Override
	public boolean delOrder(String orderId) throws Exception{
		// TODO Auto-generated method stub
		return dao.delOrder(orderId);
	}
	
	
}
