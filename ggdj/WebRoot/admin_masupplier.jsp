<%@ page language="java" import="java.util.*" import="com.iotek.entity.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type=request.getParameter("type");
supplier supplier=(supplier)request.getAttribute("supplier");

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
    <form method="post" class="form-x"  action="admin_supplierServlet?method=4">
       <div class="form-group">   
    
       <input type="hidden"  name="type" id="type" value=${ type}>
        
     <div class="field">
                  <input type="hidden" class="input w50" id="supplierId" name="supplierId" value="${ supplier.getSupplierId()}" data-validate="required:请输入编号" readonly="readonly" />
       
          
        </div>
       
        <div class="label" style="margin-top:20px" >
          <label>供应商名称：</label></div>
        <div class="field" style="margin-top:20px">
                  <input type="text" class="input w50" id="supplierName" name="supplierName" value="${ supplier.getSupplierName()}" data-validate="required:请输入名称" />
                 <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>供应商照片：</label>
        </div>
        <div class="field">
          <input type="text" id="suImg" name="suImg" class="input tips" style="width:25%; float:left;"  data-toggle="hover" data-place="right" value="${supplier.getSuImg()}" data-image="${ supplier.getSuImg()}"  readonly="readonly"/>          
          <input type="button" class="button bg-blue margin-left"  value="+ 浏览上传"  style="float:left;" onclick="document.getElementById('image1').click()">
          <div class="tipss"></div>
        </div>
      </div>     
      
  
      <div class="form-group">
        <div class="label">
          <label>联系地址：</label>
        </div>
        <div class="field">
          <textarea class="input" name="supplierAddress" id="supplierAddress"  style=" height:90px;">${supplier.getSupplierAddress()}</textarea>
          <div class="tips"></div>
        </div>
      </div>
 
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="suTel" name="suTel" value="${ supplier.getSuTel() }" />
        </div>
      </div>
      <div class="clear"></div>
      <div class="form-group">
        <div class="label">
          <label>主要供应的水果：</label>
        </div>
        <div class="field">
          <input type="text" class="input" id="suFruit" name="suFruit" value="${ supplier.getSuFruit() }" />
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
<form action="fileUpload?method=3&type=${ type }" enctype="multipart/form-data" method="post" style="display:none;">
<input type="file" name="image1" id="image1" style="display:none;" onchange="document.getElementById('fileUpload').click()" >
<input type="hidden" name="image2" id="image2" value="${ image2 }" >
<input type="hidden" name="itemsupplierId" id="itemsupplierId" value="${ itemsupplierId }">
<input type="hidden" name="itemsupplierName" id="itemsupplierName" value="${ itemsupplierName }">
<input type="hidden" name="itemsupplierAddress" id="itemsupplierAddress" value="${ itemsupplierAddress }">
<input type="hidden" name="itemsuImg" id="itemsuImg" value="${ itemsuImg }">
<input type="hidden" name="itemsuTel" id="itemsuTel" value="${ itemsuTel }">
<input type="hidden" name="itemsuFruit" id="itemsuFruit" value="${ itemsuFruit }">
<input id="fileUpload" type="submit" onclick="getdata(3)"/>
</form>
<script>
	var a=document.getElementById('type');
	var image2=document.getElementById('image2');
	if(a.value=="1")//添加
		document.getElementById('itemType').innerHTML="添加信息";
	if(document.getElementById('itemType').innerHTML=="修改信息")
			a.value="0";
	
	if(image2.value=="")
	{}
	else{	
		setdata(3);
		}
</script>
      
     
</body></html>