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
<h1>${tool.getToolName()}</h1>&nbsp;
<c:if test="${mycomment.isStar()}">
    <form action="makeStar.action" method="post">
        <input type="submit" value="已点赞"/>
    </form>
</c:if>
<c:if test="${!mycomment.isStar()}">
    <form action="makeStar.action" method="post">
        <input type="submit" value="点赞"/>
    </form>
</c:if>
<br>
ID:${tool.getToolId()}&nbsp;
Version:${tool.getToolVersion()}&nbsp;
Tag:${tool.getToolTag()}<br>
${tool.getToolDescribe()}<br>
点赞：${tool.getStarNumber()}&nbsp;
评论：${tool.getCommentNumber()}<br>
贡献者：${userDAO.getUserById(tool.getUploadUserId()).getUserName()}<br>
上传时间：${tool.getUploadTime()}
<br>
<br>
<a href="resultList.action">返回</a>
<br>
<br>
<b>评论</b><br>
<c:if test="${comments.size()>0}">
    <c:forEach items="${comments}" var="comment">
        <p>${comment.getCommentContent()}<br></p>
        <p>${userDAO.getUserById(comment.getUserId()).getUserName()}&nbsp;&nbsp;${comment.getCommendTime()}</p>
        <br>
    </c:forEach>
</c:if>
<c:if test="${comments.size()==0}">
    暂无他人评论<br>
</c:if>
<br>
<br>
我的评论：&nbsp;&nbsp;&nbsp;&nbsp;评论时间：${mycomment.getCommendTime()}<br>
<form action="insertComment.action" method="post">
    <c:if test="${mycomment.isComment()}">
        <textarea name="commentContent" style="width: 500px;height: 120px;border:0px">${mycomment.getCommentContent()}</textarea><br>
    </c:if>
    <c:if test="${mycomment.isComment()}">
        <textarea name="commentContent" style="width: 500px;height: 20px;border:0px">尚未评论</textarea><br>
    </c:if>
    <input type="submit" value="提交" />
</form>
</body>
</html>
