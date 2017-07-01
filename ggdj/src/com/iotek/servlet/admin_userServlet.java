package com.iotek.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.trolley;
import com.iotek.entity.user;
import com.iotek.entity.type;
import com.iotek.service.admin_userService;
import com.iotek.service.trolleyService;
import com.iotek.service.impl.admin_userServiceImpl;
import com.iotek.service.impl.trolleyServiceImpl;

/**
 * Servlet implementation class admin_userServlet
 */
@WebServlet("/admin_userServlet")
public class admin_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	admin_userService service=new admin_userServiceImpl();
	user user=new user();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		
		//admin查询所有用户
		if(method.equals("0")){
		   
		   try{
			   List<user> list=service.queryAlluser();
				request.setAttribute("list",list);
				//request.setAttribute("userName",userName);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
				request.getRequestDispatcher("admin_alluser.jsp").forward(request, response);
		 
		   }
		//删除用户
		else if(method.equals("1")){
			String userId=request.getParameter("userId").trim();
			int userId1=Integer.parseInt(userId);
			 try{
			service.delUser(userId1);
			 }catch(Exception e){
				   e.printStackTrace();
			   }
			response.sendRedirect("admin_userServlet?method=0");
		}
		//映射添加、修改
		else if(method.equals("2")){
			String type=request.getParameter("type");
			if(type.equals("1")){//添加映射
				
			}
			else{//修改
				try{
			String userId=request.getParameter("userId").trim();
			int userId1=Integer.parseInt(userId);
			user user=service.queryUser(userId1);
			request.setAttribute("user",user);
			}catch(Exception e){
				   e.printStackTrace();
			   }
			}
			request.setAttribute("type",type);
			request.getRequestDispatcher("admin_mauser.jsp").forward(request, response);
		}
		//搜索
		else if(method.equals("3")){
			try{
			String userName=request.getParameter("userName");
			List<user> list=service.findUser(userName);
			request.setAttribute("list",list);
			}catch(Exception e){
				   e.printStackTrace();
			   }
			request.getRequestDispatcher("admin_alluser.jsp").forward(request, response);
				}
		//添加和修改执行
		else if(method.equals("4")){
			
			String userName=request.getParameter("userName");
			String usertype=request.getParameter("userType");
			int userType=Integer.parseInt(usertype);
			String userAddress=request.getParameter("userAddress");
			String userPass=request.getParameter("userPass");
			String userMail=request.getParameter("userMail");
			String type=request.getParameter("type");
            	if(type.equals("0")){//执行修改
            		try{
            		String userId=request.getParameter("userId");
        			int userID=Integer.parseInt(userId);
        			 user user=new user(userID,userName,userPass,userType,userMail,userAddress);
            		service.modify(user);
            		}catch(Exception e){
     				   e.printStackTrace();
     			   }
            	}
            	else{//执行添加
            		try{
            		 user user=new user(0,userName,userPass,userType,userMail,userAddress);
            		 service.regist(user);
            		}catch(Exception e){
      				   e.printStackTrace();
      			   }
            		 if(userType==1){
            			    trolley trolley=new trolley();    
            				trolley.setUserName(userName);
            				trolleyService serviceT=new trolleyServiceImpl();
            				try{
            				serviceT.saveTrolley(trolley);}catch(Exception e){
               				   e.printStackTrace();
               			   }
            		 }
            	}
            		
            		response.sendRedirect("admin_userServlet?method=0");
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
