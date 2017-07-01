package com.iotek.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.goods;
import com.iotek.entity.people;
import com.iotek.entity.tQuantity;
import com.iotek.entity.trolley;
import com.iotek.service.peopleService;
import com.iotek.service.goodsService;
import com.iotek.service.trolleyService;
import com.iotek.service.impl.peopleServiceImpl;
import com.iotek.service.impl.goodsServiceImpl;
import com.iotek.service.impl.trolleyServiceImpl;

/**
 * Servlet implementation class peopleServlet
 */
@WebServlet("/peopleServlet")
public class peopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	peopleService service=new peopleServiceImpl();
	goodsService service1=new goodsServiceImpl();
   
	people people=new people();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;chartset=utf-8");
        String type=request.getParameter("type");
        String userName=request.getParameter("userName");  
        
		/*
		 * 当type=0时，搭配对应水果套餐
		 */
		if(type.equals("0")){
			try{
			double tall=Double.valueOf(request.getParameter("tall"));
			double weight=Double.valueOf(request.getParameter("weight"));
			int face=Integer.parseInt(request.getParameter("face"));
			int mind=Integer.parseInt(request.getParameter("mind"));
			int sleep=Integer.parseInt(request.getParameter("sleep"));
			int sport=Integer.parseInt(request.getParameter("sport"));
			String bodyStyle=service.getBodyStyle(tall, weight);
			double score=service.getScore(bodyStyle, face, mind, sleep, sport);
			List<people> list=service.qurePeopleByNumber(score);
			people=list.get(0);
			List<goods> glist=service1.goodsQueryByName(people.getMorning());
			
			goods morning=glist.get(0);
			glist=service1.goodsQueryByName(people.getLunch());
			goods lunch=glist.get(0);
			glist=service1.goodsQueryByName(people.getEvening());
			goods evening=glist.get(0);
			
			request.setAttribute("people",people);
			request.setAttribute("bodyStyle", bodyStyle);
			request.setAttribute("morning",morning);
			request.setAttribute("lunch",lunch);
			request.setAttribute("evening",evening);
	        request.setAttribute("userName",userName);
			}catch (Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_result.jsp").forward(request, response);		
		}
		
		else if(type.equals("1")){
			trolleyService servicet=new trolleyServiceImpl();
			   
		
			  if(!userName.trim().equals("")){
					try{
				         trolley a=servicet.queryTrolley(userName);   //a.通过用户查找该用户的购物车Id
				         int trolleyId = a.gettrolleyId();			 			
				         int morningId =Integer.parseInt(request.getParameter("morningId")); 
						  int lunchId =Integer.parseInt(request.getParameter("lunchId")); 
						  int eveningId =Integer.parseInt(request.getParameter("eveningId"));
				
//				if(service.queryGoodsInTQuantity(trolleyId,goodsID)){
//										//b.在购物车数量表里获取对比goodsId,若存在则提示该商品已经加入购物车了
//					String message="您已经加入过购物车了，快去付款吧";
//					request.setAttribute( "message",message);
//				}		
				//else{
				tQuantity t=new tQuantity(morningId, 1, trolleyId);
				servicet.saveTQuantity(t);
				t=new tQuantity(lunchId, 1, trolleyId);
				servicet.saveTQuantity(t);
				t=new tQuantity(eveningId, 1, trolleyId);
				servicet.saveTQuantity(t);
				
				String message="已添加到购物车，快去购买吧";
				request.setAttribute( "message",message);
				
				//}
//				trolley a1=service.queryTrolley(userName);   
//				trolleyId=a1.gettrolleyId();
				List<goods> list=servicet.queryUserCart(trolleyId);
				request.setAttribute("userName",userName);
				request.setAttribute("goods", list);
				request.setAttribute("trolleyId", trolleyId);
				request.getRequestDispatcher("ggdj_cart.jsp").forward(request, response);}
					catch(Exception e){
						e.printStackTrace();
					}
				}else{
					String message="请您先登录果果，再购物哦~~";
					request.setAttribute( "message",message);
					request.getRequestDispatcher("ggdj_login.jsp").forward(request, response);
				}
		}
		 
		
		else if(type.equals("2")){//跳转填写信息
		 request.setAttribute("userName",userName);
			request.getRequestDispatcher("ggdj_detect.jsp").forward(request, response);
		}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
