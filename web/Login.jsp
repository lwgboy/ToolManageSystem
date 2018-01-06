<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/6/2018
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h>用户登录</h>
    <br>${LoginStatus}
    <form action="Login.action" method="post">
        <table>
            <tr>
                <td><input type="radio" checked="checked" name="userType" value="normal"/>普通用户</td>
                <td><input type="radio" name="userType" value="admin"/>管理员</td>
            </tr>
            <tr>
                <td>账号:</td>
                <td><input type="text" name="userId"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr><td><input type="submit" value="登录"/></td>&nbsp;<td><input type="reset" value="重置"/></td></tr>
        </table>
    </form>
</body>
</html>
