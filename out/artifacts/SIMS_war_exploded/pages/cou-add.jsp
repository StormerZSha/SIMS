
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程添加</title>
    <link rel="stylesheet" href="../css/cou-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="/CourseController" method="post">
            <input type="hidden" name="sims" value="2">
            <span>名      称:</span><input type="text" name="name" id="nameadd" ><br/>
            <span>学      分:</span><input type="text" name="cridit" id="criditadd"><br/>
            <span>考察方式  :</span><input type="radio" name="type" value="0" class="checkinput">考查
                                     <input type="radio" name="type" value="1" class="checkinput">考试<br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
