package com.iotek.dao;

import java.util.List;

import com.iotek.entity.supplier;


public interface supplierDao {
	public boolean saveSupplier(supplier supplier) throws Exception;//添加供应商
	public boolean updateSupplier(supplier supplier) throws Exception;//更新供应商
	public boolean delSupplier(int supplierId) throws Exception;//删除供应商
	public List<supplier> queryAllSupplier() throws Exception;//查询所有供应商
	public supplier querySupplierById(int supplierId) throws Exception;//根据供应商编号查询供应商
	public List<supplier> querySupplierByName(String supplierName) throws Exception;
}

