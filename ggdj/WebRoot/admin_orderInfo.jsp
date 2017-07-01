<%@ page language="java" import="java.util.*"  import="com.iotek.entity.oQuantity"  import="com.iotek.entity.order"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<oQuantity> list=(List<oQuantity>)request.getAttribute("list");
String userName=request.getParameter("userName");
order b=(order)request.getAttribute("order");
%>
<%@ taglib prefix="c" uri="/WEB-INF/tag/c-rt.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Short Codes</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="css/admin.css">
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Crops Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- //js -->	
<!-- start-smoth-scrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>	

			 <div class="panel-head"><strong class="icon-reorder">订单详情</strong></div>
			 <label style="margin-top:20px;margin-left:400px" ><li class="text-info"></li>顾客：${ userName}</label>
				<div class="best-selling">
					<div class="row">
					  <div class="col-sm-12">
					  <div class="list-inline">
					  			<label style="margin-top:20px;margin-left:180px" ><li class="text-info">果果订单号：<%=b.getOrderId() %></li></label>
					  			<label style="margin-left:440px"><li class="text-info">创建日期：<%=b.getTime() %></li></label>
								</br>
								<label style="margin-top:20px;margin-left:180px" ><li class="text-info">收货地址：<%=b.getUserAddress() %></li></label>
								<label style="margin-left:500px"><li class="text-info">备注：<%=b.getMemo()%></li></label>
								
								</div>
                                                  
					  
					  
					  	<%for(int i=0;i<list.size();i++){
					  		oQuantity a=list.get(i); %>
						<div class="media desk-media">
					    	<div class="media-left">
								<img src="<%=a.getImg() %>" style="width:150px; height:100px;">
							</div>
								<div class="media-body">
									<h3 class="about-text-right">甜甜的<%=a.getGoodsName() %>呀~</h3>
				
										  <div class="list-inline">
											<li><h3 class="text-info"> 单价：<%=a.getGoodsPrice() %>  元/kg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量:<%=a.getQuantity() %>  kg&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>
											     <h3 class="about-text-left">小计：<%=a.getGoodsPrice()*a.getQuantity() %>元</h3>

                                                  </li></div>
                                                  
												</div>
											</div>	
											<%} %>
											</br><label style="margin-left:800px"><h3 >合计：<%=b.getPrice() %>元</h3></label></br></br>
									    	<!-- div class="add-cart"><a class="btn btn-default"  herf="#">确认收货</a></div-->
									      </div>
									    </div>
									</div>
				<script src="js/lightbox-plus-jquery.min.js"> </script>
							
</body>
</html>
