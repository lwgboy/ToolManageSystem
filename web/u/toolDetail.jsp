<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/6/2018
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${tool.getToolName()}</title>
</head>
<body>
<h1>${tool.getToolName()}</h1><br>
ID:${tool.getToolId()}&nbsp;
Version:${tool.getToolVersion()}&nbsp;
Tag:${tool.getToolTag()}<br>
${tool.getToolDescribe()}<br>
点赞：${tool.getStarNumber()}&nbsp;
评论：${tool.getCommentNumber()}<br>
<br>
<b>评论</b><br>
<c:if test="${comments.size()>0}">
    <c:forEach items="${comments}" var="comment">
        <p>${comment.getCommentContent()}<br></p>
        <p>${comment.getUserId()}&nbsp;&nbsp;${comment.getCommendTime()}</p>
        <br>
    </c:forEach>
</c:if>
<c:if test="${comments.size()==0}">
    暂无他人评论<br>
</c:if>
<br>
<br>
<br>
<br>
${user.getUserName()}的评论：&nbsp;&nbsp;&nbsp;&nbsp;评论时间：${mycomment.getCommendTime()}<br>
<form action="insertComment.action" method="post">
    <input type="text" name="commentContent" style="width:500px;height:100px;border:0px;" value="${mycomment.getCommentContent()}" /><br>
    <input type="submit" value="提交" />
</form>
</body>
</html>
