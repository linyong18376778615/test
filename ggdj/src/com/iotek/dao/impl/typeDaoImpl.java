package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.typeDao;
import com.iotek.entity.goods;
import com.iotek.entity.type;

public class typeDaoImpl extends BaseDao implements typeDao {

	@Override
	public boolean saveType(type type) throws Exception{
		String sql="insert into text(name)values(?)";
		List<Object> params=new ArrayList<Object>();
		params.add(type.getTypeName());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateType(type type) throws Exception{
		String sql="update goods typeName=? where typeId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(type.getTypeName());
		params.add(type.getTypeId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delType(int typeId) throws Exception{
		String sql="delete from type where typeId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(typeId);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<type> queryAllType() throws Exception{//查询所有商品
		String sql="select typeId,typeName from type ";
		List<type> tList=new ArrayList<type>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
		    pstmt=conn.prepareStatement(sql);

			rs=pstmt.executeQuery();
			while(rs.next()){
				tList.add(load(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tList;
	}

	private type load(ResultSet rs) {
		// TODO Auto-generated method stub
		type type=new type();
		try{
			type.setTypeId(rs.getInt(1));
			type.setTypeName(rs.getString(2));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return type;
		
	}

}
