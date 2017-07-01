package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.supplierDao;
import com.iotek.entity.goods;
import com.iotek.entity.supplier;
import com.iotek.entity.text;

public class supplierDaoImpl extends BaseDao implements supplierDao {
    
	//添加供应商
	@Override
	public boolean saveSupplier(supplier supplier) throws Exception{
		String sql="insert into supplier(supplierName,supplierAddress,suImg,suTel,suFruit) values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(supplier.getSupplierName());
		params.add(supplier.getSupplierAddress());
		params.add(supplier.getSuImg());
		params.add(supplier.getSuTel());
		params.add(supplier.getSuFruit());
		return this.operUpdate(sql, params);
	}

	//修改供应商信息
	@Override
	public boolean updateSupplier(supplier supplier) throws Exception{
		String sql="update supplier set supplierName=?,supplierAddress=?,suImg=?,suTel=?,suFruit=? where supplierId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(supplier.getSupplierName());
		params.add(supplier.getSupplierAddress());
		params.add(supplier.getSuImg());
		params.add(supplier.getSuTel());
		params.add(supplier.getSuFruit());	
		params.add(supplier.getSupplierId());
		return this.operUpdate(sql, params);
	}
	
    //删除供应商信息
	@Override
	public boolean delSupplier(int supplierId) throws Exception{
		String sql="delete from supplier where supplierId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(supplierId);
		return this.operUpdate(sql, params);
	}
	
    //查询所有供应商信息
	@Override
	public List<supplier> queryAllSupplier() throws Exception{
		String sql="select * from supplier";
		List<supplier> sList=null;
		try {
			sList=this.operQuery(sql, null, supplier.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sList;
	}

	//查询根据某个供应商Id的信息
	public supplier querySupplierById(int supplierId) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from supplier where supplierId=?";
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,supplierId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				load(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return load(rs);
	}
	
	private supplier load(ResultSet rs) {
		supplier supplier=new supplier();
		try{
			supplier.setSupplierId(rs.getInt(1));
			supplier.setSupplierName(rs.getString(2));
			supplier.setSupplierAddress(rs.getString(3));
			supplier.setSuImg(rs.getString(4));
			supplier.setSuTel(rs.getString(5));
			supplier.setSuFruit(rs.getString(6));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return supplier;
	}

	@Override
	public List<supplier> querySupplierByName(String supplierName) throws Exception{
		// 按供应商的姓名搜索
		String sql="select * from supplier where supplierName like '%"+supplierName+"%' ";
		List<supplier> list=new ArrayList<supplier>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
			pstmt=conn.prepareStatement(sql);	   
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(load(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
