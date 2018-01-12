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
                        <li><a href="/u/index.jsp">返回</a></li>
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box_result">
                <div class="row">
                    <div id="fh5co-board">
                        <br>
                        <br>
                        <h3>${searchStatus}</h3>

                        <c:forEach items="${reslut}" var="tool">
                            <div align="center">
                                <u><h2><a style="color: cornflowerblue;" href="toolDetail.action?toolId=${tool.getToolId()}">${tool.getToolName()}</a></h2></u>
                                <div class="animate-box">
                                    <p style="font-size: 14px;margin: 10px 0px 0px 0px">
                                        ID:${tool.getToolId()}&nbsp;
                                        版本:${tool.getToolVersion()}&nbsp;
                                        标签:${tool.getToolTag()}
                                    </p>
                                    <p style="font-size: 18px;margin: 5px 0px 0px 0px">
                                            ${tool.getToolDescribe()}
                                    </p>
                                    <p style="font-size: 14px;margin: 5px 0px 0px 0px">
                                        点赞：${tool.getStarNumber()}&nbsp;
                                        评论：${tool.getCommentNumber()}
                                    </p>
                                    <br>
                                </div>
                                <br>
                                <br>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="/js/TweenLite.min.js"></script>
<script src="/js/EasePack.min.js"></script>
<script src="/js/rAF.js"></script>
<script src="/js/demo-1.js"></script>



</body>
</html>