package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.textDao;
import com.iotek.dao.impl.textDaoImpl;
import com.iotek.entity.text;
import com.iotek.service.textService;

public class textServiceImpl implements textService{
		textDao dao=new textDaoImpl();

	@Override
	public List<text> query() throws Exception{
		//查询公告栏信息
		return dao.queryText();
	}
}
