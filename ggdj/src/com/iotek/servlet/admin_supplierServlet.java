package com.iotek.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iotek.entity.goods;
import com.iotek.entity.supplier;
import com.iotek.entity.type;
import com.iotek.service.admin_supplierService;
import com.iotek.service.impl.admin_supplierServiceImpl;

public class admin_supplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	admin_supplierService service=new admin_supplierServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    
		    String method=request.getParameter("method");
		    
		    //查询所有供应商
		    if(method.equals("0")){ 
				   try{
					   List<supplier> list=service.queryAllSupplier();
						request.setAttribute("list",list);
						request.getRequestDispatcher("admin_allsupplier.jsp").forward(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
				}
		  //admin删除供应商
			else if(method.equals("1")){
				try{
				String supplierID=request.getParameter("supplierId").trim();
				int supplierId=Integer.parseInt(supplierID);
				service.delSupplier(supplierId);
				}catch(Exception e){
					   e.printStackTrace();
				   }
				response.sendRedirect("admin_supplierServlet?method=0");
			}
		    
		  //映射修改
			else if(method.equals("2")){
				String type=request.getParameter("type");
				if((type).equals("1")){//执行添加
					
					
				}
				else{//执行修改
					try{
				         String supplierID=request.getParameter("supplierId").trim();
				         int supplierId=Integer.parseInt(supplierID);
				         supplier supplier=service.querySupplierById(supplierId);
				         request.setAttribute("supplier",supplier);
					}catch(Exception e){
						   e.printStackTrace();
				}
				
				
			}
				request.setAttribute("type", type);
				request.getRequestDispatcher("admin_masupplier.jsp").forward(request, response);
			}
		    
		  //搜索
			else if(method.equals("3")){
				try{
				String supplierName=request.getParameter("supplierName");
				System.out.println(supplierName);
				List<supplier> list=service.querySupplierByName(supplierName);
				request.setAttribute("list",list);
				}catch(Exception e){
					   e.printStackTrace();
				   }
				request.getRequestDispatcher("admin_allsupplier.jsp").forward(request, response);
					}
		    
			else if(method.equals("4")){
				//执行添加、修改
				String supplierName=request.getParameter("supplierName");
				String suImg=request.getParameter("suImg");			
				String supplierAddress=request.getParameter("supplierAddress");
				String suFruit=request.getParameter("suFruit");
				String suTel=request.getParameter("suTel");
				String type=request.getParameter("type");
				System.out.println(type);
	            	if(type.equals("0")){//执行修改
	            		try{
	            		String supplierID=request.getParameter("supplierId");
	        			int supplierId=Integer.parseInt(supplierID);
	        			
	        	        supplier supplier=new supplier(supplierId,supplierName,supplierAddress,suImg,suTel,suFruit);
	            		service.updateSupplier(supplier);
	            		}catch(Exception e){
	 					   e.printStackTrace();
	 				   }
	            	}
	            	else{//执行添加
	            		try{
	            		 supplier supplier=new supplier(0,supplierName,supplierAddress,suImg,suTel,suFruit);
	            		 service.saveSupplier(supplier);
	            		 }catch(Exception e){
		 					   e.printStackTrace();
		 				   }
	            	}
	            		
	            		response.sendRedirect("admin_supplierServlet?method=0");
					}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		       doGet(request,response);
	}

}
