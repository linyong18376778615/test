package com.iotek.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.text;
import com.iotek.entity.type;
import com.iotek.service.admin_textService;
import com.iotek.service.textService;
import com.iotek.service.impl.admin_textServiceImpl;
import com.iotek.service.impl.textServiceImpl;

/**
 * Servlet implementation class admin_textServlet
 */
@WebServlet("/admin_textServlet")
public class admin_textServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	admin_textService service=new admin_textServiceImpl();
	text text=new text();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		
		//admin查询所有公告
		if(method.equals("0")){
		   
		   try{
			   List<text> list=service.queryAlltext();
				request.setAttribute("list",list);
				//request.setAttribute("userName",userName);
				
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   request.getRequestDispatcher("admin_alltext.jsp").forward(request, response);
		}
		//删除公告
		else if(method.equals("1")){
			try{
			String textId=request.getParameter("textId").trim();
			int textId1=Integer.parseInt(textId);
			service.deltext(textId1);
			 }catch(Exception e){
				   e.printStackTrace();
			   }
			response.sendRedirect("admin_textServlet?method=0");
		}
		//映射修改
		else if(method.equals("2")){
			String type=request.getParameter("type");
			if((type).equals("1")){//添加
				
			}
			else{//修改
				try{
			String textId=request.getParameter("textId").trim();
			int textId1=Integer.parseInt(textId);
			text text=service.querytext(textId1);
			request.setAttribute("text",text);		
			type="0";
				 }catch(Exception e){
					   e.printStackTrace();
				   }
			}
			request.setAttribute("type", type);
			request.getRequestDispatcher("admin_matext.jsp").forward(request, response);
		}
		//搜索
		else if(method.equals("3")){
			try{
			String textContent=request.getParameter("textContent");
			List<text> list=service.findtext(textContent);
			request.setAttribute("list",list);
			}catch(Exception e){
				   e.printStackTrace();
			   }
			request.getRequestDispatcher("admin_alltext.jsp").forward(request, response);
				}
		//添加和修改执行
		else if(method.equals("4")){
			
			String img=request.getParameter("img");
			
			String content=request.getParameter("content");
			String type=request.getParameter("type");

            	if(type.equals("0")){//执行修改
            		try{
            		String textId=request.getParameter("textId");
            		int textID=Integer.parseInt(textId);
        			 text text=new text(textID,content,img);
        			 
            		service.modify(text);
            		}catch(Exception e){
     				   e.printStackTrace();
     			   }
            	}
            		
            	else{//执行添加
            		try{
            		 text text=new text(content,img);
            		 service.addText(text);
            		 }catch(Exception e){
       				   e.printStackTrace();
       			   }
            	}//执行添加
            		
            		
            		response.sendRedirect("admin_textServlet?method=0");
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
