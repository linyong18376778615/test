package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.tQuantityDao;
import com.iotek.dao.trolleyDao;
import com.iotek.dao.impl.tQuantityDaoImpl;
import com.iotek.dao.impl.trolleyDaoImpl;
import com.iotek.entity.goods;
import com.iotek.entity.tQuantity;
import com.iotek.entity.trolley;
import com.iotek.service.trolleyService;

public class trolleyServiceImpl implements trolleyService {
	trolleyDao dao1=new trolleyDaoImpl();
	tQuantityDao dao2=new tQuantityDaoImpl();
	
	@Override
	public trolley queryTrolley(String userName) throws Exception{
		//根据用户名查询该用户购物车表信息
		return dao1.queryTrolley(userName);
	}

	@Override
	public List<tQuantity> queryNumById(int trolleyId) throws Exception{  
		 //按购物车编号查询购物车数量表的信息
		
		return dao2.queryNumById(trolleyId);
	}

	@Override
	public void saveTQuantity(tQuantity tQuantity) throws Exception{     
		 //添加商品到用户专有的购物车中
		 dao2.saveTQuantity(tQuantity);
	}

	@Override
	public boolean queryGoodsInTQuantity(int trolleyId, int goodsId) throws Exception{ 
		//在购物车数量表里对比goodsId,查找不到时插入
		
		return dao2.queryGoodsInTQuantity(trolleyId, goodsId);
	}

	@Override
	public List<goods> queryUserCart(int trolleyId) throws Exception{     
		//根据购物车id查询该用户购物车
		return dao2.queryUserCart(trolleyId);
		
	}

	@Override
	public boolean delTQuantity(int goodsId, int trolleyId) throws Exception{   
		//删除购物车的商品
		return dao2.delTQuantity(goodsId, trolleyId);
	}

	@Override
	public void saveTrolley(trolley trolley) throws Exception{
		//创建一个购物车
		dao1.saveTrolley(trolley);
		
	}
}
