<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>课程查询</title>
    <link rel="stylesheet" href="../css/cou-list.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="search">
        <form action="/CourseController" method="post">
            <input type="text" name="keyword" placeholder="请输入关键字">
            <input type="hidden" name="sims" value="1"/>
            <input type="submit" name="submit" value="搜索" id="searchbtn">
        </form>
    </div>
    <div class="searchdetail">
        <table id="table">
            <tr>
                <th>名称</th>
                <th>学分</th>
                <th>考查方式</th>
                <th>删除课程</th>
            </tr>
            <c:forEach items="${requestScope.result}" var="course">
                <tr>
                    <td>${course.name}</td>
                    <td>${course.cridit}</td>
                    <td>${course.checkStr}</td>
                    <td><a href="/CourseController?sims=3&courseid=${course.id}">删除</a></td>
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
