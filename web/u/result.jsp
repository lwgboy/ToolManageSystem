<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/6/2018
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<a href="/u/index.jsp">返回</a>
${searchStatus}
<br>
<br>
<br>

<c:forEach items="${reslut}" var="tool">
    <b><a href="toolDetail.action?toolId=${tool.getToolId()}">${tool.getToolName()}</a></b><br>
    ID:${tool.getToolId()}&nbsp;
    Version:${tool.getToolVersion()}&nbsp;
    Tag:${tool.getToolTag()}<br>
    ${tool.getToolDescribe()}<br>
    点赞：${tool.getStarNumber()}&nbsp;
    评论：${tool.getCommentNumber()}<br>
    <br>
</c:forEach>
</body>
</html>
