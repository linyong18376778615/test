package com.iotek.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.goods;
import com.iotek.entity.oQuantity;
import com.iotek.entity.order;
import com.iotek.entity.tQuantity;
import com.iotek.entity.text;
import com.iotek.entity.trolley;
import com.iotek.entity.user;
import com.iotek.service.goodsService;
import com.iotek.service.userService;
import com.iotek.service.impl.goodsServiceImpl;
import com.iotek.service.impl.userServiceImpl;

/**
 * Servlet implementation class goodsServlet
 */
@WebServlet("/goodsServlet")
public class goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	goodsService service=new goodsServiceImpl();
	userService service1=new userServiceImpl();
   
	goods goods=new goods();
	int trolleyId;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;chartset=utf-8");
        String type=request.getParameter("type");
        String userName=request.getParameter("userName");      
		/*
		 * 当type=0时，查询所有商品
		 */
		if(type.equals("0")){
			try{
			List<goods> list=service.queryAllGoods();
			request.setAttribute("list",list);
			request.setAttribute("userName",userName);
			}catch (Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_allgoods.jsp").forward(request, response);		
		}
		
		/*
		 * 当type=1时，查询单个商品详情
		 */
		else if(type.equals("1")){  
			try{
		         String goodsID=request.getParameter("goodsId");
		         int goodsId=Integer.valueOf(goodsID);
		         //System.out.println(goodsId);
		         goods=service.goodsQueryById(goodsId);
		        request.setAttribute("goods",goods);
		        request.setAttribute("userName",userName);
			//System.out.println(goods.getGoodsName());
			}catch (Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_goodsInfo.jsp").forward(request, response);
		}
		

		/*
		 * type=8时，查看分类商品
		 */
		else if(type.equals("8")){
			try{
			String typeID=request.getParameter("typeId");
			int typeId=Integer.valueOf(typeID);
			List<goods> list=service.queryGoodsByType(typeId);
			request.setAttribute("userName",userName);
			request.setAttribute("list", list);
			}catch (Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_allgoods.jsp").forward(request, response);
			
		}
		/*
		 * type=9时，搜索商品名
		 */
		else if(type.equals("9")){
			try{
			String selectName=request.getParameter("selectName");
			List<goods> list=service.goodsQueryByName(selectName);
			request.setAttribute("userName",userName);
			request.setAttribute("list", list);
			}catch (Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_allgoods.jsp").forward(request, response);
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
