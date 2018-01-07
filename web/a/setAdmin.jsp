<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/8/2018
  Time: 3:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置子类管理员</title>
</head>
<body>
<a href="/a/index.jsp">退出</a><br>
<br>
查询到的用户：<br>
<b>用户名：${nowCho.getUserName()}</b><br>
用户ID：${nowCho.getUserId()}<br>
管理员状态：${nowCho.getAdminType()}&nbsp;
<c:if test="${nowCho.getUserType()==1}">
    <a href="makeAdmin.action?type=-1">撤销权限</a>
</c:if><br>
<br>
设置子类管理权限：<br>
<form action="makeAdmin.action" method="post">
    <tr>
        <td><input type="radio" checked="checked" name="type" value="0"/>系统工具</td>
        <td><input type="radio" name="type" value="1"/>通讯社交</td>
        <td><input type="radio" name="type" value="2"/>影音播放</td>
        <td><input type="radio" name="type" value="3"/>新闻阅读</td>
        <td><input type="radio" name="type" value="4"/>摄影图像</td>
        <td><input type="radio" name="type" value="5"/>考试学习</td>
        <td><input type="radio" name="type" value="6"/>网上购物</td>
        <td><input type="radio" name="type" value="7"/>金融理财</td>
        <td><input type="radio" name="type" value="8"/>生活休闲</td>
        <td><input type="radio" name="type" value="9"/>旅游出行</td>
        <td><input type="radio" name="type" value="10"/>办公商务</td>
    </tr>
    <br>
    <c:if test="${nowCho.getUserType()==1}">
        <input type="submit" value="修改"/>
    </c:if>
    <c:if test="${nowCho.getUserType()==0}">
        <input type="submit" value="设置"/>
    </c:if>
    <c:if test="${nowCho.getUserType()==2}">
        <input type="submit" value="已是最高权限" disabled="disabled"/>&nbsp;
        <a href="/a/index.jsp">退出</a>
    </c:if>
</form>
</body>
</html>
