<%@ page language="java" import="java.util.*,com.iotek.servlet.*,com.iotek.entity.people,java.sql.*" pageEncoding="utf-8"%>
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
    <div class="panel-head"><strong class="icon-reorder"> 人群类型</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
      	<li> <a class="button border-main icon-plus-square-o" href="admin_peopleServlet?method=2&type=1"> 添加</a> </li>
      	<form action="admin_peopleServlet?method=3" method="post">
          <input type="text" placeholder="请输入人群关键字"  name="peopleType" id="peopleType"  class="input" style="width:250px; line-height:17px;display:inline-block"   />
          <input class="button border-main icon-search" type="submit" value="搜索"  > 
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
      
        <th>人群</th>
        <th>最小分值</th> 
        <th>最大分值</th>       
        <th>早</th>
        <th>中</th>
        <th>晚</th>
        <th>食用建议</th>
        <th width="310">操作</th>
      </tr> 
      <c:forEach items="${list}" var="list">     
        <tr>
         
          <td align="center">${ list.peopleType }</td>
          <td align="center">${ list.minNumber }</td>
          <td align="center">${ list.maxNumber }</td>
          <td align="center">${ list.morning }</td>
          <td align="center">${ list.lunch }</td>
          <td align="center">${ list.evening }</td>
          <td align="center">${ list.advice }</td>
          <td>
          <a href="admin_peopleServlet?method=2&peopleId=${list.peopleId }&type=0" class="button border-main "><span class="icon-edit"></span>修改</a> 
		  <a href="admin_peopleServlet?method=1&peopleId=${list.peopleId }" onClick="return del(1,1,1)"class="button border-red"><span class="icon-trash-o"></span> 删除</a> 
          </td>
        </tr>
        </c:forEach>
      <tr>
        <td colspan="15">
        	<div class="pagelist"> 
        	<a href="#">下一页</a>
        	<a href="#">1</a>
        	<a href="#">2</a>
        	<a href="#">3</a>
        	<a href="#">4</a>
        	<a href="#">5</a>
        	<a href="#">下一页</a> 
            </div>
        </td>
      </tr>
    </table>
  </div>

<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

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
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}
function changesearch(){	
		
}

</script>
</body></html>