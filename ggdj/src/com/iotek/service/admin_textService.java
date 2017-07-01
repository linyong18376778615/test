package com.iotek.service;

import java.util.List;

import com.iotek.entity.text;

public interface admin_textService {


	public List<text> queryAlltext() throws Exception;//查询所有公告
	public boolean modify(text text) throws Exception;//修改公告信息
	public void addText(text text) throws Exception;//添加公告
	public boolean deltext(int textId) throws Exception;//删除公告
	public text querytext(int textId) throws Exception;//查询单个公告信息
	public List<text> findtext(String textContent) throws Exception;//查找公告

}
