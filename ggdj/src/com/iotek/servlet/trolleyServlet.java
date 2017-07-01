package com.iotek.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.goods;
import com.iotek.entity.order;
import com.iotek.entity.tQuantity;
import com.iotek.entity.trolley;
import com.iotek.entity.user;
import com.iotek.service.goodsService;
import com.iotek.service.trolleyService;
import com.iotek.service.userService;
import com.iotek.service.impl.goodsServiceImpl;
import com.iotek.service.impl.trolleyServiceImpl;
import com.iotek.service.impl.userServiceImpl;



/*
 * 购物车
 */
@WebServlet("/trolleyServlet")
public class trolleyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int trolleyId;  
	trolleyService service=new trolleyServiceImpl();
	userService service1=new userServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;chartset=utf-8");
        String type=request.getParameter("type");
        String userName=request.getParameter("userName"); 
        goods goods=new goods();
        
        /*
		 * 当type=1时，往购物车内添加商品
		 */
        if(type.equals("1")){	
			if(!userName.trim().equals("")){
				try{
			         trolley a=service.queryTrolley(userName);   //a.通过用户查找该用户的购物车Id
			         trolleyId=a.gettrolleyId();			 			
			         String goodsId=request.getParameter("goodsId");
			         int goodsID=Integer.valueOf(goodsId);
			
			if(service.queryGoodsInTQuantity(trolleyId,goodsID)){
									//b.在购物车数量表里获取对比goodsId,若存在则提示该商品已经加入购物车了
				String message="您已经加入过购物车了，快去付款吧";
				request.setAttribute( "message",message);
			}		
			else{
			tQuantity t=new tQuantity(goodsID, 1, trolleyId);
			
			service.saveTQuantity(t);
			
			String message="已添加到购物车，快去购买吧";
			request.setAttribute( "message",message);
			
			}
//			trolley a1=service.queryTrolley(userName);   
//			trolleyId=a1.gettrolleyId();
			List<goods> list=service.queryUserCart(trolleyId);
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
        /*
		 *type=2时，查看某用户的购物车列表
		 */
		else if(type.equals("2")){ 
			if(!userName.trim().equals("")){
				try{
			trolley a=service.queryTrolley(userName);    //首先在购物车表的查找该用户的购物车Id
			trolleyId=a.gettrolleyId();
			List<goods> list=service.queryUserCart(trolleyId);//查询该用户的购物车
			request.setAttribute("userName",userName);
			request.setAttribute("goods", list);
			request.setAttribute("trolleyId", trolleyId);
			request.getRequestDispatcher("ggdj_cart.jsp").forward(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		    }else{
				String message="请您先登录果果，再购物哦~~";
				request.setAttribute( "message",message);
				request.getRequestDispatcher("ggdj_login.jsp").forward(request, response);
			}
			
		}
		
		/*
		 *type=3时，删除购物车列表的某项商品
		 */
		else if (type.equals("3")){
			try{
			String goodsId=request.getParameter("goodsId");
			int goodsID=Integer.valueOf(goodsId);
			service.delTQuantity(goodsID,trolleyId);
			
			trolley a=service.queryTrolley(userName);
			System.out.println(a);
			trolleyId=a.gettrolleyId();
			List<goods> list=service.queryUserCart(trolleyId);//查询该用户的购物车
			request.setAttribute("userName",userName);
			request.setAttribute("goods", list);
			request.setAttribute("trolleyId", trolleyId);
			request.getRequestDispatcher("ggdj_cart.jsp").forward(request, response);
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
				
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
