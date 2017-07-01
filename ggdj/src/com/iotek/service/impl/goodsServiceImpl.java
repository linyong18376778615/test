package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.goodsDao;
import com.iotek.dao.typeDao;
import com.iotek.dao.impl.goodsDaoImpl;
import com.iotek.dao.impl.typeDaoImpl;
import com.iotek.entity.goods;
import com.iotek.entity.type;
import com.iotek.service.goodsService;

public class goodsServiceImpl implements goodsService{
	goodsDao dao1=new goodsDaoImpl();

	typeDao tdao=new typeDaoImpl();
	
	@Override
	public List<goods> queryAllGoods() throws Exception{       
		//查询商品所有信息
		
		return dao1.queryAllGoods();
	}
	
	@Override
	public goods goodsQueryById(int goodsId) throws Exception{	
		//按商品编号查询商品信息

		return dao1.queryGoodsById(goodsId);
	}

	@Override
	public List<goods> queryGoodsByType(int typeId) throws Exception{
		// 根据类型ID号查询同种类型的商品
		return dao1.queryGoodsByType(typeId);
	}

	@Override
	public List<goods> goodsQueryByName(String goodsName) throws Exception{
		//根据商品名称查询商品
		return dao1.queryGoodsByName(goodsName);
	}
	
	@Override
	public List<type> queryAllType() throws Exception{
		//查询商品的所有类型
		return tdao.queryAllType();
	}

	@Override
	public boolean goodsDelById(int goodsId) throws Exception{
		//根据商品ID删除商品
		return dao1.delGoods(goodsId);
	}

	

	
	

}
