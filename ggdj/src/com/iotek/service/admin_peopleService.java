package com.iotek.service;

import java.util.List;

import com.iotek.entity.people;



public interface admin_peopleService {
	public boolean peopleDelById(int peopleId) throws Exception;//根据人群ID删除人群
	public boolean updatepeople(people people) throws Exception;//修改人群信息
	public boolean savepeople(people people)throws Exception;//添加人群
	public List<people> queryAllpeople() throws Exception;//查询所有人群
	public people peopleQueryById(int peopleId) throws Exception;//根据人群查询人群Id
	public List<people> peopleQueryByName(String peopleType) throws Exception;//根据人群名查询人群

}
