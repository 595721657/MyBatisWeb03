<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改跟添加公用一个页面</title>
<style type="text/css">
  *{margin: 0px auto;padding: 0;}
  h2{text-align: center;}
</style>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
</head>
<body>
<c:if test="${empty book}" var="isOK">
  <h2 style="text-align: center;">增加图书</h2>
  <form action="Index?op=add" method="post">
     <table style="margin: 0px auto;padding: 0;">
     <tr>
       <th>书名(*)</th>
       <td><input type="text" name="name" value=""/></td>
     </tr>
      <tr>
       <th>作者(*)</th>
       <td><input type="text" name="author" value=""/></td>
     </tr>
      <tr>
       <th>出版社(*)</th>
       <td><input type="text" name="publish" value=""/></td>
     </tr>
      <tr>
       <th>出版日期(*)</th>
       <td><input type="text" name="publishdate" value=""/>(yyyy-MM-dd)</td>
     </tr>
      <tr>
       <th>页数(*)</th>
       <td><input type="text" name="page" value=""/></td>
     </tr>
      <tr>
       <th>价格(*)</th>
       <td><input type="text" name="price" value=""/></td>
     </tr>
     <tr>
      <th>内容摘要(*)</th>
      <td>
        <div id="editor">
       </div>
       <textarea style="display: none;" name="content" id="text"></textarea>
      </td>
     </tr>
     <tr>
      <th>&nbsp;</th>
      <td style="text-align: center;"><button type="submit" >添加</button>||<button formaction="Index?op=show">返回</button></td>
     </tr>
   </table>
  </form>
</c:if>
<c:if test="${!isOK }">
  <h2 style="text-align: center;">修改图书</h2>
  <form action="Index?op=update" method="post">
     <table style="margin: 0px auto;padding: 0;">
      <tr>
       <td colspan="2"><input type="hidden" name="id" value="${book.id }"/></td>
     </tr>
     <tr>
       <th>书名(*)</th>
       <td><input type="text" name="name" value="${book.name }"/></td>
     </tr>
      <tr>
       <th>作者(*)</th>
       <td><input type="text" name="author" value="${book.author }"/></td>
     </tr>
      <tr>
       <th>出版社(*)</th>
       <td><input type="text" name="publish" value="${book.publish }"/></td>
     </tr>
      <tr>
       <th>出版日期(*)</th>
       <td><input type="text" name="publishdate" value="<fmt:formatDate value="${book.publishdate }" pattern="YYYY-MM-dd"/>"/>(yyyy-MM-dd)</td>
     </tr>
      <tr>
       <th>页数(*)</th>
       <td><input type="text" name="page" value="${book.page }"/></td>
     </tr>
      <tr>
       <th>价格(*)</th>
       <td><input type="text" name="price" value="${book.price }"/></td>
     </tr>
     <tr>
      <th>内容摘要(*)</th>
      <td>
        <div id="editor">
         ${book.content }
       </div>
       <textarea style="display: none;" name="content" id="text"></textarea>
      </td>
     </tr>
     <tr>
      <th>&nbsp;</th>
      <td style="text-align: center;"><button type="submit" >修改</button>||<button formaction="Index?op=show">返回</button></td>
     </tr>
   </table>
  </form>
</c:if>
 <!-- 引入js文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/wangEditor.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.js"></script>
      <script type="text/javascript">
      var E =window.wangEditor;//获得一个富文本编辑器对象
      var editor=new  E("#editor");
	   //创建出编辑器
	   editor.customConfig.onchange = function (html) {
	       // 监控变化，同步更新到 textarea
	 	  document.getElementById("text").value=html;
	   }
	     editor.create();
      </script>
</body>
</html>