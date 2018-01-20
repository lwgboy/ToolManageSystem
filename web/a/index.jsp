<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/7/2018
  Time: 7:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/6/2018
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/css/component.css" />
    <link rel="stylesheet" type="text/css" href="/css/magic-check.css">
    <link rel="stylesheet" type="text/css" href="/css/top.css">
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
                        <li><a href="/a/changeInfo.jsp">修改密码</a></li>
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <c:if test="${user.getUserType()==2}"><h3>设置子类管理员</h3>
                    <form id="setAdmin" action="setAdmin.action" method="post">
                        <div class="input_outer">
                            <span class="u_user"></span>
                            <input name="id" class="text" style="color: #FFFFFF !important;"value="" type="text" placeholder="请搜索用户ID">
                            <span style="color:red;">*</span>
                        </div>
                        <a class="act-but submit" href="javascript:;" onclick="document.getElementById('setAdmin').submit();"style="color: #FFFFFF">查询</a>
                    </form>
                    <br>
                    <p align="center">${result}</p>
                </c:if>
                <div align="center" style="margin: 50px 0px 0px 0px">
                    <h3>文件管理</h3>
                    <table>
                        <tr>
                            <th style="color: white">ID</th>
                            <th width="100px" style="color: white">名称</th>
                            <th width="100px" style="color: white">版本号</th>
                            <th width="100px" style="color: white">操作</th>
                        </tr>
                        <c:if test="${tools.size()==null}">
                            <tr>
                                <td align="center" style="color: white">Null</td>
                                <td align="center" style="color: white">Null</td>
                                <td align="center" style="color: white">Null</td>
                                <td align="center" style="color: white">Null</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${tools}" var="tool">
                            <tr>
                                <td align="center" style="color: white">${tool.getToolId()}</td>
                                <td align="center" style="color: white">${tool.getToolName()}</td>
                                <td align="center" style="color: white">${tool.getToolVersion()}</td>
                                <td align="center" style="color: white"><a href="delete.action?id=${tool.getToolId()}">删除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
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
