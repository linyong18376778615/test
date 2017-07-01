package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.orderDao;
import com.iotek.dao.textDao;
import com.iotek.dao.impl.orderDaoImpl;
import com.iotek.dao.impl.textDaoImpl;
import com.iotek.entity.text;
import com.iotek.service.admin_textService;

public class admin_textServiceImpl implements admin_textService {
	textDao dao=new textDaoImpl();
	public admin_textServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<text> queryAlltext() throws Exception{
		// TODO Auto-generated method stub
		return dao.queryText() ;
	}

	@Override
	public boolean modify(text text) throws Exception{
		// TODO Auto-generated method stub
		return dao.updateText(text);
	}

	@Override
	public void addText(text text) throws Exception{
		// TODO Auto-generated method stub
		dao.saveText(text);
	}

	@Override
	public boolean deltext(int textId) throws Exception{
		// TODO Auto-generated method stub
		return dao.delText(textId);
	}

	@Override
	public text querytext(int textId) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryText(textId);
	}

	@Override
	public List<text> findtext(String textContent) throws Exception{
		// TODO Auto-generated method stub
		return dao.findtext(textContent);
	}

}
