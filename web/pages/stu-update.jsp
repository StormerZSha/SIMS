<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>学生注册更新</title>
    <link rel="stylesheet" href="../css/stu-update.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
        <div class="stuupdate">
            <div class="stumessage">
                <span>学号：</span><span>${student.sno}</span>
                <span>姓名：</span><span>${student.name}</span>
                <span>性别：</span><span>${student.sexStr}</span>
            </div>
            <div class="update">
                <form action="/StudentController?sims=7&studentid=${student.id}" method="post">
                    <span>专业：</span><select name="specialityid">
                                         <c:forEach items="${spe}" var="s">
                                            <option  value="${s.id}">${s.name}</option>
                                         </c:forEach>
                                        </select><br>
                    <span>宿舍：</span><select class="speselect" name="dormitoryid">
                                         <c:forEach items="${dor}" var="d">
                                            <option  value="${d.id}">${d.dno}</option>
                                         </c:forEach>
                                        </select><br/><br/>
                    <input type="submit"  value="提交" id="addbtn">
                </form>
            </div>
        </div>
</div>
</body>
</html>
