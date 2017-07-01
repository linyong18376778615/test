package com.iotek.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.peopleDao;
import com.iotek.entity.goods;
import com.iotek.entity.people;

public class peopleDaoImpl extends BaseDao implements peopleDao {

	@Override
	public boolean savePeople(people people) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into people(peopleType,minNumber,maxNumber,morning,lunch,evening,advice)values(?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(people.getPeopleType());
		params.add(people.getMinNumber());
		params.add(people.getMaxNumber());
		params.add(people.getMorning());
		params.add(people.getLunch());
		params.add(people.getEvening());
		params.add(people.getAdvice());
	
		return this.operUpdate(sql, params);
		
	}

	@Override
	public boolean updatePeople(people people) throws Exception {
		// TODO Auto-generated method stub
		String sql="update people set peopleType=?,minNumber=?,maxNumber=?,morning=?,lunch=?,evening=?,advice=? where peopleId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(people.getPeopleType());
		params.add(people.getMinNumber());
		params.add(people.getMaxNumber());
		params.add(people.getMorning());
		params.add(people.getLunch());
		params.add(people.getEvening());
		params.add(people.getAdvice());
	
		params.add(people.getPeopleId());
		return this.operUpdate(sql, params);
		
	}

	@Override
	public boolean delPeople(int peopleId) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from people where peopleId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(peopleId);
		return this.operUpdate(sql, params);
		
	}

	@Override
	public List<people> queryAllPeople() throws Exception {
		// TODO Auto-generated method stub
		String sql="select peopleId,peopleType,minNumber,maxNumber,morning,lunch,evening,advice from people";
		List<people> pList=null;
		try {
			pList=this.operQuery(sql, null, people.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
		
	}

	@Override
	public List<people> queryPeopleByType(String peopleType) throws Exception {
		String sql="select peopleId,peopleType,minNumber,maxNumber,morning,lunch,evening,advice from people where peopleType like '%"+peopleType+"%'";
		List<people> pList=null;
		try {
			pList=this.operQuery(sql, null, people.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public List<people> queryPeopleByNumber(double number) throws Exception {
		// TODO Auto-generated method stub
		String sql="select peopleId,peopleType,minNumber,maxNumber,morning,lunch,evening,advice from people where "+number+" between minNumber and maxNumber ";
		List<people> pList=null;
		try {
			pList=this.operQuery(sql, null, people.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pList;
	}

	@Override
	public people queryPeopleById(int peopleId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select peopleId,peopleType,minNumber,maxNumber,morning,lunch,evening,advice from people where peopleId='"+peopleId+"' ";
		List<people> pList=null;
		people p=new people();
		try {
			pList=this.operQuery(sql, null, people.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		p=pList.get(0);
		return p;
	}

}
