package com.iotek.dao;

import java.util.List;

import com.iotek.entity.goods;

public interface goodsDao{
	public boolean saveGoods(goods goods) throws Exception;//添加商品
	public boolean updateGoods(goods goods) throws Exception;//更新商品
	public boolean delGoods(goods goods) throws Exception;//删除商品
	public List<goods> queryAllGoods() throws Exception;//查询所有商品

	
	public List<goods> queryGoodsByName(String goodsName) throws Exception;//通过商品名查找指定商品
	public goods queryGoodsById(int goodsId) throws Exception;//查找指定名字的商品
	
	public List<goods> queryGoodsByType(int typeId) throws Exception;//通过类型Id查询商品
	boolean delGoods(int goodsId) throws Exception;//删除商品
	
	
}
