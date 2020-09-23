<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生添加</title>
    <link rel="stylesheet" href="../css/stu-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="/StudentController" method="post">
            <input type="hidden" name="sims" value="2">
            <span>学      号:</span><input type="text" name="sno" id="snoadd" ><br/>
            <span>姓      名:</span><input type="text" name="name" id="nameadd" ><br/>
            <span>性      别:</span><input type="radio" name="sex" value="1" class="sexinput">男
                                     <input type="radio" name="sex" value="0" class="sexinput" checked>女<br/>
            <span>生      日:</span><input type="date" name="birth" id="birthadd"><br/>
            <span>专      业:</span><select class="speselect" name="specialityid">
                                 <c:forEach items="${spe}" var="s">
                                    <option  value="${s.id}">${s.name}</option>
                                 </c:forEach>
                                     </select><br/>
            <span>宿      舍:</span><select class="speselect" name="dormitoryid">
                                <c:forEach items="${dor}" var="d">
                                    <option  value="${d.id}">${d.dno}</option>
                                </c:forEach>
        </select><br/><br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
