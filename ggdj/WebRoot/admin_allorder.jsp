<%@ page language="java" import="java.util.*,com.iotek.servlet.*,com.iotek.entity.order,java.sql.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List<order> list=(List<order>)request.getAttribute("list");
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
    <div class="panel-head"><strong class="icon-reorder"> 订单管理</strong></div>
     <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <form action="admin_orderServlet" method="post">
          <input type="text" placeholder="请输入日期如2017-05-12"  name="date" id="date"  class="input" style="width:250px; line-height:17px;display:inline-block"   />
          <input type="hidden" name="method" id="method" value="3">
          <input class="button border-main icon-search" type="submit" value="搜索" > 
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">订单号</th>
        <th>用户号</th>       
        <th>收货地址</th>
        <th>总价(元)</th>
         <th>备注</th>
         <th>时间</th>
        <th>操作</th>       
      </tr>      
        <!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach items="${list}" var="list">
			<tr class="TableDetail1">
				<td align="center">${list.orderId }&nbsp;</td>
				<td align="center">${list.userId }&nbsp;</td>
				<td align="center">${list.userAddress }</td>
				<td align="center">${list.price }</td>
				<td align="center">${list.memo }</td>
				<td align="center">${list.time }</td>
				<td>
				<a href="admin_orderServlet?method=5&orderId=${list.orderId}&userId=${list.userId }"  class="button border-green"><span></span>查看详情</a>
				<a href="admin_orderServlet?method=2&orderId=${list.orderId}" class="button border-main "><span class="icon-edit"></span>修改</a> 
				<a href="admin_orderServlet?method=1&orderId=${list.orderId}" onClick="return del(1,1,1)" class="button border-red"><span class="icon-trash-o"></span> 删除</a> 
			</tr>
			
        	</c:forEach>
      
    </table>
  </div>

<script type="text/javascript">

function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
	else{
			return false;
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