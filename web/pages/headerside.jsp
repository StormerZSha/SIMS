
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/headside.css">
</head>
<body>
<div class="banner">
    <h2>学生信息管理系统</h2>
    <span>${username}欢迎您使用</span>
</div>
<div class="side">
    <ul class="menu">
        <li id="backmain" class="bigslide" name="backmain"><a href="${pageContext.request.contextPath}/pages/main.jsp">首页</a></li>
        <li id="usermanner" class="bigslide">用户管理
            <ul id="userul">
                <li id="userlist" name="userlist"><a href="${pageContext.request.contextPath}/UserController?sims=2"></a></li>
                <li id="useradd" name="useradd"><a href="${pageContext.request.contextPath}/pages/user-add.jsp"></a></li>
            </ul>
        </li>
        <li id="stumanner" class="bigslide">学生管理
            <ul id="stuul">
                <li id="stulist" name="stulist"><a href="${pageContext.request.contextPath}/StudentController?sims=0"></a></li>
                <li id="stuadd" name="stuadd"><a href="${pageContext.request.contextPath}/StudentController?sims=5"></a></li>
            </ul>
        </li>
        <li id="teamanner" class="bigslide">教师管理
            <ul id="teaul">
                <li id="tealist" name="tealist"><a href="${pageContext.request.contextPath}/TeacherController?sims=0"></a></li>
                <li id="teaadd" name="teaadd"><a href="${pageContext.request.contextPath}/pages/tea-add.jsp"></a></li>
            </ul>
        </li>
        <li id="spemanner" class="bigslide">专业管理
            <ul id="speul">
                <li id="spelist" name="spelist"><a href="${pageContext.request.contextPath}/SpecialityController?sims=0"></a></li>
                <li id="speadd" name="speadd"><a href="${pageContext.request.contextPath}/pages/spe-add.jsp"></a></li>
            </ul>
        </li>
        <li id="coumanner" class="bigslide">课程管理
            <ul id="couul">
                <li id="coulist" name="coulist"><a href="${pageContext.request.contextPath}/CourseController?sims=0"></a></li>
                <li id="couadd" name="couadd"><a href="${pageContext.request.contextPath}/pages/cou-add.jsp"></a></li>
            </ul>
        </li>
        <li id="dormanner" class="bigslide">宿舍管理
            <ul id="dorul">
                <li id="dorlist" name="dorlist"><a href="${pageContext.request.contextPath}/DormitoryController?sims=0"></a></li>
                <li id="doradd" name="doradd"><a href="${pageContext.request.contextPath}/pages/dor-add.jsp"></a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="space"></div>
<script src="../js/headside.js"></script>
</body>
</html>
