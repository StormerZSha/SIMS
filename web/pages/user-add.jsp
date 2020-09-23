<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户添加</title>
    <link rel="stylesheet" href="../css/user-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="/UserController" method="post">
            <input type="hidden" name="sims" value="4">
            <span>用户名:</span><input type="text" name="username" id="usernameadd" ><br/>
            <span>邮&nbsp;&nbsp;&nbsp;箱:</span><input type="text" name="email" id="emailadd"><br/>
            <span>用户类型:</span><input type="radio" name="type" id="admin" value="1">管理员
            <input type="radio" name="type" id="user" value="0">普通用户<br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
