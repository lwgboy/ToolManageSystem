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
</head>
<body>
<form action="" method="post" enctype="multipart/form-data">
    上传工具<br>
    <input type="file" name="file" class="text">
    <br>
    <br>
    上传工具说明<br>
    工具名称：<input type="text" name="name" /><br>
    工具版本：<i>V</i>
    <input type="text" name="version1" style="border: 0px;width: 20px" />.
    <input type="text" name="version2" style="border: 0px;width: 20px" />.
    <input type="text" name="version3" style="border: 0px;width: 20px" />
    &nbsp;&nbsp;<i>(版本号示例：<b>V1.0.0</b>)</i><br>
    工具类别：
    <table>
        <tr>
            <td><input type="radio" checked="checked" name="type" value="0"/>系统工具</td>
            <td><input type="radio" name="type" value="1"/>通讯社交</td>
            <td><input type="radio" name="type" value="2"/>影音播放</td>
            <td><input type="radio" name="type" value="3"/>新闻阅读</td>
            <td><input type="radio" name="type" value="4"/>摄影图像</td>
            <td><input type="radio" name="type" value="5"/>考试学习</td>
            <td><input type="radio" name="type" value="6"/>网上购物</td>
            <td><input type="radio" name="type" value="7"/>金融理财</td>
            <td><input type="radio" name="type" value="8"/>生活休闲</td>
            <td><input type="radio" name="type" value="9"/>旅游出行</td>
            <td><input type="radio" name="type" value="10"/>办公商务</td>
        </tr>
    </table>
    工具自定义标签(用空格分离)：<input type="text" name="tag" /><br>
    工具描述：<br>
    <textarea name="describe" style="width: 500px;height: 150px"></textarea><br>
    <br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
