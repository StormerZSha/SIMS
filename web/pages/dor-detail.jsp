<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>宿舍详情</title>
    <link rel="stylesheet" href="../css/dor-detail.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="dordetail">
        <h2>宿舍详情</h2>
        <table id="table">
            <tr>
                <th>宿舍号</th>
                <td>${dor.dno}</td>
            </tr>
            <tr>
                <th>宿舍类型</th>
                <td>${dor.typeStr}</td>
            </tr>
        </table>
        <h2>宿舍学生</h2>
        <table id="table2">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>生日</th>
            </tr>
            <c:forEach items="${dor.students}" var="student">
                <tr>
                    <td>${student.sno}</td>
                    <td>${student.name}</td>
                    <td>${student.sexStr}</td>
                    <td>${student.birthdayStr}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>
