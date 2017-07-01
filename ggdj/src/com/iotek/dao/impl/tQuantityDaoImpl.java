package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.tQuantityDao;
import com.iotek.entity.goods;
import com.iotek.entity.tQuantity;
import com.iotek.entity.user;

public class tQuantityDaoImpl extends BaseDao implements tQuantityDao {

	@Override
	public boolean saveTQuantity(tQuantity tQuantity) throws Exception{
		String sql="insert into tquantity(goodsId,quantity,trolleyId)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(tQuantity.getGoodsId());
		params.add(tQuantity.getQuantity());
		params.add(tQuantity.getTrolleyId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateTQuantity(tQuantity tQuantity) throws Exception{
		String sql="update tquantity set goodsId=?,quantity=?,trolleyId=? where tQuantityId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(tQuantity.getGoodsId());
		params.add(tQuantity.getQuantity());
		params.add(tQuantity.getTrolleyId());
		params.add(tQuantity.gettQuantityId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delTQuantity(int goodsId,int trolleyId) throws Exception{
		String sql="delete from tQuantity where goodsId=? and trolleyId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(goodsId);
		params.add(trolleyId);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<tQuantity> queryNumById(int trolleyId) throws Exception{
		String sql="select quantity,trolleyId from tQuantity where trolleyId=?";
		List<tQuantity> qList=null;
		List<Object> params=new ArrayList<Object>();
		params.add(trolleyId);
		try {
			qList=this.operQuery(sql, params, tQuantity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qList;
	}

	
	//联表查询该用户的购物车信息
	public List<goods> queryUserCart(int trolleyId) throws Exception{  
		String sql="select goodsName,img,goodsDescription,goodsPrice,g.goodsId from goods g,tquantity t where t.trolleyId=? and t.goodsId=g.goodsId";
		List<goods> list=new ArrayList<goods>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,trolleyId);
			rs=pstmt.executeQuery();
			while(rs.next()){
			list.add(load(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	private goods load(ResultSet rs) {
		goods goods=new goods();
		try{
		goods.setGoodsName(rs.getString(1));
		goods.setImg(rs.getString(2));
		goods.setGoodsDescription(rs.getString(3));
		goods.setGoodsPrice(rs.getDouble(4));
		goods.setGoodsId(rs.getInt(5));

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return goods;
	}

	

	
	
	
	public boolean queryGoodsInTQuantity(int trolleyId,int goodsId) throws Exception{  //判断该商品是否以及添加进了购物车
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT goodsId from tquantity WHERE trolleyId=? and goodsId=?";
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,trolleyId);
		    pstmt.setInt(2,goodsId);
			rs=pstmt.executeQuery();
			if(rs.next()){
			  flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}
