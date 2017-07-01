package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.typeDao;
import com.iotek.dao.goodsDao;
import com.iotek.dao.impl.goodsDaoImpl;
import com.iotek.dao.impl.typeDaoImpl;
import com.iotek.entity.goods;
import com.iotek.entity.type;
import com.iotek.service.admin_goodsService;

public class admin_goodsServiceImpl implements admin_goodsService{
	goodsDao dao=new goodsDaoImpl();
	typeDao tdao=new typeDaoImpl();
	@Override
	public List<goods> queryAllGoods() throws Exception{       
		//查询商品所有信息
		
		return dao.queryAllGoods();
	}

	@Override
	public boolean goodsDelById(int goodsId) throws Exception{
		// 根据商品ID删除商品
		return dao.delGoods(goodsId);
	}

	@Override
	public boolean updateGoods(goods goods) throws Exception{
		// 修改商品信息
		return dao.updateGoods(goods);
	}
	
	@Override
	public boolean saveGoods(goods goods) throws Exception{
		// 添加商品
		return dao.saveGoods(goods);
	}

	@Override
	public goods goodsQueryById(int goodsId) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryGoodsById(goodsId);
	}

	@Override
	public List<goods> goodsQueryByName(String goodsName) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryGoodsByName(goodsName);
	}

	@Override
	public List<type> queryAllType() throws Exception{
		// TODO Auto-generated method stub
		return tdao.queryAllType();
	}
	
}
