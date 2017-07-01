<%@ page language="java" import="java.util.*" import="com.iotek.entity.user" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type=request.getParameter("type");
user user=(user)request.getAttribute("user");
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
  <div class="panel-head" id="add"><strong id="itemType" ><span class="icon-pencil-square-o"></span>修改用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="admin_userServlet?method=4">  
        <div class="field">
          <input type="hidden" class="input w50" value="${user.getUserId()}" id="userId" name="userId" data-validate="required:请输入名称" readonly="readonly" />
		  <input type="hidden"  name="type" id="type" value=${ type}>
      </div>
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${user.getUserName()}" id="userName" name="userName" data-validate="required:请输入用户名" />
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${user.getUserPass()}" id="userPass" name="userPass" data-validate="required:请输入密码"  />
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
          <div class="label">
            <label>分类：</label>
          </div>
          <div class="field">
          	<input type="hidden"  name="usertype" id="usertype" value=${ user.getUserType()}>
            <input name="userType" id="userType1" type="radio" value="1" />普通用户
            <input name="userType" id="userType2" type="radio" value="2" />管理员
            <div class="tips"></div>
            
          </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label>邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${user.getUserMail()}" id="userMail" name="userMail" data-validate="required:请输入邮箱"  />
          <div class="tips"></div>
        </div>
      </div> 
      <div class="form-group">
        <div class="label">
          <label>地址：</label>
        </div>
        <div class="field">
          <textarea class="input" id="userAddress" name="userAddress"   style=" height:90px;" data-validate="required:请输入地址">${user.getUserAddress()}</textarea>
          <div class="tips"></div>
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
<script type="text/javascript">
	var a=document.getElementById('type');
	if(a.value=="1")//添加
		document.getElementById('itemType').innerHTML="添加用户";
	if(document.getElementById('itemType').innerHTML=="修改用户")
			a.value="0";
	var userType=document.getElementById('userType1');
	var t=document.getElementById('usertype').value;

		if(userType2.value==t)
			userType2.checked=true;
		else
			userType1.checked=true;
</script>
</body></html>
