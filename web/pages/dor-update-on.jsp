<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>宿舍注册更新</title>
    <link rel="stylesheet" href="../css/dor-update-off.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="dorupdate">
        <div class="dormessage">
            <span>宿舍号：</span><span>${dor.dno}</span>
            <span>宿舍类型：</span><span>${dor.typeStr}</span>
        </div>
        <div class="update">
            <h2>宿舍学生</h2>
            <form action="/DormitoryController?sims=6&dormitoryid=${dor.id}" method="post">
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
                <input type="submit"  value="提交" id="addbtn">
            </form>
        </div>
    </div>
</div>
</body>
</html>
