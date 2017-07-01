<%@ page language="java" import="java.util.*"  import="com.iotek.entity.order" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<order> list=(List<order>)request.getAttribute("list");
String userName=request.getParameter("userName");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ggdj_allorders</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- 定制主题文件 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Crops Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //定制主题文件 -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script> 
<!-- //js -->	
<!-- start-smoth-scrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>	
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
</script>
<!--//end-smoth-scrolling-->
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
			<!-- 收集导航链接、表单和其他内容切换 -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="hvr-bounce-to-bottom active"><a href="indexServlet?userName=${userName}">家园</a></li>
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
					 <li class="hvr-bounce-to-bottom" ><a href="peopleServlet?type=2&userName=${userName }">搭配水果套餐</a></li>
					
					
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
	<!--//导航栏-->
	<!--横幅图片-->
	<div class="baner about-bnr">
		<div class="container">
			<div class="baner-grids">
				<div class="col-md-6 baner-top">
					<img src="images/img16.png" alt=""/>
				</div>
				<div class="col-md-6 baner-top">
					<img src="images/img17.png" alt=""/>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//横幅图片-->
	
	
	
	<!--果果订单页面 -->
	<div class="typo">
		<div class="container">
			<h3 class="title">我的果果订单</h3>
			<div class="grid_3 grid_4">
				<div class="bs-example">
	                <table class="table">
						</table>
				</div>
			</div>
	    <form action="orderServlet" method="post">
		<label style="margin-left:800px">订单搜索：<input type="text" placeholder="请输入日期如2017-05-12" name="date"></label>
		<input type="submit" value="搜索" style="margin-left:10px" />
		<input type="text" name="userName" value="${userName} " style="display:none">
		<input type="text" name="type" value="1" style="display:none">
		</form>
			
						
			<div class="bs-docs-example">
				<table class="table table-striped">
					
						<tr>
							<th></th>
							<th>订单编号</th>
							<th>订单日期</th>
							<th>总价</th>
							<th>备注</th>
							<th>操作</th>
						
						</tr>
					
					<tbody>
					<%for(int i=0;i<list.size();i++){
					  order a=list.get(i);
					 %>
						<tr>
							<td><%=(i+1)%></td>
							<td><a href="orderServlet?type=4&userName=${userName}&orderId=<%=a.getOrderId()%>"><%=a.getOrderId()%></a></td>
							<td><%=a.getTime() %></td>
							<td><%=a.getPrice()%></td>
							<td><%=a.getMemo() %></td>
							<td><span class="delete"><a href="orderServlet?type=5&userName=${userName}&orderId=<%=a.getOrderId()%>">删除</a></span></td>
							
							
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
	<!-- //订单页面 -->		
	<!-- 底部 -->
	<div class="footer">	
		<div class="container">
			<div class="footer-grids">
			<div class="col-md-3 footer-grid">
				<h3 class="title">狼牙科技</h3>
					<ul>
		                <li> 做放心果果</li>
					
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h3 class="title">核心成员</h3>
					 <ul>
						<li>赖秋凝</li>
						<li>谢裕妮</li>
						<li>唐棠</li>
						<li>罗炜龙</li>	
						<li>李雄峰</li>
					    <li>邓栋</li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h3 class="title">总部</h3>
					<ul>
						<li>南宁市广西大学</li>
						<li>计算机与电子信息学院</li>
						
					</ul>
				</div>
				<div class="col-md-3 footer-grid contact-grid">
						<h3 class="title">联系我们</h3>
						<ul>
							
							<li><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+15777123456</li>
							<li><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>邮箱：wolftooth@gmail.com</li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<div class="copy">
		<div class="container">
			<div class="copy-left">
				<p>Copyright &copy; 2017.Team name Wolf tooth reserved.</p>
			</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//底部-->
	<!--上移到顶部-->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<!--//上移到顶部-->
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"></script>
</body>
</html>
