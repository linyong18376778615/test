package com.iotek.dao;

import java.util.List;

import com.iotek.entity.goods;

public interface goodsDao{
	public boolean saveGoods(goods goods) throws Exception;//�����Ʒ
	public boolean updateGoods(goods goods) throws Exception;//������Ʒ
	public boolean delGoods(goods goods) throws Exception;//ɾ����Ʒ
	public List<goods> queryAllGoods() throws Exception;//��ѯ������Ʒ

	
	public List<goods> queryGoodsByName(String goodsName) throws Exception;//ͨ����Ʒ������ָ����Ʒ
	public goods queryGoodsById(int goodsId) throws Exception;//����ָ�����ֵ���Ʒ
	
	public List<goods> queryGoodsByType(int typeId) throws Exception;//ͨ������Id��ѯ��Ʒ
	boolean delGoods(int goodsId) throws Exception;//ɾ����Ʒ
	
	
}
