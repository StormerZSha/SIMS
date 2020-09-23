<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户查询</title>
    <link rel="stylesheet" href="../css/user-list.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="search">
        <form action="/UserController" method="post">
            <input type="text" name="keyword" placeholder="请输入关键字">
            <input type="hidden" name="sims" value="5"/>
            <input type="submit" name="submit" value="搜索" id="searchbtn">
        </form>
    </div>
    <div class="searchdetail">
        <table id="table">
            <tr>
                <th>用户名</th>
                <th>用户邮箱</th>
                <th>注册时间</th>
                <th>用户类型</th>
                <th>权限控制</th>
                <th>删除用户</th>
            </tr>
                <c:forEach items="${requestScope.result}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.timeStr}</td>
                    <td>${user.typeStr}</td>
                    <td><a href="/UserController?sims=3&username=${user.username}" id="griant">授权</a>
                        <a href="/UserController?sims=7&username=${user.username}">撤权</a>
                    </td>
                    <td><a href="/UserController?sims=6&username=${user.username}">删除</a></td>
                </tr>
                </c:forEach>
        </table>
        <a href="#" id="btn0"></a>
        <a href="#" id="btn1">首页</a>
        <a href="#" id="btn2">上一页</a>
        <a href="#" id="btn3">下一页</a>
        <a href="#" id="btn4">尾页</a>
    </div>
</div>
</div>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/user-list.js"></script>
</body>
</html>
