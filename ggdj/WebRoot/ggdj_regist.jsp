<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >

<html>
<head>
<title>ggdj_regist</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Crops Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	
</head>
<%
      Object message = request.getAttribute("message");
      if(message!=null && !"".equals(message)){
 
  %>
 <script type="text/javascript">
          alert("<%=message%>");
</script>
     <%} %>
     
 <div class="bg"></div>
 <div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
          
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="userServlet" method="post" autocomplete="off">
            <input type="hidden" value="regist" name="type" >
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>注册你的果果</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                     
                        <div class="field field-icon-right">
                      
         				 <label>请输入用户名：</label>
        		
                            <input type="text" class="input input-big" id="userId" name="userName" placeholder="请输入账号" data-validate="required:请填写账号" autofocus />
             
                        </div>
                    </div>
                     <div class="form-group">
                        <div class="field field-icon-right">
                       
         				 <label>请输入密码：</label>
        			
                            <input type="password" class="input input-big" id="pw1" name="userPass" placeholder="请输入密码" data-validate="required:请输入密码" />
                            
                        </div>
                    </div>
                     <div class="form-group">
                        <div class="field field-icon-right">
                      
         				 <label>请再次输入密码：</label>
        		
                            <input type="password" class="input input-big" id="pw2" placeholder="请确认密码" data-validate="required:请确认密码" />
                           
                        </div>
 <script>
      document.getElementById("pw2").onblur = document.getElementById("pw1").onblur = function(){
      document.getElementById("pw2").value && document.getElementById("pw1").value && document.getElementById("pw2").value != document.getElementById("pw1").value && alert("密码2次输入不一致！");
      //document.getElementById("pw2").value="";
}
</script>  
                    </div>
                     <div class="form-group">
                        <div class="field field-icon-right">
                     
         				 <label>请输入地址：</label>
        		
                            <input type="text" class="input input-big" name="userAddress" placeholder="请输入地址" data-validate="required:请输入地址" />
                           
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                        
         				 <label>请输入邮箱：</label>
        			
                            <input type="email" class="input input-big"  name="userMail" placeholder="请输入邮箱" data-validate="required:请填入邮箱" />
                            
                        </div>
                    </div>
                       <a href="indexServlet" align="center">返回首页</a>
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="注册"></div>
            </div>
            </form>          
        </div>
    </div>
</div>
</body>
</html>