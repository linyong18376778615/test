package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.iotek.dao.orderDao;
import com.iotek.entity.goods;
import com.iotek.entity.order;
import com.iotek.entity.trolley;
import com.iotek.entity.user;

public class orderDaoImpl extends BaseDao implements orderDao {

	@Override
	//添加订单
	public boolean saveOrder(order order) throws Exception{
		String sql="insert into oder(orderId,userId,userAddress,price,memo)values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(order.getOrderId());
		params.add(order.getUserId());
		params.add(order.getUserAddress());
		params.add(order.getPrice());
		params.add(order.getMemo());
		return this.operUpdate(sql, params);
	}

	
	@Override
	//删除订单
	public boolean delOrder(String orderId) throws Exception{
		String sql="delete from oder where orderId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(orderId);
		return this.operUpdate(sql, params);
	}

	@Override
	//查询所有订单
	public List<order> queryAllOrder() throws Exception{
		String sql="select orderId,userId,userAddress,price,memo,time from oder ";
		List<order> oList=null;
		try {
			oList=this.operQuery(sql, null, order.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oList;
	}

	/*
	 * 根据用户的ID号查询该用户的所拥有的订单
	 */
	public List<order> queryUserOrder(int userId) throws Exception{  
		String sql="select orderId,price,memo,time from oder where userId=?";
		List<order> list=new ArrayList<order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,userId);
			rs=pstmt.executeQuery();
			while(rs.next()){
			list.add(load(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	private order load(ResultSet rs) {
		order order=new order();
		try{
			order.setOrderId(rs.getString(1));
			order.setPrice(rs.getDouble(2));
			order.setMemo(rs.getString(3));
			order.setTime(rs.getTimestamp(4));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return order;
	}


	@Override
	public order queryOrder(String orderId) throws Exception {
		// 根据订单号查询订单表
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from oder where orderId=?";
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,orderId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				load1(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return load1(rs);
	}

	private order load1(ResultSet rs)  {
		order order=new order();
		try{
		order.setOrderId(rs.getString(1));
		order.setUserId(rs.getInt(2));
		order.setUserAddress(rs.getString(3));
		order.setPrice(rs.getDouble(4));
		order.setMemo(rs.getString(5));
		order.setTime(rs.getTimestamp(6));
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return order;
	}


	@Override
	//修改订单
	public boolean updateOrder(order order) throws Exception{
		// TODO Auto-generated method stub
		String sql="update oder set price=?,memo=?,userAddress=? where orderId=?";
		List<Object> params=new ArrayList<Object>();
			params.add(order.getPrice());
			params.add(order.getMemo());
			params.add(order.getUserAddress());
			params.add(order.getOrderId());
			return this.operUpdate(sql, params);
	
	}


	@Override
	//根据用户ID号，日期查询该用户当天的订单
	public List<order> queryOrderByUserDate(String date,int userId) throws Exception{
		
		String sql="select * from oder where time like '%"+date+"%' and userId=?";
		List<order> list=new ArrayList<order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,userId);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
			list.add(load1(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<order> queryOrderByDate(String date) throws Exception{
		// TODO Auto-generated method stub
		String sql="select * from oder where time like '%"+date+"%'";
		List<order> list=new ArrayList<order>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		  
			rs=pstmt.executeQuery();
			
			while(rs.next()){
			list.add(load1(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	

}
