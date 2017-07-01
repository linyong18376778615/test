<%@ page language="java" import="java.util.*" import="com.iotek.entity.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type=request.getParameter("type");
goods goods=(goods)request.getAttribute("goods");
List<type> tList=(List<type>)request.getAttribute("tList");
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
<script src="js/getData.js"></script>

</head>
<body>
<div class="panel admin-panel">

  <div class="panel-head" id="add"><strong id="itemType"><span class="icon-pencil-square-o" ></span>修改信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x"  action="admin_goodsServlet?method=4">
      <div class="form-group">   
    
    <input type="hidden"  name="type" id="type" value=${ type}>
        
     <div class="field">
                  <input type="hidden" class="input w50" id="goodsId" name="goodsId" value="${ goods.getGoodsId()}" data-validate="required:请输入编号" readonly="readonly" />
       
          
        </div>
       
        <div class="label" style="margin-top:20px" >
          <label>水果名称：</label>
        </div>
        <div class="field" style="margin-top:20px">
                  <input type="text" class="input w50" id="goodsName" name="goodsName" value="${ goods.getGoodsName()}" data-validate="required:请输入名称" />

          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
      
        <div class="label">
          <label>水果照片：</label>
        </div>
        <div class="field">
          <input type="text" id="img" name="img" class="input tips" style="width:25%; float:left;"  data-toggle="hover" data-place="right" value="${goods.getImg()}" data-image="${ goods.getImg()}"  readonly="readonly"/>          
          <input type="button" class="button bg-blue margin-left"  value="+ 浏览上传"  style="float:left;" onclick="document.getElementById('image1').click()">
          <div class="tipss"></div>
        </div>
      </div>     
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>分类：</label>
          </div>
          <div class="field">
            <select id="typeId" name="typeId" class="input w50">
            <%for(int i=0;i<tList.size();i++){ %>
             	
              <option value=<%= tList.get(i).getTypeId()%> ><%= tList.get(i).getTypeName() %> </option> 
			<%} %>
            </select>
            <div class="tips"></div>
            <input type="hidden" id="TypeId" name="TypeId" value=${ goods.getTypeId() } >
          </div>
        </div>
     
      </if>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="goodsDescription" id="goodsDescription"  style=" height:90px;">${ goods.getGoodsDescription()}</textarea>
          <div class="tips"></div>
        </div>
      </div>
 
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>供应商：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="supplierId" name="supplierId" value="${ goods.getSupplierId() }" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="goodsPrice" name="goodsPrice" value="${ goods.getGoodsPrice()}"/>
        </div>
      </div>
  
    
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o"  type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<form action="fileUpload?method=1&type=${ type }" enctype="multipart/form-data" method="post" style="display:none;">
<input type="file" name="image1" id="image1" style="display:none;" onchange="document.getElementById('fileUpload').click()" >
<input type="hidden" name="image2" id="image2" value="${ image2 }" >
<input type="hidden" name="itemgoodsId" id="itemgoodsId" value="${ itemgoodsId }">
<input type="hidden" name="itemgoodsName" id="itemgoodsName" value="${ itemgoodsName }">
<input type="hidden" name="itemtypeId" id="itemtypeId" value="${ itemtypeId }">
<input type="hidden" name="itemgoodsDescription" id="itemgoodsDescription" value="${ itemgoodsDescription}">
<input type="hidden" name="itemsupplierId" id="itemsupplierId" value="${ itemsupplierId }">
<input type="hidden" name="itemgoodsPrice" id="itemgoodsPrice" value="${ itemgoodsPrice }">
<input id="fileUpload" type="submit" onclick="getdata(1)"/>
</form>
<script>
	var a=document.getElementById('type');
	var img=document.getElementById('img');
	var image1=document.getElementById('image2');
	if(a.value=="1")//添加
		document.getElementById('itemType').innerHTML="添加信息";
	if(document.getElementById('itemType').innerHTML=="修改信息")
			a.value="0";
	if(image1.value!="")
		setdata(1);
	var typeId=document.getElementById('typeId');
		var t=document.getElementById('TypeId').value;
		for(var i=0;i<typeId.length;i++)
		{
			if(typeId.options[i].value==t)
				typeId.options[i].selected=true;
				}
</script>
      
     
</body></html>