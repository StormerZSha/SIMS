
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <style type="text/css">
        img{
            width: 200px;
            height: 200px;
            margin-left: 40%;
        }
        h1{
            margin-left: 28%;
        }
    </style>
</head>
<body>
<div >
    <h1>${requestScope.massage}</h1>
    <img src="../img/fail.jpg" >
</div>
</body>
</html>
