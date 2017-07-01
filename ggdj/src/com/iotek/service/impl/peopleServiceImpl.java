package com.iotek.service.impl;

import java.util.List;

import com.iotek.entity.people;
import com.iotek.dao.peopleDao;
import com.iotek.dao.impl.peopleDaoImpl;
import com.iotek.service.peopleService;

public class peopleServiceImpl implements peopleService{
	peopleDao dao=new peopleDaoImpl();
	@Override
	public List<people> qurePeopleByNumber(double number) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryPeopleByNumber(number);
	}
	
	@Override
	public String getBodyStyle(double tall, double weight) throws Exception {
		// TODO Auto-generated method stub
		String bodyStyle=null;
		tall/=100;//身高换算成米
		double num=weight/(tall*tall);
		
		if(num<18.5){
			bodyStyle="偏瘦";
		}
		else if(18.5<=num&&num<=23.9){
			bodyStyle="标准";
		}
		else if(24<=num&&num<=27.9){
			bodyStyle="偏胖";
		}
		else{
			bodyStyle="超重";
		}
		return bodyStyle;
	}

	@Override
	public double getScore(String bodyStyle, int face, int mind, int sleep,
			int sport) throws Exception {
		// TODO Auto-generated method stub
		double score=0;
		double bodyScore=0;
		if(bodyStyle.equals("偏瘦")){
			bodyScore=25;
		}
		else if(bodyStyle.equals("标准")){
			bodyScore=50;}
		else if(bodyStyle.equals("偏胖")){
			bodyScore=75;}
		else{
			bodyScore=100;
			}
		score=bodyScore*0.2+face*0.2+mind*0.2+sleep*0.2+sport*0.2;
		
		return score;
	}
	
}
