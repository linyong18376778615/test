package com.iotek.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.trolley;
import com.iotek.entity.user;
import com.iotek.service.trolleyService;
import com.iotek.service.userService;
import com.iotek.service.impl.trolleyServiceImpl;
import com.iotek.service.impl.userServiceImpl;



/**
 * Servlet implementation class userServlet
 */
@WebServlet(name = "userServlet", urlPatterns = { "/userServlet" })

public class userServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	userService service=new userServiceImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;chartset=utf-8");
		String type=request.getParameter("type");
		
		/*登录
		 * 验证用户名和密码
		 */
	if(type.equals("login")){                 
			
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		
		//System.out.print(userName+"fei");
		try{
		boolean flag=service.login(userName, userPass);
		  
		if(flag){
			//System.out.print("enen1 ");
			if(service.getType()==1)
				{
				//System.out.print("enen2 ");
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("indexServlet").forward(request, response);;
				}
			else{
				request.getRequestDispatcher("admin_index.jsp").forward(request, response);
		        }
		}
		
		else{
			String msg="用户名或密码错误,请重新登录";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("ggdj_login.jsp").forward(request, response);
		}
		 }catch(Exception e){
				e.printStackTrace();
			}
		
		}
		
		//顾客用户注册
		else if(type.equals("regist")){
			String userName=request.getParameter("userName");
			String userPass=request.getParameter("userPass");
			String userMail=request.getParameter("userMail");
			String userAddress=request.getParameter("userAddress");
			try{
			user user=new user(userName,userPass,1,userMail,userAddress);//注册用户
			service.regist(user);
			
			//为注册用户获取一个购物车
			trolley trolley=new trolley();    
			trolley.setUserName(userName);
			trolleyService serviceT=new trolleyServiceImpl();
			serviceT.saveTrolley(trolley);
			
			String message="注册成功";
			request.setAttribute( "message",message); 
			}catch(Exception e){
				e.printStackTrace();
				String message="用户名已存在，请重新注册";
				request.setAttribute( "message",message); 
				request.getRequestDispatcher("ggdj_regist.jsp").forward(request, response);
			}
			request.getRequestDispatcher("ggdj_login.jsp").forward(request, response);
		}
		
		//顾客用户个人信息查询
		else if(type.equals("query")){
			//System.out.print(type);
			String userName=request.getParameter("userName");
			//System.out.print(userName);
			try{
			if(!userName.trim().equals("")){
				user user=new user();
				user.setUserName(userName);
				user=service.query(user);
				request.setAttribute("user", user);
				request.setAttribute("userName", userName);
				request.getRequestDispatcher("ggdj_modify.jsp").forward(request, response);
			}else{
				String message="请您先登录果果，再查看个人信息哦~~";
				request.setAttribute( "message",message);
				request.getRequestDispatcher("ggdj_login.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		//顾客个人信息修改
		else if(type.equals("modify")){
			try{
			String userId=request.getParameter("userId");
			int userID=Integer.valueOf(userId);
			String userName=request.getParameter("userName");
			//String userName= new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8");
			String userPass=request.getParameter("userPass");
			String userMail=request.getParameter("userMail");
			String userAddress=request.getParameter("userAddress");
			
			user user=new user(userID,userName,userPass,1,userMail,userAddress);
			service.modify(user);
			String message="修改成功";
			request.setAttribute( "message",message);
			request.setAttribute("userName", userName);
			}catch(Exception e){
				e.printStackTrace();
			}
			request.getRequestDispatcher("indexServlet").forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
