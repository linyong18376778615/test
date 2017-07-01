<%@ page language="java" import="java.util.*" import="com.iotek.entity.order" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 order order=(order)request.getAttribute("order");
 %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改订单</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="admin_orderServlet?method=4">  
      <div class="form-group">
        <div class="label">
          <label>订单号：</label>
        </div>
        <div class="field">
          <label name="orderId" id="orderId">${order.getOrderId()}</label>
        </div>    
      </div>
       <div class="form-group">
        <div class="label">
          <label>订单时间：</label>
        </div>
        <div class="field">
          <label>${order.getTime()}</label>
        </div>    
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户：</label>
        </div>
        <div class="field">
          <label>${order.getUserId()}</label>
        </div>    
      </div>
      <div class="form-group">
        <div class="label">
          <label>价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="price" name="price" value="${ order.getPrice()}" style=" height:90px;" data-validate="required:请输入价格 "/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>收货地址：</label>
        </div>
      <div class="field">
          <textarea class="input" id="userAddress" name="userAddress" style=" height:90px;" data-validate="required:请输入地址">${order.getUserAddress()}</textarea>
          <div class="tips"></div>
        </div>
        </div>
        <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <textarea class="input" id="memo" name="memo" style=" height:90px;">${order.getMemo()}</textarea>
        </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>
