package com.iotek.dao;

import java.util.List;

import com.iotek.entity.text;

public interface textDao {
	public boolean saveText(text text) throws Exception;//添加公告
	public boolean updateText(text text) throws Exception;//更新公告
	public boolean delText(int textId) throws Exception;//删除公告
	public List<text> queryText() throws Exception;//查所有公告
	public List<text> queryImgById(int textId) throws Exception;//通过公告编号查询图片
	public List<text> findtext(String textContent) throws Exception;//通过内容搜索公告
	public text queryText(int textId) throws Exception;//通过公告编号查询内容
}
