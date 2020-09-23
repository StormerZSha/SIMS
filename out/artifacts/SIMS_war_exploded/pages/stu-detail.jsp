<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生详情</title>
    <link rel="stylesheet" href="../css/stu-detail.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="studetail">
        <h2>学生详情</h2>
        <table id="table">
            <tr>
                <th>学号</th>
                <td>${student.sno}</td>
            </tr>
            <tr>
                <th>姓名</th>
                <td>${student.name}</td>
            </tr>
            <tr>
                <th>性别</th>
                <td>${student.sexStr}</td>
            </tr>
            <tr>
                <th>生日</th>
                <td>${student.birthdayStr}</td>
            </tr>
            <tr>
                <th>专业名</th>
                <td>${student.speciality.name}</td>
            </tr>
            <tr>
                <th>培养类型</th>
                <td>${student.speciality.typeStr}</td>
            </tr>
            <tr>
                <th>院系</th>
                <td>${student.speciality.faculty}</td>
            </tr>
            <tr>
                <th>宿舍号</th>
                <td>${student.dormitory.dno}</td>
            </tr>
            <tr>
                <th>宿舍类型</th>
                <td>${student.dormitory.typeStr}</td>
            </tr>
        </table>
    </div>
    </div>
</div>
</body>
</html>
