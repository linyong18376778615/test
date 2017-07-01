package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.supplierDao;
import com.iotek.dao.impl.supplierDaoImpl;
import com.iotek.entity.supplier;
import com.iotek.service.admin_supplierService;

public class admin_supplierServiceImpl implements admin_supplierService {
    supplierDao dao=new supplierDaoImpl();
	@Override
	public boolean saveSupplier(supplier supplier) throws Exception{
		//添加供应商
		return dao.saveSupplier(supplier);
	}

	@Override
	public boolean updateSupplier(supplier supplier) throws Exception{
		//修改供应商
		return dao.updateSupplier(supplier);
	}

	@Override
	public boolean delSupplier(int supplierId) throws Exception{
		// 删除供应商
		return dao.delSupplier(supplierId);
	}

	@Override
	public List<supplier> queryAllSupplier() throws Exception{
		// 查询供应商列表
		return dao.queryAllSupplier();
	}

	@Override
	public supplier querySupplierById(int supplierId) throws Exception{
		// 根据供应商编号查询该供应商的信息
		return dao.querySupplierById(supplierId);
	}

	@Override
	public List<supplier> querySupplierByName(String supplierName) throws Exception{
		// 根据供应商名字查询商品信息
		return dao.querySupplierByName(supplierName);
	}

	

	
}
