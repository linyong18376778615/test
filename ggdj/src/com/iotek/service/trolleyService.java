package com.iotek.service;

import java.util.List;

import com.iotek.entity.goods;
import com.iotek.entity.tQuantity;
import com.iotek.entity.trolley;

public interface trolleyService {
	public void saveTrolley(trolley trolley) throws Exception;
	public trolley queryTrolley(String userName) throws Exception;//根据用户名查询该用户购物车表信息
	public List<tQuantity> queryNumById(int trolleyId) throws Exception;//查询购物车商品数量表
	public void saveTQuantity(tQuantity tQuantity) throws Exception;//添加商品进购物车商品数量表
	public boolean queryGoodsInTQuantity(int trolleyId,int goodsId) throws Exception;//查询对比某用户购物车的商品id
	public List<goods> queryUserCart(int trolleyId) throws Exception;//根据购物车id查询该用户购物车
    public boolean delTQuantity(int goodsId,int trolleyId) throws Exception;//删除购物车的商品
}
