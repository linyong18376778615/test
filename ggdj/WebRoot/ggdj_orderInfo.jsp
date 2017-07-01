<%@ page language="java" import="java.util.*"  import="com.iotek.entity.oQuantity"  import="com.iotek.entity.order"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<oQuantity> list=(List<oQuantity>)request.getAttribute("list");
String userName=request.getParameter("userName");
order b=(order)request.getAttribute("order");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>ggdj_orderinfo</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- 定制主题文件-->
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
			<!-- Collect the nav links, forms, and other content for toggling -->
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
	<!--导航栏-->
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
	<!--//导航栏-->
	
	
	
	<!--果果订单-->
	<div class="gallery">		
		<div class="container">
			<h3 class="title">果果订单</h3>
						
				<div class="slide-desktop">
				
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
											</br><label style="margin-left:800px"><h3 >合计：<%=b.getPrice() %></h3></label></br></br>
									    	<!-- div class="add-cart"><a class="btn btn-default"  herf="#">确认收货</a></div-->
									      </div>
									    </div>
									</div>
								</div>
									
							</div>
				
				
				<div class="clearfix"> </div>	
				<script src="js/lightbox-plus-jquery.min.js"> </script>
			</div>				

	
	<!--//果果订单-->
	
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
						<li>计算机与信息技术学院</li>
						
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
