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
import com.iotek.service.admin_goodsService;
import com.iotek.service.admin_peopleService;
import com.iotek.service.impl.admin_goodsServiceImpl;
import com.iotek.service.impl.admin_peopleServiceImpl;

/**
 * Servlet implementation class admin_peopleServlet
 */
@WebServlet("/admin_peopleServlet")
public class admin_peopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	admin_peopleService service=new admin_peopleServiceImpl();
	admin_goodsService gservice=new admin_goodsServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		
		//admin查询所有人群
		if(method.equals("0")){
		   
		   try{
			   List<people> list=service.queryAllpeople();
				request.setAttribute("list",list);
				request.getRequestDispatcher("admin_allpeople.jsp").forward(request, response);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		}
		//admin删除人群
		else if(method.equals("1")){
			
			String peopleId=request.getParameter("peopleId").trim();
			int peopleId1=Integer.parseInt(peopleId);
			try{
			service.peopleDelById(peopleId1);
			response.sendRedirect("admin_peopleServlet?method=0");
			}catch(Exception e){
				      e.printStackTrace();
			        }
		}
		//映射修改
		else if(method.equals("2")){
			String type=request.getParameter("type");
			if((type).equals("1")){//1代表添加
				
			}
			else{//0代表修改
				  try{
			         String peopleId=request.getParameter("peopleId").trim();
			         int peopleId1=Integer.parseInt(peopleId);
			         people people=service.peopleQueryById(peopleId1);
			         request.setAttribute("people",people);
			         
			          }catch(Exception e){
				            e.printStackTrace();
			                             }
				        
		       }
	
			   try{
			       List<goods> gList=gservice.queryAllGoods();
		           request.setAttribute("gList",gList);
		           }catch (Exception e){
		        	   e.printStackTrace();
		           }
			   request.setAttribute("type", type);
	           request.getRequestDispatcher("admin_mapeople.jsp").forward(request, response);
		}
		//搜索
		else if(method.equals("3")){
			try{
			String peopleType=request.getParameter("peopleType");
			//System.out.println(peopleName);
			
			List<people> list=service.peopleQueryByName(peopleType);
			request.setAttribute("list",list);
			request.getRequestDispatcher("admin_allpeople.jsp").forward(request, response);
			}catch(Exception e){
				   e.printStackTrace();
			   }
				}
			
		//添加和修改执行
		else if(method.equals("4")){
			
			String peopleType=request.getParameter("peopleType");		
			int minNumber=Integer.parseInt(request.getParameter("minNumber"));
			int maxNumber=Integer.parseInt(request.getParameter("maxNumber"));
			String morning=request.getParameter("morning");	
			String lunch=request.getParameter("lunch");	
			String evening=request.getParameter("evening");	
			String advice=request.getParameter("advice");
			
			String type=request.getParameter("type");
            	if(type.equals("0")){//0代表执行修改
            		try{
            		int peopleId=Integer.parseInt(request.getParameter("peopleId"));
        			 people people=new people(peopleId,peopleType,minNumber,maxNumber,morning,lunch,evening,advice);
            		service.updatepeople(people);
            		}catch (Exception e){
            			e.printStackTrace();
            		}
            	}
            	else{//执行添加
            		//File file = (File)request.getAttribute("image1");
            		
            		//System.out.println(file.getAbsolutePath());
            		//img=file.getAbsolutePath();
            		try{
            		 people people=new people(0,peopleType,minNumber,maxNumber,morning,lunch,evening,advice);
            		 service.savepeople(people);
            		 }catch (Exception e){
            			 e.printStackTrace();
            		 }
            	
            		
            		}
            	response.sendRedirect("admin_peopleServlet?method=0");
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
