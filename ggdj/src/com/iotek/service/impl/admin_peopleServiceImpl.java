package com.iotek.service.impl;

import java.util.List;

import com.iotek.dao.peopleDao;
import com.iotek.dao.impl.peopleDaoImpl;
import com.iotek.entity.people;
import com.iotek.service.admin_peopleService;


public class admin_peopleServiceImpl implements admin_peopleService {
	peopleDao dao=new peopleDaoImpl();
	@Override
	public boolean peopleDelById(int peopleId) throws Exception {
		// TODO Auto-generated method stub
		return dao.delPeople(peopleId);
	}

	@Override
	public boolean updatepeople(people people) throws Exception {
		// TODO Auto-generated method stub
		return dao.updatePeople(people);
	}

	@Override
	public boolean savepeople(people people) throws Exception {
		// TODO Auto-generated method stub
		return dao.savePeople(people);
	}

	@Override
	public List<people> queryAllpeople() throws Exception {
		// TODO Auto-generated method stub
		return dao.queryAllPeople();
	}

	@Override
	public List<people> peopleQueryByName(String peopleType) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryPeopleByType(peopleType);
	}

	@Override
	public people peopleQueryById(int peopleId) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryPeopleById(peopleId);
	}

}
