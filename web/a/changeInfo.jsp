<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/8/2018
  Time: 3:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
${ChInfStatus}
<form action="ChUserInfoForAdmin.action" method="post">
    <table>
        <tr>
            <td>原密码:</td>
            <td><input type="password" name="OldPwd"/></td>
        </tr>
        <tr>
            <td>新密码:</td>
            <td><input type="password" name="NewPwd"/></td>
        </tr>
        <tr>
            <td>再输入:</td>
            <td><input type="password" name="NewPwdAgain"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/>&nbsp;</td>
            <td><input type="reset" value="重置"/>&nbsp;</td>
            <td><a href="ChUserInfoOutForAdmin.action" class="button">取消</a></td>
        </tr>
    </table>
</form>
</body>
</html>