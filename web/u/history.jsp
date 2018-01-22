<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/22/2018
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box_result">
                <div class="row">
                    <div data-columns>
                        <div class="item" style="margin: 50px 10px 10px 100px;">
                            <h2>历史评论</h2>
                            <br>
                            <c:if test="${history==null}">
                                暂无历史评论
                            </c:if>
                            <c:if test="${history.size()>0}">
                                <c:forEach items="${history}" var="it">
                                    <p style="font-size: 18px">${it.getComment()}</p>
                                    <p>  ----${it.getTime()}</p>
                                    <br>
                                </c:forEach>
                            </c:if>
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
