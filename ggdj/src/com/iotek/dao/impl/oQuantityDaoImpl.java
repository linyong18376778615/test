package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.oQuantityDao;
import com.iotek.entity.goods;
import com.iotek.entity.oQuantity;

public class oQuantityDaoImpl extends BaseDao implements oQuantityDao {

	@Override
	public boolean saveOQuantity(oQuantity oQuantity) throws Exception {
		String sql="insert into oQuantity(goodsId,quantity,orderId)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(oQuantity.getGoodsId());
		params.add(oQuantity.getQuantity());
		params.add(oQuantity.getOrderId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateOQuantity(oQuantity oQuantity) throws Exception{
		String sql="update oquantity set goodsId=?,quantity=?,orderId=? where oquantityId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(oQuantity.getGoodsId());
		params.add(oQuantity.getQuantity());
		params.add(oQuantity.getOrderId());
		params.add(oQuantity.getoQuantityId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delOQuantity(String orderId) throws Exception{
		String sql="delete from oQuantity where orderId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(orderId);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<oQuantity> queryNumById(int orderId) throws Exception{
		String sql="select quantity from oQuantity where orderId=?";
		List<oQuantity> qList=null;
		List<Object> params=new ArrayList<Object>();
		params.add(orderId);
		try {
			qList=this.operQuery(sql, params, oQuantity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qList;
	}

	@Override     //联order表和oQuantity查询该用户的某一单具体的信息 
	public List<oQuantity> queryUserOrderInfo(String orderId) throws Exception {
           String sql="select goodsName,img,goodsPrice,g.goodsId,ot.quantity "
           		      + "from goods g,oquantity ot where ot.orderId=? "
           		      + "and ot.goodsId=g.goodsId";
           List<oQuantity> list=new ArrayList<oQuantity>();
           Connection conn=null;
   		   PreparedStatement pstmt=null;
   		   ResultSet rs=null;
   		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1, orderId);
			rs=pstmt.executeQuery();
			while(rs.next()){
			list.add(load(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	private oQuantity load(ResultSet rs) {
		oQuantity oQuantity=new oQuantity();
		try{
			oQuantity.setGoodsName(rs.getString(1));
			oQuantity.setImg(rs.getString(2));
			oQuantity.setGoodsPrice(rs.getDouble(3));
			oQuantity.setGoodsId(rs.getInt(4));
			oQuantity.setQuantity(rs.getInt(5));

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return oQuantity;
	}
}
