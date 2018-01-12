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
    <title>修改密码</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/magic-check.css">
    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />

    <link rel="stylesheet" type="text/css" href="/css/component.css" />
    <link rel="stylesheet" type="text/css" href="/css/magic-check.css">
    <link rel="stylesheet" type="text/css" href="/css/top.css">
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/css/component.css" />
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
                        <li><a href="ChUserInfoOut.action">返回</a></li>
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎你<br><br>${ChInfStatus}</h3><br><br>

                <form id="form1" action="ChUserInfo.action" method="post">

                    <div class="input_outer">
                        <span class="u_passw"></span>
                        <input name="OldPwd" class="text" style="color: #FFFFFF !important;"value="" type="password" placeholder="请输入原密码">
                        <span style="color:red;">*</span>
                    </div>

                    <div class="input_outer">
                        <span class="u_passw"></span>
                        <input name="NewPwd" class="text" style="color: #FFFFFF !important;"value="" type="password" placeholder="请输入新密码">
                        <span style="color:red;">*</span>
                    </div>

                    <div class="input_outer">
                        <span class="u_passw"></span>
                        <input name="NewPwdAgain" class="text" style="color: #FFFFFF !important;"value="" type="password" placeholder="请再输入新密码">
                        <span style="color:red;">*</span>
                    </div>
                    <div class="mb2">
                        <a class="act-but submit" href="javascript:;" onclick="document.getElementById('form1').submit();"style="color: #FFFFFF">修改</a>
                    </div>

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

