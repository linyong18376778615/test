<%@ page language="java" import="java.util.*,com.iotek.servlet.*,com.iotek.entity.user,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="/WEB-INF/tag/c-rt.tld"%>
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
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> <a href="" style="float:right;display:none; ">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="admin_userServlet?method=2&type=1"> 添加用户</a> </li>
        <form action="admin_userServlet?method=3" method="post">
          <input  type="text" placeholder="请输入用户名" name="userName" id="userName" class="input" style="width:250px; line-height:17px;display:inline-block"  />
          <input class="button border-main icon-search" type="submit" value="搜索"  > 
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">用户编号</th>
        <th width="10%">用户名</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>收货地址</th>
        <th>用户类型</th>
        <th width="310">操作</th>
        
      </tr>
      <!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${ list}" var="list">
			<tr class="TableDetail1">
				<td align="center">${list.userId }&nbsp;</td>
				<td align="center">${list.userName }&nbsp;</td>
				<td align="center">${list.userPass }</td>
				<td align="center">${list.userAddress }</td>
				<td align="center">${list.userMail }</td>
				<td align="center">${list.userType }</td>
				<td>
				<a href="admin_userServlet?method=2&userId=${list.userId}&type=0" class="button border-main "><span class="icon-edit"></span>修改</a> 
				<a href="admin_userServlet?method=1&userId=${list.userId}" onClick="return del(1,1,1)"class="button border-red"><span class="icon-trash-o"></span> 删除</a> 
				</td>
			</tr>
			
        	</c:forEach>
        	
     
    
    </table>
  </div>

<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
	else{
			return false;
		}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}

</script>
</body>
</html>