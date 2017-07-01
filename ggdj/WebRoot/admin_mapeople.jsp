<%@ page language="java" import="java.util.*" import="com.iotek.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type=request.getParameter("type");
people people=(people)request.getAttribute("people");
List<goods> gList=(List<goods>)request.getAttribute("gList");
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
  <div class="panel-head" id="add"><strong id="itemType"><span class="icon-pencil-square-o"></span>修改信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="admin_peopleServlet?method=4"> 
    <input type="hidden"  name="type" id="type" value=${ type}>
    <input type="hidden" class="input w50" id="peopleId" name="peopleId" value="${ people.getPeopleId()}" /> 
      <div class="form-group">
        <div class="label">
          <label>人群：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50"  name="peopleType" value="${ people.getPeopleType()}" data-validate="required:请输入人群类型" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>最小分值：</label>
        </div>
        <div class="field">
          <input type="number" class="input w50" value="${ people.getMinNumber() }" name="minNumber" data-validate="required:请输入最小分值" />    
        </div>
      </div>     
      
      <div class="form-group">
        <div class="label">
          <label>最大分值：</label>
        </div>
        <div class="field">
          <input type="number" class="input w50" value="${ people.getMaxNumber() }" name="maxNumber" data-validate="required:请输入最大分值" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>早：</label>
        </div>
        <div class="field">
 			<select id="morning" name="morning" class="input w50">
            <%for(int i=0;i<gList.size();i++){ %>
             	
              <option value=<%= gList.get(i).getGoodsName()%> ><%= gList.get(i).getGoodsName() %> </option> 
			<%} %>
            </select>
            <input type="hidden" id="morningGoods"  value=${ people.getMorning() } >
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>中：</label>
        </div>
        <div class="field">
         <select id="lunch" name="lunch" class="input w50">
            <%for(int i=0;i<gList.size();i++){ %>
             	
              <option value=<%= gList.get(i).getGoodsName()%> ><%= gList.get(i).getGoodsName() %> </option> 
			<%} %>
            </select>
            <input type="hidden" id="lunchGoods"  value=${ people.getLunch() } >
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>晚：</label>
        </div>
        <div class="field"> 
          <select id="evening" name="evening" class="input w50">
            <%for(int i=0;i<gList.size();i++){ %>
             	
              <option value=<%= gList.get(i).getGoodsName()%> ><%= gList.get(i).getGoodsName() %> </option> 
			<%} %>
            </select>
            <input type="hidden" id="eveningGoods"  value=${ people.getEvening() } >
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>食用建议：</label>
        </div>
        <div class="field">
          <textarea class="input" name="advice" id="advice"  style=" height:90px;" data-validate="required:请输入建议" >${ people.getAdvice()}</textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        
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
		document.getElementById('itemType').innerHTML="添加信息";
	if(document.getElementById('itemType').innerHTML=="修改信息")
			a.value="0";
	var morningGoods=document.getElementById('morningGoods').value;
	var lunchGoods=document.getElementById('lunchGoods').value;
	var eveningGoods=document.getElementById('eveningGoods').value;
	var morning=document.getElementById('morning');
	var lunch=document.getElementById('lunch');
	var evening=document.getElementById('evening');
		for(var i=0;i<morning.length;i++)
		{
			if(morning.options[i].value==morningGoods)
				morning.options[i].selected=true;
			else if(lunch.options[i].value==lunchGoods)
				lunch.options[i].selected=true;
			else if(evening.options[i].value==eveningGoods)
				evening.options[i].selected=true;
		}
</script>
</body></html>
