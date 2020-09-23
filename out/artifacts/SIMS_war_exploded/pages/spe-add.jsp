<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>专业添加</title>
    <link rel="stylesheet" href="../css/spe-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="/SpecialityController" method="post">
            <input type="hidden" name="sims" value="2">
            <span>名      称:</span><input type="text" name="name" id="nameadd" ><br/>
            <span>院      系:</span><input type="text" name="faculty" id="facultyadd" ><br/>
            <span>类      型:</span><input type="radio" name="type" value="0" class="typeinput">普通
                                     <input type="radio" name="type" value="1" class="typeinput">重点<br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
