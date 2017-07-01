package com.iotek.service;
import java.util.List;
import com.iotek.entity.people;

public interface peopleService {
	public double getScore(String bodyStyle,int face,int mind,int sleep,int sport) throws Exception;
	public String getBodyStyle(double tall,double weight)throws Exception;
	public List<people> qurePeopleByNumber(double number) throws Exception;
}
