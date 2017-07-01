<%@ page language="java" import="java.util.*" import="com.iotek.entity.goods" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
goods a=(goods)request.getAttribute("goods");
String userName=(String)request.getParameter("userName");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>ggdj_goodsinfo</title>
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
    <%
      Object message = request.getAttribute("message");
      if(message!=null && !"".equals(message)){
 
  %>
      <script type="text/javascript">
          alert("<%=message%>");
      </script>
<%} %>
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
					<li class="hvr-bounce-to-bottom"><a href="indexServlet?&userName=${userName}">家园</a></li>
					<li class="hvr-bounce-to-bottom active"><a href="goodsServlet?type=0&userName=${userName}">果果集市</a></li>
					<li><a href="#" class="dropdown-toggle hvr-bounce-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我想要的果果<span class="caret"></span></a>
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
	<!--关于水果-->
	<div class="about"> 
		<div class="container">
			<h3 class="title">关于<%=a.getGoodsName()%></h3>
			<div class="about-text">
				<div class="col-md-6 about-text-left">
					<img src="<%=a.getImg() %>" class="img-responsive" alt=""/>
				</div>
				<div class="col-md-6 about-text-right">
					<p><%=a.getGoodsDescription() %></p>
					<h3 class="text-info"><%=a.getGoodsPrice() %>元/kg</h3>

				<div class="add-cart"><a class="btn btn-default" href="trolleyServlet?type=1&userName=${userName}&goodsId=<%= a.getGoodsId() %>">加入购物车</a></div>
				</div>
				<div class="clearfix"> </div>
			</div>
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
	<div class="about-team">		
		<div class="container">
			<h3 class="title">优 质 果 果</h3>
			<div class="row team-row">
				<div class="col-sm-6 col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img12.jpg" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">榴莲</a></h4>
							<p>榴莲含有丰富的蛋白质和脂类，对机体有很好的补养作用，是良好的果品类营养来源。</p>						
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img13.png" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">葡萄</a></h4>
							<p>葡萄中的糖主要是葡萄糖，能很快被人体吸收。葡萄是消化能力较弱者的理想果品。葡萄中含有一种有益的抗癌物质，可以防止健康细胞癌变，并能防止癌细胞扩散。</p>						
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img14.png" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">柚子</a></h4>
							<p>高血压患者常利用药物来排除体内多余的钠，柚子正好含有这些患者必需的天然矿物质——钾，却几乎不含钠，因此是患有心脑血管病及肾脏病患者最佳的食疗水果。</p>						
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-3 team-grids">
					<div class="thumbnail team-thmnl">
						<img src="images/img15.png" class="img-responsive zoom-img" alt="...">
						<div class="caption">
							<h4><a href="#">火龙果</a></h4>
							<p>火龙果含有维生素E和一种更为特殊的成分——花青素。花青素在葡萄皮、红甜菜等果蔬中都含有，但以火龙果果实中的花青素含量最高。</p>						
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
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
