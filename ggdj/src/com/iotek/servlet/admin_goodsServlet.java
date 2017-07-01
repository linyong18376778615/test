package com.iotek.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iotek.entity.goods;
import com.iotek.entity.type;
import com.iotek.service.admin_goodsService;
import com.iotek.service.impl.admin_goodsServiceImpl;

/**
 * Servlet implementation class admin_goodsServlet
 */
@WebServlet("/admin_goodsServlet")
public class admin_goodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	admin_goodsService service=new admin_goodsServiceImpl();
	goods goods=new goods();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		
		//admin查询所有商品
		if(method.equals("0")){
		   
		   try{
			   List<goods> list=service.queryAllGoods();
				request.setAttribute("list",list);
				//request.setAttribute("userName",userName);
				request.getRequestDispatcher("admin_allgoods.jsp").forward(request, response);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		}
		//admin删除商品
		else if(method.equals("1")){
			
			String goodsId=request.getParameter("goodsId").trim();
			int goodsId1=Integer.parseInt(goodsId);
			try{
			service.goodsDelById(goodsId1);
			response.sendRedirect("admin_goodsServlet?method=0");
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
			         String goodsId=request.getParameter("goodsId").trim();
			         int goodsId1=Integer.parseInt(goodsId);
			         goods goods=service.goodsQueryById(goodsId1);
			         request.setAttribute("goods",goods);
			         
			          }catch(Exception e){
				            e.printStackTrace();
			                             }
				        
		       }
			   System.out.println(type);
			   try{
			       List<type> tList=service.queryAllType();
		           request.setAttribute("tList",tList);
		           }catch (Exception e){
		        	   e.printStackTrace();
		           }
			   request.setAttribute("type", type);
	           request.getRequestDispatcher("admin_magoods.jsp").forward(request, response);
		}
		//搜索
		else if(method.equals("3")){
			try{
			String goodsName=request.getParameter("goodsName");
			//System.out.println(goodsName);
			
			List<goods> list=service.goodsQueryByName(goodsName);
			request.setAttribute("list",list);
			request.getRequestDispatcher("admin_allgoods.jsp").forward(request, response);
			}catch(Exception e){
				   e.printStackTrace();
			   }
				}
			
		//添加和修改执行
		else if(method.equals("4")){
			
			String goodsName=request.getParameter("goodsName");
			String img=request.getParameter("img");			
			String typeId=request.getParameter("typeId");
			int typeID=Integer.parseInt(typeId);
			String goodsDescription=request.getParameter("goodsDescription");
			String supplierId=request.getParameter("supplierId");
			int supplierID=Integer.parseInt(supplierId);
			String goodsPrice=request.getParameter("goodsPrice");
			double price=Double.valueOf(goodsPrice);
			String type=request.getParameter("type");
			System.out.println(type);
            	if(type.equals("0")){//0代表执行修改
            		try{
            		String goodsId=request.getParameter("goodsId");
        			int goodsID=Integer.parseInt(goodsId);
        			
        			 goods goods=new goods(goodsID,goodsName,typeID,goodsDescription,supplierID,price,img);
            		service.updateGoods(goods);
            		}catch (Exception e){
            			e.printStackTrace();
            		}
            	}
            	else{//执行添加
            		//File file = (File)request.getAttribute("image1");
            		
            		//System.out.println(file.getAbsolutePath());
            		//img=file.getAbsolutePath();
            		try{
            		 goods goods=new goods(0,goodsName,typeID,goodsDescription,supplierID,price,img);
            		 service.saveGoods(goods);
            		 }catch (Exception e){
            			 e.printStackTrace();
            		 }
            	
            		
            		}
            	response.sendRedirect("admin_goodsServlet?method=0");
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
