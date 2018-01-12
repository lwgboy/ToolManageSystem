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

                <form id="makeAdmin" action="makeAdmin.action" method="post">
                    <h3>查询到的用户:${nowCho.getUserName()}</h3><br>
                    <p align="center">用户ID：${nowCho.getUserId()}</p>
                    <p align="center">
                        管理员状态：${nowCho.getAdminType()}<br>
                        <c:if test="${nowCho.getUserType()==1}">
                            <a class="act-but submit" href="makeAdmin.action?type=-1" style="color: white" >撤销权限</a>
                        </c:if>
                    </p>
                    <br>
                    <br>
                    <p align="center">设置子类管理权限</p>
                    <br>
                    <div class="opt" style="font-size: 12px">
                        <input class="magic-radio" id="0" type="radio"  name="type" checked="checked" value="0"/>
                        <label for="0">系统工具</label>
                        <input class="magic-radio" id="1" type="radio" name="type" value="1"/>
                        <label for="1">通讯社交</label>
                        <input class="magic-radio" id="2" type="radio" name="type" value="2"/>
                        <label for="2">影音播放</label>
                        <input class="magic-radio" id="3" type="radio" name="type" value="3"/>
                        <label for="3">新闻阅读</label>
                    </div>
                    <div class="opt" style="font-size: 12px">
                        <input class="magic-radio" id="4" type="radio"  name="type" value="4"/>
                        <label for="4">摄影图像</label>
                        <input class="magic-radio" id="5" type="radio" name="type" value="5"/>
                        <label for="5">网上购物</label>
                        <input class="magic-radio" id="6" type="radio" name="type" value="6"/>
                        <label for="6">金融理财</label>
                        <input class="magic-radio" id="7" type="radio" name="type" value="7"/>
                        <label for="7">办公商务</label>
                    </div>
                    <c:if test="${nowCho.getUserType()==1}">
                        <a class="act-but submit" href="javascript:;" onclick="document.getElementById('makeAdmin').submit();"style="color: #FFFFFF">修改</a>
                    </c:if>
                    <c:if test="${nowCho.getUserType()==0}">
                        <a class="act-but submit" href="javascript:;" onclick="document.getElementById('makeAdmin').submit();"style="color: #FFFFFF">设置</a>
                    </c:if>
                    <c:if test="${nowCho.getUserType()==2}">
                        <a class="act-but submit" style="color: grey" disabled="disabled">已是最高权限</a>
                        <a class="act-but submit" href="/a/index.jsp" style="color: white" >退出</a>
                    </c:if>
                </form>
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

