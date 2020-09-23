<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生查询</title>
    <link rel="stylesheet" href="../css/stu-list.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="search">
        <form action="/StudentController" method="post">
            <input type="text" name="keyword" placeholder="请输入关键字">
            <input type="hidden" name="sims" value="1"/>
            <input type="submit" name="submit" value="搜索" id="searchbtn">
        </form>
    </div>
    <div class="searchdetail">
        <table id="table">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>生日</th>
                <th>专业</th>
                <th>宿舍</th>
                <th>详情</th>
                <th>注册更新</th>
                <th>删除用户</th>
            </tr>
            <c:forEach items="${requestScope.result}" var="student">
                <tr>
                    <td>${student.sno}</td>
                    <td>${student.name}</td>
                    <td>${student.sexStr}</td>
                    <td>${student.birthday}</td>
                    <td>${student.speciality.name}</td>
                    <td>${student.dormitory.dno}</td>
                    <td><a href="${pageContext.request.contextPath}/StudentController?sims=4&studentid=${student.id}" id="detail">详情</a></td>
                    <td><a href="/StudentController?sims=6&studentid=${student.id}" id="update">注册更新</a></td>
                    <td><a href="${pageContext.request.contextPath}/StudentController?sims=3&studentid=${student.id}">删除</a></td>
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
