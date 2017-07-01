package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.goodsDao;
import com.iotek.entity.goods;
import com.iotek.entity.user;

public class goodsDaoImpl extends BaseDao implements goodsDao {

	@Override
	public boolean saveGoods(goods goods) throws Exception{//添加商品
		String sql="insert into goods(goodsName,typeId,goodsDescription,supplierId,goodsPrice, img)values(?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(goods.getGoodsName());
		params.add(goods.getTypeId());
		params.add(goods.getGoodsDescription());
		params.add(goods.getSupplierId());
		params.add(goods.getGoodsPrice());
		params.add(goods.getImg());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateGoods(goods goods) throws Exception{//修改商品
		String sql="update goods set goodsName=?,typeId=?,goodsDescription=?,supplierId=?,goodsPrice=?, img=? where goodsId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(goods.getGoodsName());
		params.add(goods.getTypeId());
		params.add(goods.getGoodsDescription());
		params.add(goods.getSupplierId());
		params.add(goods.getGoodsPrice());
		params.add(goods.getImg());
		params.add(goods.getGoodsId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delGoods(int goodsId) throws Exception{//删除商品
		String sql="delete from goods where goodsId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(goodsId);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<goods> queryAllGoods() throws Exception{//查询所有商品
		String sql="select goodsId,goodsName,typeId,goodsDescription,supplierId,goodsPrice,img from goods ";
		List<goods> gList=null;
		try {
			gList=this.operQuery(sql, null, goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gList;
	}

	/*
	 * 通过goodsId查询指定的商品信息
	 * @see com.iotek.dao.goodsDao#queryGoodsById(int)
	 */
	@Override
	public goods queryGoodsById(int goodsId) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from goods where goodsId=?";
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,goodsId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				load(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return load(rs);
	}
	
	@Override
	/*
	 * 根据商品名查询商品
	 * @see com.iotek.dao.goodsDao#queryGoodsByName(java.lang.String)
	 */
	public List<goods> queryGoodsByName(String goodsName) throws Exception{
		//根据商品名查询商品
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<goods> list=new ArrayList<goods>();
			
			String sql="select * from goods where goodsName like '%"+goodsName+"%'";
			try {
				conn= getConnection();
			    pstmt=conn.prepareStatement(sql);
			    //pstmt.setString(1,goodsName);
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
			goods.setGoodsId(rs.getInt(1));
			goods.setGoodsName(rs.getString(2));
			goods.setTypeId(rs.getInt(3));
			goods.setGoodsDescription(rs.getString(4));
			goods.setSupplierId(rs.getInt(5));
			goods.setGoodsPrice(rs.getDouble(6));
			goods.setImg(rs.getString(7));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return goods;
	}

	/*
	 * 	//通过typeId查询商品
	 * @see com.iotek.dao.goodsDao#queryGoodsByType(java.lang.String)
	 */
	@Override
	
	public List<goods> queryGoodsByType(int typeId) throws Exception{  
		String sql="select goodsId,goodsName,img from type t,goods g where t.typeId=g.typeId and t.typeId=?";
		List<goods> list=new ArrayList<goods>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,typeId);
			rs=pstmt.executeQuery();
			while(rs.next()){
			list.add(load1(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	private goods load1(ResultSet rs) {
		goods goods=new goods();
		try{
		goods.setGoodsId(rs.getInt(1));
		goods.setGoodsName(rs.getString(2));
		goods.setImg(rs.getString(3));

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return goods;
	}
	@Override
	public boolean delGoods(goods userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}