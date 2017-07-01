package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.supplierDao;
import com.iotek.dao.impl.supplierDaoImpl;
import com.iotek.entity.supplier;
import com.iotek.service.supplierService;

public class supplierServiceImpl implements supplierService {
           supplierDao dao=new supplierDaoImpl();
	@Override
	public List<supplier> queryAllSupplier() throws Exception{
		//查询所有供应商
		return dao.queryAllSupplier();
	}

	
}
