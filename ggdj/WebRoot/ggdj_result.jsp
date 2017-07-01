<%@ page language="java" import="java.util.*" import="com.iotek.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userName=request.getParameter("userName");
people people=(people)request.getAttribute("people");
String bodyStyle=request.getParameter("bodyStyle");
goods  morning=(goods)request.getAttribute("morning");
goods  lunch=(goods)request.getAttribute("lunch");
goods  evening=(goods)request.getAttribute("evening");

		
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ggdj_result</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/pintuer.css">

<!--定制主题文件 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Crops Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //定制主题文件 -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- //js -->	
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>	
   <div class="top">
     <a href="indexServlet?userName=${userName}" >返回首页(●'◡'●)</a>
		</div>         
      <div class="about"> 
		<div class="container">
			<h3 class="title">搭配结果</h3>
			
			 
			 <label style="margin-top:20px;margin-left:400px" >顾客：${ userName}</label><br/>
			 <label style="margin-top:20px;margin-left:380px" >你的体型为：${bodyStyle}</label> <br/><br/>
			 <div class="list-inline"><label style="margin-left:380px">食用建议：<%=people.getAdvice()%></label>
											     </div>
			 <label style="margin-top:20px;margin-left:50px" >根据您填写的身体情况，我们为您推荐</label>
				<div class="best-selling">
					<div class="row">
					  <div class="col-sm-12">
					  <div class="list-inline">
					  			
								</div>
                                                  
						<div class="media desk-media">
					    	<div class="media-left">
								<img src="${ morning.getImg() }" style="width:150px; height:100px;">
							</div>
								<div class="media-body">
									<h3 class="about-text-right">果名<%=morning.getGoodsName() %></h3>
				
										  <div class="list-inline">
											<li><h3 class="text-info"> 单价：<%=morning.getGoodsPrice() %>  元/kg</h3>
											    <p>商品描述：<%=morning.getGoodsDescription() %></p>

                                                  </li></div>
                                                  
												</div>
											</div>	
											
											<div class="media desk-media">
					    	<div class="media-left">
								<img src="<%=lunch.getImg() %>" style="width:150px; height:100px;">
							</div>
								<div class="media-body">
									
				
										  <div class="list-inline">
										  <h3 class="about-text-right">果名:<%=lunch.getGoodsName() %></h3>
											<h3 class="text-info"> 单价：<%=lunch.getGoodsPrice() %>  元/kg</h3>
											    <p>商品描述：<%=lunch.getGoodsDescription() %></p>

                                                  </li></div>
                                                  
												</div>
											</div>	
											
											<div class="media desk-media">
					    	<div class="media-left">
								<img src="<%=evening.getImg() %>" style="width:150px; height:100px;">
							</div>
								<div class="media-body">
									<h3 class="about-text-right">果名:<%=evening.getGoodsName() %></h3>
				
										  <div class="list-inline">
											<h3 class="text-info"> 单价：<%=evening.getGoodsPrice() %>  元/kg</h3>
											    <p>商品描述：<%=evening.getGoodsDescription() %></p>

                                                  </li></div>
                                                  
												</div>
											</div>	
											
											
											</br>
											
											     		</div>
	</div>
											     
											    <form action="peopleServlet?type=1&userName=${userName }" method="post">
         										 <input type="hidden"  name="morningId" value="${morning.getGoodsId() }"   />
         										 <input type="hidden"  name="lunchId" value="${lunch.getGoodsId() }"  />
         										 <input type="hidden"  name="eveningId" value="${evening.getGoodsId() }"/>  
         										<div class="contact-form" style="text-align:center;">
					    											<input type="submit" value="一键加入购物车">
				   																		</div>
         										
         										 
									    	
									      </form>
									      </div>
									    </div>
									</div>
				<script src="js/lightbox-plus-jquery.min.js"> </script>
							
</body>
</html>