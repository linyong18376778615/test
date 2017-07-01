<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" import="com.iotek.entity.text" pageEncoding="utf-8"%>

<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type=request.getParameter("type");
text text=(text)request.getAttribute("text");
//String image1=(String)request.getAttribute("image2");
//String itemtextId=(String)request.getAttribute("itemtextId");
//String itemcontent=(String)request.getAttribute("itemcontent");

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
  <div class="panel-head" id="add"><strong id="itemType"><span class="icon-pencil-square-o"></span>修改公告</strong></div>
 
  
  <div class="body-content">
    <form method="post" class="form-x" action="admin_textServlet?method=4">  
     
       
        <input type="hidden"  name="type" id="type" value=${ type}>
    
          <input type="hidden" class="input w50" value="${text.getTextId()}" id="textId" name="textId" data-validate="required:请输入名称" readonly="readonly" />
      
      <div class="form-group">
        <div class="label">
          <label>水果照片：</label>
        </div>
        <div class="field">
          <input type="text" id="img" name="img" class="input tips" style="width:25%; float:left;"  value="${text.getImg()}"  data-toggle="hover" data-place="right" data-image="${ text.getImg()}" readonly="readonly" />
          <input type="button" class="button bg-blue margin-left"  value="+ 浏览上传"  style="float:left;" onclick="document.getElementById('image1').click()" >
          <div class="tips"></div>
        </div>
      </div>     

 
       <div class="form-group">
        <div class="label">
          <label>公告内容：</label>
        </div>
        <div class="field">
          <textarea class="input" id="content" name="content"  style=" height:90px;" data-validate="required:请输入公告内容">${text.getContent()}</textarea>
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
<form action="fileUpload?method=2&type=${ type}" enctype="multipart/form-data" method="post" style="display:none;">
<input type="file" name="image1" id="image1" style="display:none;"  onchange="document.getElementById('fileUpload').click()" >
<input type="hidden" name="image2" id="image2" value="${ image2 }" >
<input type="hidden" name="itemtextId" id="itemtextId" value="${ itemtextId }">
<input type="hidden" name="itemcontent" id="itemcontent" value="${ itemcontent }">
<input id="fileUpload" type="submit" onclick="getdata(2)" />
</form>
<script type="text/javascript">
var a=document.getElementById('type');
var image2=document.getElementById('image2');
	if(a.value=="1")//添加
		document.getElementById('itemType').innerHTML="添加公告";
	if(document.getElementById('itemType').innerHTML=="修改公告")
			a.value="0";
			
	if(image2.value=="")
	{}
	else{	
		setdata(2);
		}
</script>
</body></html>
