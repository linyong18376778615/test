package com.iotek.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.oQuantity;
import com.iotek.entity.order;
import com.iotek.entity.user;
import com.iotek.service.orderService;
import com.iotek.service.trolleyService;
import com.iotek.service.userService;
import com.iotek.service.impl.orderServiceImpl;
import com.iotek.service.impl.trolleyServiceImpl;
import com.iotek.service.impl.userServiceImpl;

/**
 * Servlet implementation class orderServlet
 */
@WebServlet("/orderServlet")
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    orderService service=new orderServiceImpl();
    userService service1=new userServiceImpl();
    trolleyService service2=new trolleyServiceImpl();
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type=request.getParameter("type");
	    String userName=request.getParameter("userName"); 
		/*
		 * 当type=1时，按日期搜索当天该用户的订单
		 */
	    if(type.equals("1")){
	    	try{
	    	    //根据获取到的用户名查询用户ID号
				user user=new user();
				user.setUserName(userName);
				user=service1.query(user);
				int userId=user.getUserId();
				//System.out.println("用户Id"+userId);
				String date=request.getParameter("date"); 
				List<order> list=service.queryOrderByDate(date, userId);
				request.setAttribute("list",list );
				request.setAttribute("userName",userName);
	    	   }catch (Exception e){
				e.printStackTrace();
			   }
				request.getRequestDispatcher("ggdj_allorders.jsp").forward(request, response);
	     }
	    
	    /*
		 *type=2时，生成订单
		 */
		else if(type.equals("2")){	
			
			String trolleyID=request.getParameter("trolleyId");
			int trolleyId=Integer.valueOf(trolleyID);
			
			 String[] num=request.getParameterValues("num");//从购物车商品获取数量数组
			 int[] Num=service.StringToInt(num); 
			 
			 String[] goodsID=request.getParameterValues("checkbox");//获取购物车商品id
			 int[] goodsId=service.StringToInt(goodsID); 

			 
			 String price3=request.getParameter("cartTotalPrice");//购物车获取总价格
			// System.out.println("价钱1"+price3);
			 double Price3=Double.valueOf(price3);
			// System.out.println("价钱2"+Price3);
			 
			 /* 1.由用户名查询用户Id
			  * 2.由用户Id查出用户信息
			  * 3.根据用户信息及接收到的购物车信息，创建订单号生成订单
			  */
			 try{
			    user user=new user();
				user.setUserName(userName);
				user=service1.query(user);
				int userId=user.getUserId();
				//System.out.println("用户Id"+userId); 
				String userAddress=user.getUserAddress();
			 
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		 	 String orderId=dateFormat.format(new Date());
			 order order=new order(orderId,userId, userAddress, Price3);
				
			 service.saveOrder(order); 
				//System.out.println("订单号"+orderId);
				//System.out.println("购物车号"+trolleyId);
				 
				for(int i=0;i<Num.length;i++){					//循环遍历，将购买的商品及其数量插入订单数量表中
					oQuantity oQuantity=new oQuantity(goodsId[i],Num[i],orderId);
					//System.out.println(oQuantity);
					
					service.saveOQuantity(oQuantity);//插入购买商品
					service2.delTQuantity(goodsId[i], trolleyId);//将购买的商品从购物车里删除	
				}
				
				List<oQuantity> list=service.queryUserOrderInfo(orderId);//查询刚刚生成的订单
				order order1=service.queryOrder(orderId);
				System.out.print(order1);
				request.setAttribute("order", order1);
				request.setAttribute("userName",userName);
				request.setAttribute("list", list);
			 }catch (Exception e){
					e.printStackTrace();
				   }
			 
			 
				request.getRequestDispatcher("ggdj_orderInfo.jsp").forward(request, response);
			 
		}

	    
	    /*
		 * type=3时，查询该用户的所有订单
		 */
		else if(type.equals("3")){

			if(!userName.trim().equals("")){
			user user=new user();
			user.setUserName(userName);
			try{
			user=service1.query(user);
			int userId=user.getUserId();
			//System.out.println("用户Id"+userId); 
			
			
			List<order> list=service.queryUserOrder(userId);
//			for (order a:list ) {  
//	            System.out.println(a); 
//			}
			request.setAttribute("list",list);
			request.setAttribute("userName",userName);
			}catch(Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_allorders.jsp").forward(request, response);	
			
		    }else{
				String message="请您先登录果果，再购物哦~~";
				request.setAttribute( "message",message);
				request.getRequestDispatcher("ggdj_login.jsp").forward(request, response);
			}
		}
	    
	    /*
		 * type=4时，根据订单号查看订单详情
		 */
		else if(type.equals("4")){
			String orderId=request.getParameter("orderId");
			//System.out.println("订单号"+orderId);
			try{
			List<oQuantity> list=service.queryUserOrderInfo(orderId);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i));
//			}
			order order=service.queryOrder(orderId);
			//System.out.print(order);
			request.setAttribute("order", order);
			request.setAttribute("userName",userName);
			request.setAttribute("list", list);
			}catch (Exception e){
				e.printStackTrace();
			}
				
			request.getRequestDispatcher("ggdj_orderInfo.jsp").forward(request, response);	
		}
	    /*
		 * type=5时，删除订单
		 */
		else if(type.equals("5")){
			String orderId=request.getParameter("orderId");
			try{
			service.delOrder(orderId);
			//System.out.print("用户名"+userName);
			user user=new user();
			user.setUserName(userName);
			user=service1.query(user);
			int userId=user.getUserId();
			List<order> list=service.queryUserOrder(userId);
			request.setAttribute("list",list);
			request.setAttribute("userName",userName);
			String message="订单删除成功！！！！！";
			request.setAttribute( "message",message);
			}catch(Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("ggdj_allorders.jsp").forward(request, response);	
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    doGet(request,response);
	}

}
