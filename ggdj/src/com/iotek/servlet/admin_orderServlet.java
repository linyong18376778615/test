package com.iotek.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.service.admin_orderService;
import com.iotek.service.admin_userService;
import com.iotek.service.goodsService;
import com.iotek.service.orderService;
import com.iotek.service.impl.admin_orderServiceImpl;
import com.iotek.service.impl.admin_userServiceImpl;
import com.iotek.service.impl.goodsServiceImpl;
import com.iotek.service.impl.orderServiceImpl;
import com.iotek.entity.oQuantity;
import com.iotek.entity.order;
import com.iotek.entity.user;
/**
 * Servlet implementation class admin_orderServlet
 */
@WebServlet("/admin_orderServlet")
public class admin_orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	admin_orderService service=new admin_orderServiceImpl();
	order order=new order();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		System.out.println(method);
		if(method.equals("0")){//查看所有订单
			try{
			List<order> list=service.qureAllOrder();
			request.setAttribute("list", list);}
			catch(Exception e){
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("admin_allorder.jsp").forward(request, response);	
		}
		else if(method.equals("1")){//删除订单
			String orderId=request.getParameter("orderId");
			try{
			if(service.delOrder(orderId))
			{
				
			}}catch(Exception e){e.printStackTrace();}
			response.sendRedirect("admin_orderServlet?method=0");
		}
		else if(method.equals("2")){//修改订映射
			String orderId=request.getParameter("orderId");
			try{
			order order=service.orderQueryById(orderId);
			request.setAttribute("order", order);
			}catch(Exception e){e.printStackTrace();}
			request.getRequestDispatcher("admin_maorder.jsp").forward(request, response);	
		}
		else if(method.equals("3")){//搜索 
			String date=request.getParameter("date");
			System.out.println(date);
			try{
			List<order> list=service.qureOrder(date);
			request.setAttribute("list", list);
			}catch(Exception e){e.printStackTrace();}
			request.getRequestDispatcher("admin_allorder.jsp").forward(request, response);
			
		}
		else if(method.equals("4")){//执行修改
			String orderId=request.getParameter("orderId");
			String userAddress=request.getParameter("userAddress");
			String Memo=request.getParameter("memo");
			String price=request.getParameter("price");
			double Price=Double.valueOf(price);
			order order=new order();
			order.setMemo(Memo);
			order.setOrderId(orderId);
			order.setPrice(Price);
			order.setUserAddress(userAddress);
			try{
			service.modifyOrder(order);
			}catch(Exception e){e.printStackTrace();}
			response.sendRedirect("admin_orderServlet?method=0");
		}
		else if(method.equals("5")){//查看订单详情
			orderService service1=new orderServiceImpl();
			admin_userService service2=new admin_userServiceImpl();
			int userId=Integer.valueOf(request.getParameter("userId"));
			System.out.println("haha"+userId);
			try{
			user user=service2.queryUser(userId);
			String userName=user.getUserName();
			String orderId=request.getParameter("orderId");
			List<oQuantity> list=service1.queryUserOrderInfo(orderId);
			order order=service.orderQueryById(orderId);
			request.setAttribute("order", order);
			request.setAttribute("list", list);
			request.setAttribute("userName", userName);
			}catch(Exception e){e.printStackTrace();}
			request.getRequestDispatcher("admin_orderInfo.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
