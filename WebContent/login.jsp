<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
   *{margin: 0px auto;padding: 0px;}
   body{background-image: url(static/images/timg.jfif);background-repeat: no-repeat;background-size: 100%;}
   #big{width: 360px;height: 210px;background-color: #FFFACD;margin-top: 130px;}
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<title>图书管理系统————登录页面</title>
</head>
<body>
<div class="container" id="big">
 <form action="Login" method="post">
   <table class="table">
     <tr>
       <th colspan="2" style="text-align: center;">图书管理系统登录页面</th>
     </tr>
     <tr>
       <th>用户名：</th>
       <td><input type="text" name="username" value=""/></td>
     </tr>
     <tr>
       <th>密码：</th>
       <td><input type="password" name="password" value=""/></td>
     </tr>
     <tr>
       <th>验证码：</th>
       <td><input type="text" name="code" value="" style="display: inline-block;width: 60px;height: 30px; padding: 0px;text-indent: 0;"/>
			<img id="codeImg" src=""/>
			<a href="javascript:changeImg();">看不清</a></td>
     </tr>
     <tr>
       <td colspan="2" style="text-align: center;"><button type="submit" class="btn btn-success">登录</button></td>
     </tr>
   </table>
 </form>  
</div>
<script type="text/javascript">	
    $(function(){
    	changeImg();
    	$("input[type='submit']").click(function(){
    		var x=$("input[name='Adminname']").val();
    		var y=$("input[name='Adminpwd']").val();
    		var z=$("input[name='code']").val();
    		if(x=="" || y=="" || z==""){
    		  alert("不能为空");
    		}
    	})
     });
    // 定义一个当src发生改变时就到后台去获得一个随机的验证码
	function changeImg() {
		// 获得验证码图片元素 使用JavaScript获得
		var img = document.getElementById("codeImg");
		// 当src的路径发生改变，都会到后台去请求一次
		// new Date().getTime() 避免浏览器不去后台请求数据，因为有缓存
		img.src="${pageContext.request.contextPath}/CodeImg?"+new Date().getTime();
	}	
</script>
</body>
</html>