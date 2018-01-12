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
                        <li><a href="/u/upload.jsp">上传工具</a></li>
                        <li><a href="/u/changeInfo.jsp">修改密码</a></li>
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>工具搜索</h3><br><br>
                <form id="form1" action="search.action" method="get">

                    <div class="opt" align="center">
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=0">系统工具</a></label></u>
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=1">通讯社交</a></label></u>
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=2">影音播放</a></label></u>
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=3">新闻阅读</a></label></u>
                    </div>
                    <div class="opt" align="center">
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=4">摄影图像</a></label></u>
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=5">网上购物</a></label></u>
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=6">金融理财</a></label></u>
                        <u><label><a style="color: wheat" href="search.action?searchType=type&content=7">办公商务</a></label></u>
                    </div>
                    <br>

                    <div class="input_outer">
                        <input name="content" class="text" style="color: #FFFFFF !important;"value="" type="text" placeholder="请输入搜索项">
                        <span style="color:red;">*</span>
                    </div>
                    <div class="opt" align="center">
                        <input class="magic-radio" id="name" type="radio"  name="searchType" checked="checked" value="name"/>
                        <label for="name">名称</label>
                        <input class="magic-radio" id="tag" type="radio" name="searchType" value="tag"/>
                        <label for="tag">标签</label>
                        <input class="magic-radio" id="describe" type="radio" name="searchType" value="describe"/>
                        <label for="describe">描述</label>
                        <input class="magic-radio" id="uploadUser" type="radio" name="searchType" value="uploadUser"/>
                        <label for="uploadUser">发布者</label>
                    </div>
                    <div class="mb2">
                        <a class="act-but submit" href="javascript:;" onclick="document.getElementById('form1').submit();"style="color: #FFFFFF">搜索</a>
                    </div>
                </form>
                <h3>${searchStatus}</h3>
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