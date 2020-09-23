<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用学生信息管理系统！请注册</title>
    <link rel="stylesheet" href="../css/register.css">
</head>
<body>
<div class="space"></div><!--页面填充效果-->
<div class="registerdiv" id="registerdiv">
    <div class="banner">
        <h2>学生信息管理系统</h2>
    </div>
    <form action="/UserController" method="post" id="register">
        <span class="user"></span><input type="text" placeholder="请输入用户名" id="username" name="username">
        <span id="usermessage"></span>
        <span class="pass"></span><input type="password" placeholder="请输入密码" id="password" name="password">
        <span id="passmessage"></span>
        <span class="email"></span><input type="text" placeholder="请输入邮箱" id="email" name="email">
        <span id="emailmessage"></span>
        <input type="text" id="code" name="code">
        <span><img src = "/Check" id = "codeImage" alt="验证码图片"/></span>
        <input type="submit" value="注册" id="registerbtn">
        <input type="hidden" name="sims" value="1">
        <input type="hidden" name="type" value="0">
    </form>
    <input type="button" value="去登录>" id="tologin">
</div><!--注册框-->
<div class="foot"></div><!--底部框-->
<script src="../js/regiser.js"></script>
</body>
</html>

