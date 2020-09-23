<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>专业注册更新</title>
    <link rel="stylesheet" href="../css/spe-update-off.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="speupdate">
        <div class="spemessage">
            <span>专业名称：</span><span>${spe.name}</span>
            <span>所属院系：</span><span>${spe.faculty}</span>
            <span>专业类型：</span><span>${spe.type}</span>
        </div>
        <div class="update">
            <h2>专业学生</h2>
            <form action="/SpecialityController?sims=6&specialityid=${spe.id}" method="post">
                <!--显示没有专业的所有学生-->
                <table>
                    <tr>
                        <th></th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>生日</th>
                        <th>性别</th>
                    </tr>
                    <c:forEach items="${student}" var="stu">
                        <tr>
                            <td><input type="checkbox" name="studentid" value="${stu.id}"></td>
                            <td>${stu.sno}</td>
                            <td>${stu.name}</td>
                            <td>${stu.birthdayStr}</td>
                            <td>${stu.sexStr}</td>
                        </tr>
                    </c:forEach>
                </table>

                <input type="submit"  value="添加" id="addbtn">
            </form>
        </div>
    </div>
</div>
</body>
</html>
