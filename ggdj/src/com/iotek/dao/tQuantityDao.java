package com.iotek.dao;

import java.util.List;

import com.iotek.entity.goods;
import com.iotek.entity.tQuantity;

public interface tQuantityDao {
	public boolean saveTQuantity(tQuantity tQuantity) throws Exception;//添加数量关系
	public boolean updateTQuantity(tQuantity tQuantity) throws Exception;//更新数量关系
	//public boolean delTQuantity(int tQuantityId);//删除数量关系
	public List<tQuantity> queryNumById(int trolleyId) throws Exception;//通过购物车编号查询商品数量表
	public boolean queryGoodsInTQuantity(int trolleyId,int goodsId) throws Exception;//在某用户的购物车数量表里获取对比goodsId
	public List<goods> queryUserCart(int trolleyId) throws Exception;//查询购物车的数据
	public boolean delTQuantity(int goodsId,int trolleyId) throws Exception;//删除购物车的商品
}
