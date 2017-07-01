package com.iotek.dao;
import java.util.List;
import com.iotek.entity.people;
public interface peopleDao {
	public boolean savePeople(people people) throws Exception;//添加人群
	public boolean updatePeople(people people) throws Exception;//更新人群
	public boolean delPeople(int peopleId) throws Exception;//删除人群
	public List<people> queryAllPeople() throws Exception;//查询所有人群
	public List<people> queryPeopleByType(String peopleType) throws Exception;//通过人群名查找指定人群
	public people queryPeopleById(int peopleId) throws Exception;//通过人群ID查找指定人群
	public List<people> queryPeopleByNumber(double number) throws Exception;//通过分值查找指定人群
}
