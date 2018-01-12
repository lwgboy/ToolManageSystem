<%--
  Created by IntelliJ IDEA.
  User: Yananart
  Date: 1/6/2018
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传工具</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="/css/file.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/css/component.css" />
    <link rel="stylesheet" type="text/css" href="/css/magic-check.css">
    <link rel="stylesheet" type="text/css" href="/css/top.css">

    <link rel="stylesheet" href="/css/style2.css" />
    <!--[if IE]>
    <script src="/js/html5.js"></script>
    <![endif]-->
    <style type="text/css">
        .opt{height:30px;line-height:24px}
    </style>
    <style type="text/css">
        input[type='text']{background:none;border:none;border-bottom:1px solid #ddd;}.inp{background:none;border:none;border-bottom:1px solid #ddd;}
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
                        <li><a href="/u/changeInfo.jsp">修改密码</a></li>
                        <li><a href="/u/index.jsp">返回主界面</a></li>
                    </ul>
                </div>
            </div>
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box_result">
                <div class="row">
                    <div data-columns>
                        <div align="center" style="margin: 25px 0px 0px 0px">
                            <form name="uploader" action="upload.action" method="post" enctype="multipart/form-data">
                                <h2>上传工具</h2>
                                <br>
                                <a href="javascript:;" class="file">选择文件
                                    <input type="file" name="file">
                                </a>
                                <br>
                                <p style="color: white;font-size: 14px">
                                    ${uploadStatus}
                                </p>
                                <br>
                                上传工具说明<br>
                                工具名称：<input type="text" name="name" style="background: transparent;margin: 10px 0px 0px 0px;color: white" value="${upname}"/><br>
                                <p style="margin: 10px 0px 0px 0px">
                                    工具版本：<i>V</i>
                                    <input type="text" name="version1" style="width: 20px;background: transparent;color: white" value="${ver1}" />.
                                    <input type="text" name="version2" style="width: 20px;background: transparent;color: white" value="${ver2}" />.
                                    <input type="text" name="version3" style="width: 20px;background: transparent;color: white" value="${ver3}" />
                                    &nbsp;&nbsp;<i>(版本号示例：<b>V1.0.0</b>)</i><br>
                                </p>
                                <p style="margin: 20px 0px 0px 0px">
                                    工具类别：
                                </p>
                                <table style="margin: 0px 0px 0px 0px">
                                    <tr style="color:white">
                                        <td><input type="radio" checked="checked" name="type" value="0"/>系统工具</td>&nbsp;
                                        <td><input type="radio" name="type" value="1"/>通讯社交</td>&nbsp;
                                        <td><input type="radio" name="type" value="2"/>影音播放</td>&nbsp;
                                        <td><input type="radio" name="type" value="3"/>新闻阅读</td>&nbsp;
                                        <td><input type="radio" name="type" value="4"/>摄影图像</td>&nbsp;
                                        <td><input type="radio" name="type" value="5"/>网上购物</td>&nbsp;
                                        <td><input type="radio" name="type" value="6"/>金融理财</td>&nbsp;
                                        <td><input type="radio" name="type" value="7"/>办公商务</td>
                                    </tr>
                                </table>
                                <p style="margin: 10px 0px 0px 0px">工具自定义标签(用空格分离)：</p>
                                <input type="text" name="tag" style="background: transparent;margin: 5px 0px 0px 0px;width: 500px;color: white" value="${uptag}" /><br>
                                <p style="margin: 10px 0px 0px 0px">工具描述：</p>
                                <textarea name="describe" style="width: 500px;height: 150px;background: transparent;margin: 5px 0px 0px 0px;color: white">${tudes}</textarea><br>
                                <input type="submit" value="上传" class="act-but submit" style="color: white;width: 200px"/>
                            </form>
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
