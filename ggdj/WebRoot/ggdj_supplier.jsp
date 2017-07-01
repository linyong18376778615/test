<%@ page language="java" import="java.util.*" import="com.iotek.entity.supplier" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<supplier> list=(List<supplier>)request.getAttribute("list");
String userName=(String)request.getParameter("userName");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ggdj_supplier</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="css/lightbox.css">
<!-- 定制主题文件  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Crops Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //定制主题文件  -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- //js -->	
</head>
<body>
	<!--头部-->
	<div class="logo">
		<div class="container">
			<div class="logo-info">
				<a href="indexServlet?userName=${userName}">
					<h1>果果到家</h1>	
					<span class="glyphicon glyphicon-grain" aria-hidden="true"></span>
				</a>
			</div>
		</div>	
	</div>
	<!--//头部-->		
	<!--导航栏-->
	<div class="top-nav">
		<nav class="navbar navbar-default">
			<div class="container">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">Menu						
				</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="hvr-bounce-to-bottom active"><a href="indexServlet?&userName=${userName}">家园</a></li>
					<li class="hvr-bounce-to-bottom"><a href="goodsServlet?type=0&userName=${userName}">果果集市</a></li>
					<li><a href="#" class="dropdown-toggle hvr-bounce-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">你想要的果<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a class="hvr-bounce-to-bottom" href="goodsServlet?type=8&typeId=1&userName=${userName}">健身最爱</a></li>
							<li><a class="hvr-bounce-to-bottom" href="goodsServlet?type=8&typeId=2&userName=${userName}">美容养颜</a></li>
							<li><a class="hvr-bounce-to-bottom" href="goodsServlet?type=8&typeId=3&userName=${userName}">瘦身纤体</a></li>              
						</ul>
					</li>
					<li><a href="#" class="dropdown-toggle hvr-bounce-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">选中的果果<span class="caret"></span></a>
					<ul class="dropdown-menu">
							<li><a class="hvr-bounce-to-bottom" href="orderServlet?type=3&userName=${userName}">我的订单</a></li>
							<li><a class="hvr-bounce-to-bottom" href="trolleyServlet?type=2&userName=${userName}">我的购物车</a></li>
						</ul>
					</li>
					<li><a href="#" class="dropdown-toggle hvr-bounce-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${userName}账户管理<span class="caret"></span></a>
					<ul class="dropdown-menu">
							<li class="hvr-bounce-to-bottom"><a href="userServlet?type=query&userName=${userName}">编辑个人信息</a></li>
						</ul>
					</li>
					
				</ul>	
				<form class="navbar-form navbar-right" role="search" action="goodsServlet" method="post">
		              <div class="form-group">
		              <input type="text" class="form-control" placeholder="搜索果果" name="selectName">
		              <input type="hidden"  name="type" value="9">
		              <input type="hidden"  name="userName" value="${userName }">
	                  <span class="nav-search"><a href="#"><i class="fa fa-search"></i></a></span>
			          </div>	
	            </form>
				<div class="clearfix"> </div>
			</div>	
		</nav>		
	</div>
  
  <!--特色农户-->
		<div class="about"> 
		<div class="container">
			<h3 class="title">广西特色果果农户</h3>
			
			<div class="about-text">
			<%  for(int i=0;i<list.size();i++){
			 		supplier a=list.get(i);
			 		%>
				<div class="col-md-6 about-text-left">
					<img src="<%=a.getSuImg()%>" style="width:400px; height:250px;" class="" alt="">
				</div>
				<div class="col-md-6 about-text-right">
					<h4>农户名字:<%=a.getSupplierName()%></h4>
					<h4>提供的水果：<%=a.getSuFruit()%></h4>
					<ul>
						</br>
						<h3 class="text-info">联系电话：<%=a.getSuTel()%></h3></br>
						<h3 class="text-info">联系地址：<%=a.getSupplierAddress()%></h3>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			 <%} %>
			
		</div>
	</div>
		<div class="about-slid"> 
			<div class="container">
				<div class="about-slid-info"> 
					<h2>用心做 放心果</h2>
					<p>我们始终坚持选购新鲜原生态水果</p>
				</div>
			</div>
		</div>
	</div>
</html>
