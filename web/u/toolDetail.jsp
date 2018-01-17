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
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/css/component.css" />
    <link rel="stylesheet" type="text/css" href="/css/magic-check.css">
    <link rel="stylesheet" type="text/css" href="/css/top.css">

    <link rel="stylesheet" href="/css/style2.css">
    <!--[if IE]>
    <script src="/js/html5.js"></script>
    <![endif]-->
    <style type="text/css">
        .opt{height:30px;line-height:24px}
    </style>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <div class="topbar">
                <div class="topbody">
                    <a class="title">欢迎您 ${user.getUserName()} </a>
                    <a class="title" href="Logout.action">退出用户</a>
                    <ul class="toplist">
                        <li><a href="/u/upload.jsp">上传工具</a></li>
                        <li><a href="/u/changeInfo.jsp">修改密码</a></li>
                        <li><a href="resultList.action">返回</a></li>
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box_result">
                <div class="row">
                    <div data-columns>
                        <div class="item" style="margin: 50px 10px 10px 100px;">
                            <h1>${tool.getToolName()}</h1>
                            <c:if test="${mycomment.isStar()}">
                                <form action="makeStar.action" method="post">
                                    &nbsp;<input type="submit" value="已点赞"/>
                                </form>
                            </c:if>
                            <c:if test="${!mycomment.isStar()}">
                                <form action="makeStar.action" method="post">
                                    <input type="submit" value="点赞"/>
                                </form>
                            </c:if>
                            <br>
                            <p style="font-size: 16px">
                                ID:${tool.getToolId()}&nbsp;
                                版本:${tool.getToolVersion()}&nbsp;
                                标签:${tool.getToolTag()}
                            </p>
                            <p style="font-size: 20px;margin: 10px 0px 10px 0px">
                                ${tool.getToolDescribe()}
                            </p>
                            <p style="font-size: 14px">
                                点赞：${tool.getStarNumber()}&nbsp;
                                评论：${tool.getCommentNumber()}&nbsp;
                                下载量：${tool.getDownloadNumber()}<br>
                                类别：
                                <u><a style="color: grey" href="search.action?searchType=type&content=${tool.getToolType()}" >${tool.GetToolTypeDes()}<br></a></u>
                                贡献者：
                                <u><a style="color: grey" href="search.action?searchType=uploadUser&content=${userDAO.getUserById(tool.getUploadUserId()).getUserName()}" >${userDAO.getUserById(tool.getUploadUserId()).getUserName()}<br></a></u>
                                上传时间：${tool.getUploadTime()}
                            </p>
                            <p style="margin: 10px 0px 10px 0px;color: red">
                                <u><a href="download.action?url=${path}">下载</a> </u>
                            </p>
                            <br>
                            <br>
                            <br>
                            <h2>评论</h2><br>
                            <c:if test="${comments.size()>0}">
                                <c:forEach items="${comments}" var="comment">
                                    <p style="font-size: 20px">“${comment.getCommentContent()}”<br></p>
                                    <p style="font-size: 14px;margin: 5px 20px 0px 40px">——by&nbsp;${userDAO.getUserById(comment.getUserId()).getUserName()}&nbsp;at&nbsp;${comment.getCommendTime()}</p>
                                    <br>
                                </c:forEach>
                            </c:if>
                            <c:if test="${comments.size()==0}">
                                暂无评论<br>
                            </c:if>
                            <br>
                            <br>
                            评论：<br>
                            <form action="insertComment.action" method="post">
                                <textarea name="commentContent" style="width: 500px;background-color:transparent;margin: 5px 0px 0px 0px;color: white"></textarea><br>
                                <input type="submit" value="提交" />
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="/js/TweenLite.min.js"></script>
<script src="/js/EasePack.min.js"></script>
<script src="/js/rAF.js"></script>
<script src="/js/demo-1.js"></script>


</body>
</html>

