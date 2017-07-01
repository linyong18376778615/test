package com.iotek.service;

import java.util.List;

import com.iotek.entity.goods;
import com.iotek.entity.type;

public interface goodsService {
		
		public List<goods>	queryAllGoods() throws Exception;//所有商品查询
		public goods goodsQueryById(int goodsId) throws Exception;//根据商品查询商品Id
		public List<goods> goodsQueryByName(String goodsName) throws Exception;//根据商品名查询商品
		
		public List<type>	queryAllType() throws Exception;//查询商品的所有类型    
	    public List<goods> queryGoodsByType(int typeId) throws Exception;//通过类型Id查询商品
	    public boolean goodsDelById(int goodsId) throws Exception;//根据商品ID删除商品
		
}
