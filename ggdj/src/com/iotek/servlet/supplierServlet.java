package com.iotek.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iotek.entity.supplier;
import com.iotek.service.supplierService;
import com.iotek.service.impl.supplierServiceImpl;

public class supplierServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     supplierService service =new supplierServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			   String userName=request.getParameter("userName");
			   List<supplier> list=service.queryAllSupplier();
			   request.setAttribute("list",list);
			   request.setAttribute("userName",userName);
			   request.getRequestDispatcher("ggdj_supplier.jsp").forward(request, response);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doGet(request,response);
		
	}

}
