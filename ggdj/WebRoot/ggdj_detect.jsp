<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userName=request.getParameter("userName");
%>

<!DOCTYPE HTML >

<html>
<head>
<title>ggdj_detect</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Crops Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	
</head>

  <!--背景图片-->   
 <div class="bg"></div>
 <!--//背景图片-->
 <div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">       
            <form action="peopleServlet?type=0" method="post" autocomplete="off">
            <div class="panel loginbox">
                <div class="text-center  padding"><h1>输入信息将为您搭配果果</h1></div>
                <input type="hidden" name="userName" value=${ userName }>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
         				 <label>身高/cm：</label>

                            <input type="number" class="input input-big" id="tall" name="tall" placeholder="请输入身高" data-validate="required:请输入身高" autofocus />
                    </div>
                     <div class="form-group">
                     
                       
         				 <label>体重/kg：</label>
        			
                            <input type="number" class="input input-big" id="weight" name="weight" placeholder="请输入体重" data-validate="required:请输入体重 "/>
                            
                       
                    </div>
                     <div class="form-group">
            			<label>面色：</label>
         			
                    <select id="face" name="face" class="input input-big">
						<option value=25>黯然无色</option> 
              			<option value=50>干涩发黄</option> 
						<option value=75>颇有红润</option> 
						<option value=100>红光满面</option> 
           			 </select>
           			    
                    </div>
                    <div class="form-group">
         				 <label>精神：</label>
          				
           			 <select id="mind" name="mind" class="input input-big">
						<option value=25>无精打采</option> 
              			<option value=50>经常犯困</option> 
						<option value=75>精神饱满</option> 
						<option value=100>生龙活虎</option> 
           			 </select>
           			 
                    </div>
           			 <div class="form-group">
         				 <label>睡眠：</label>
           			 <select id="sleep" name="sleep" class="input input-big">
						<option value=25>失眠多梦</option> 
              			<option value=50>晚睡晚起</option> 
						<option value=75>早睡晚起</option> 
						<option value=100>一夜无梦</option> 
           			 </select>
                    </div>
           			 <div >

         				 <label>运动：</label>
           			 <select id="sport" name="sport" class="input input-big">
						<option value=25>从来不动</option> 
              			<option value=50>一星期一次</option> 
						<option value=75>三天一次</option> 
						<option value=100>每天一小时</option> 
           			 </select>
                    </div>
                
                       <a href="indexServlet" >返回首页</a>
                </div>
                <input type="submit" class="button button-block bg-main text-big input-big" value="开始搭配">
            </div>
            </form>          
        </div>
    </div>
</div>
</body>
</html>