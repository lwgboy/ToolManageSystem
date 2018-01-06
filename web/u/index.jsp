<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/6/2018
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
欢迎您 ${user.getUserName()} <br>
<a href="/u/upload.jsp">上传工具</a>
<a href="/u/changeInfo.jsp">修改密码</a>
<a href="Logout.action">退出用户</a>
<br>
<br>
<br>
搜索
<form action="search.action" method="post">
    <input type="radio" checked="checked" name="searchType" value="name"/>名称
    <input type="radio" name="searchType" value="tag"/>标签
    <input type="radio" name="searchType" value="describe"/>描述
    <input type="radio" name="searchType" value="uploadUser"/>发布者<br>
    <input type="text" name="content"/>
    <input type="submit" value="搜索">
</form>
${searchStatus}
</body>
</html>
