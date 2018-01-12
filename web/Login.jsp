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
    <title>登录</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/magic-check.css">
    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
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

            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎你<br><br>${LoginStatus}</h3><br><br>
                <form id="form1" action="Login.action" method="post">

                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userId" class="text" style="color: #FFFFFF !important;"value="" type="text" placeholder="请输入ID">
                        <span style="color:red;">*</span>
                    </div>

                    <div class="input_outer">
                        <span class="u_passw"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                    </div>
                    <div class="opt" align="center">
                        <input class="magic-radio" id="normal" type="radio"  name="userType" checked="checked" value="normal"/>
                        <label for="normal">普通用户</label>
                        <input class="magic-radio" id="admin" type="radio" name="userType" value="admin"/>
                        <label for="admin">管理员</label>
                    </div>
                    <div class="mb2">
                        <a class="act-but submit" href="javascript:;" onclick="document.getElementById('form1').submit();"style="color: #FFFFFF">登陆</a>
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