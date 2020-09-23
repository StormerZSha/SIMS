
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍添加</title>
    <link rel="stylesheet" href="../css/dor-add.css">
</head>
<body>
<jsp:include page="headerside.jsp"></jsp:include>
<div class="main">
    <div class="mainbg"></div>
    <div class="mainshadow"></div>
    <div class="addlist">
        <form action="/DormitoryController" method="post">
            <input type="hidden" name="sims" value="2">
            <span>宿舍号:</span><input type="text" name="dno" id="dnoadd" ><br/>
            <span>类&nbsp;&nbsp;&nbsp;型:</span><select class="dorselect" name="type">
                                        <option name="单人间" value="0">单人间</option>
                                        <option name="四人间" value="1">四人间</option>
                                        <option name="六人间" value="2">六人间</option>
                                        <option name="八人间" value="3">八人间</option>
                                     </select><br/>
            <input type="submit"  value="添加" id="addbtn">
        </form>
    </div>
</div>
</body>
</html>
