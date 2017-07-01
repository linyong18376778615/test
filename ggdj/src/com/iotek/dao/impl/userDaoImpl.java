package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.userDao;
import com.iotek.entity.order;
import com.iotek.entity.user;

public class userDaoImpl extends BaseDao implements userDao {
	@Override
	public boolean saveUser(user user) throws Exception{
		String sql="insert into user(userName,userPass,userType,userMail,userAddress)values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUserName());
		params.add(user.getUserPass());
		params.add(user.getUserType());
		params.add(user.getUserMail());
		params.add(user.getUserAddress());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateUser(user user) throws Exception{
		String sql="update user set userName=?,userPass=?,userType=?,userMail=?,userAddress=? where userId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUserName());
		params.add(user.getUserPass());
		params.add(user.getUserType());
		params.add(user.getUserMail());
		params.add(user.getUserAddress());
		params.add(user.getUserId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delUser(int userId) throws Exception{
		String sql="delete from user where userId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(userId);
		return this.operUpdate(sql, params);
	}

	
	@Override
	public user queryUser1(user user) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from user where userName=?";
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1,user.getUserName());
			rs=pstmt.executeQuery();
			if(rs.next()){
				load(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return load(rs);
	}
	private user load(ResultSet rs) {
		user user=new user();
		try{
		user.setUserId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setUserPass(rs.getString(3));
		user.setUserType(rs.getInt(4));
		user.setUserMail(rs.getString(5));
		user.setUserAddress(rs.getString(6));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<user> queryAlluser() throws Exception{
		// TODO Auto-generated method stub
		String sql="select userId,userName,userPass,userType,userMail,userAddress from user ";
		List<user> uList=null;
		try {
			uList=this.operQuery(sql, null, user.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;
		
	}

	@Override
	public user queryUser(int userId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from user where userId=?";
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setInt(1,userId);
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
	public List<user> findUser(String userName) throws Exception{
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<user> list=new ArrayList<user>();
		String sql="select * from user where userName like '%"+userName+"%'";
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

