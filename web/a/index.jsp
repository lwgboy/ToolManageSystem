<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/7/2018
  Time: 7:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
</head>
<body>
欢迎您，${user.getUserName()} <br>
<a href="/a/changeInfo.jsp">修改密码</a>
<a href="Logout.action">退出用户</a>
<br>
<br>
<br>
<c:if test="${user.getUserType()==2}">
    设置子类管理员：<br>
    <form action="setAdmin.action" method="post">
        用户ID：<input type="text" name="id"/><input type="submit" value="查询"/>
    </form>
    ${result}
</c:if>
</body>
</html>
