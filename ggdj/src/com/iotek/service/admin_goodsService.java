package com.iotek.service;

import java.util.List;

import com.iotek.entity.goods;
import com.iotek.entity.type;

public interface admin_goodsService {
	public boolean goodsDelById(int goodsId) throws Exception;//根据商品ID删除商品
	public boolean updateGoods(goods goods) throws Exception;//修改商品信息
	public boolean saveGoods(goods goods)throws Exception;//添加商品
	List<goods> queryAllGoods() throws Exception;//查询所有商品
	public goods goodsQueryById(int goodsId) throws Exception;//根据商品查询商品Id
	public List<goods> goodsQueryByName(String goodsName) throws Exception;//根据商品名查询商品
	public List<type> queryAllType() throws Exception;
}
