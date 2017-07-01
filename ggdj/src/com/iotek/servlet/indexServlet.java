package com.iotek.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.iotek.service.textService;
import com.iotek.service.impl.textServiceImpl;
import com.iotek.entity.text;
/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    textService service= new textServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;chartset=utf-8");
		
		String userName=request.getParameter("userName");
		//String userName= new String(request.getParameter("userName").getBytes("ISO-8859-1"),"utf-8");
		try{
		List<text> list=service.query();
		request.setAttribute("list",list);
		//for(text a:list)
		//System.out.println(a.getContent());
		request.setAttribute("userName",userName);
		request.getRequestDispatcher("ggdj_index.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
