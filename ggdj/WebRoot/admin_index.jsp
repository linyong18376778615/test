<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images1/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">&nbsp;&nbsp;<a class="button button-little bg-red" href="indexServlet"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>主菜单</h2>
  <ul style="display:block">  
    <li><a href="admin_goodsServlet?method=0" target="right"><span class="icon-caret-right"></span>商品管理</a></li>   
    <li><a href="admin_orderServlet?method=0" target="right"><span class="icon-caret-right"></span>订单管理</a></li>     
    <li><a href="admin_userServlet?method=0" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
    <li><a href="admin_textServlet?method=0" target="right"><span class="icon-caret-right"></span>公告管理</a></li>
    <li><a href="admin_supplierServlet?method=0" target="right"><span class="icon-caret-right"></span>供应商管理</a></li>
    <li><a href="admin_peopleServlet?method=0" target="right"><span class="icon-caret-right"></span>人群管理</a></li>
  </ul>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<div class="admin">
  <iframe scrolling="auto" rameborder="0"  name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
