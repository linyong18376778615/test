package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.textDao;
import com.iotek.entity.text;
import com.iotek.entity.user;

public class textDaoImpl extends BaseDao implements textDao {

	@Override
	public boolean saveText(text text) throws Exception{
		String sql="insert into text(content,img)values(?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(text.getContent());
		params.add(text.getImg());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateText(text text) throws Exception{
		String sql="update text set content=?,img=? where textId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(text.getContent());
		params.add(text.getImg());
		params.add(text.getTextId());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delText(int textId) throws Exception{
		String sql="delete from text where textId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(textId);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<text> queryText() throws Exception{
		String sql="select * from text ";
		List<text> list=new ArrayList<text>();
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
	
		
		private text load(ResultSet rs) {
			text text=new text();
			
			try{
			text.setTextId(rs.getInt(1));
			text.setContent(rs.getString(2));
			text.setImg(rs.getString(3));
			text.setMemo(rs.getString(4));
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return text;
		}

	@Override
	public List<text> queryImgById(int textId) throws Exception{
		String sql="select img from text where textId=?";
		List<text> List=null;
		List<Object> params=new ArrayList<Object>();
		params.add(textId);
		try {
			List=this.operQuery(sql, params, text.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List;
	}

	@Override//根据公告内容模糊查询
	public List<text> findtext(String textContent) throws Exception{
		// TODO Auto-generated method stub
		String sql="select * from text where content like '%"+textContent+"%' ";
		List<text> list=new ArrayList<text>();
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

	@Override
	public text queryText(int textId) throws Exception{
		// TODO Auto-generated method stub
		String sql="select * from text where textId="+textId+"";
		text text=new text();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn= getConnection();
			pstmt=conn.prepareStatement(sql);	   
			rs=pstmt.executeQuery();
			if(rs.next()){
				text=load(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return text;
	}

}
