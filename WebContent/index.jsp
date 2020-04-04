<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表展示</title>
<style type="text/css">
  *{margin: 0px auto;padding: 0;}
  h2{text-align: center;}
  table tr{margin-top: 20px;}
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
</head>
<body>
<h2>欢迎<mark style="color: red;">${name }</mark>登录图书管理系统&nbsp;&nbsp;&nbsp;<span style="font-size: 18px;"><a href="login.jsp">退出登录</a></span></h2>
<div class="container">
	 <table class="table table-hover table-striped">
	  <tr>
	    <td colspan="9" style="text-align: center;"><h2>图书详细信息列表</h2><a href="add.jsp" style="float: right; margin-top: -34px; margin-right: 60px; font-size: 16px;">增加图书</a></td>
	  </tr>
	  <tr>
	   <th>序号</th>
	   <th>书名</th>
	   <th>作者</th>
	   <th>出版社</th>
	   <th>出版日期</th>
	   <th>页数</th>
	   <th>价格</th>
	   <th>内容摘要</th>
	   <th>操作</th>
	  </tr>
	  <c:forEach items="${pg.pageLists  }" var="bo" varStatus = "status">
	   <tr>
	     <td><c:out value="${status.count}"></c:out></td>
	     <td>${bo.name }</td>
	     <td>${bo.author }</td>
	     <td>${bo.publish }</td>
	     <td><fmt:formatDate value="${bo.publishdate }" pattern="YYYY-MM-dd"/></td>
	     <td>${bo.page }</td>
	     <td>${bo.price }</td>
	     <td>${bo.content }</td>
	     <td><a href="Index?op=find&id=${bo.id }">修改</a>||<a onclick="del('${bo.id}')" style="cursor:pointer">删除</a></td>
	   </tr>
	  </c:forEach>
	 </table>	 
   <!-- 分页 -->
   <div class="row text-center">
				<ul class="pagination">
					<li>
						<a href="Index?op=show&pageIndex=${pg.currPage-1 }">&laquo;</a>
					</li>
					<!--  -->
					<c:forEach begin="1" end="${pg.totalPages }" varStatus="i">
					  <li>
						<a href="Index?op=show&pageIndex=${i.index }">第${i.index }页</a>
					  </li>
					</c:forEach>
					<li>
						<a href="Index?op=show&pageIndex=${pg.currPage+1 }">&raquo;</a>
					</li>
				</ul>
       </div>
</div>
<script type="text/javascript">
/* 使用AJAX提交删除方法 */
function del(id){
	var r=confirm("是否删除");
	if(r==true){
		//使用Ajax来进行后台请求
			$(function(){
				$.post({
				url:"Index?op=del",//请求的servelt名称
				type:"post",
				data:"id="+id,//传递的参数值
				dataType:"text",//后台响应的数据类型
				success:function(text){
					//处理成功时响应数据的方法
					if(text.trim()=="true"){
						window.location.reload();
						alert("删除成功！！");
					}else{
						alert("删除失败！！");
					}
				}
			 });
			})
	}
}
</script>
</body>
</html>