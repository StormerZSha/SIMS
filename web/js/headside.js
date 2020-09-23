//变量统一定义
var usermanner=document.getElementById("usermanner");
var userul=document.getElementById("userul");
var userli=userul.getElementsByTagName("li");
var stumanner=document.getElementById("stumanner");
var stuul=document.getElementById("stuul");
var stuli=stuul.getElementsByTagName("li");
var teamanner=document.getElementById("teamanner");
var teaul=document.getElementById("teaul");
var teali=teaul.getElementsByTagName("li");
var spemanner=document.getElementById("spemanner");
var speul=document.getElementById("speul");
var speli=speul.getElementsByTagName("li");
var coumanner=document.getElementById("coumanner");
var couul=document.getElementById("couul");
var couli=couul.getElementsByTagName("li");
var dormanner=document.getElementById("dormanner");
var dorul=document.getElementById("dorul");
var dorli=dorul.getElementsByTagName("li");

//用户管理
usermanner.setAttribute("flag","1");//设置标志
usermanner.onclick=function () {//点击改变背景
    if (usermanner.getAttribute("flag") == "1") {
        usermanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        for (var i=0;i<userli.length;i++){
            userli[i].style.height="26px";
            userli[0].children[0].innerText="用户查询";
            userli[1].children[0].innerText="用户添加";
        }
        usermanner.style.marginBottom="62px";
        usermanner.setAttribute("flag", "0");
    } else if (usermanner.getAttribute("flag") == "0") {
        usermanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        for (var i=0;i<userli.length;i++){
            userli[i].style.height="0px";
            userli[i].children[0].innerText="";
        }
        usermanner.style.marginBottom="2px";
        usermanner.setAttribute("flag", "1");
    }
};

//学生管理
stumanner.setAttribute("flag","1");//设置标志
stumanner.onclick=function () {//点击改变背景
    if (stumanner.getAttribute("flag") == "1") {
        stumanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        for (var i=0;i<stuli.length;i++){
            stuli[i].style.height="26px";
            stuli[0].children[0].innerText="学生查询";
            stuli[1].children[0].innerText="学生添加";
        }
        stumanner.style.marginBottom="62px";
        stumanner.setAttribute("flag", "0");
    } else if (stumanner.getAttribute("flag") == "0") {
        stumanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        for (var i=0;i<stuli.length;i++){
            stuli[i].style.height="0px";
            stuli[i].children[0].innerText="";
        }
        stumanner.style.marginBottom="2px";
        stumanner.setAttribute("flag", "1");
    }
};

//教师管理
teamanner.setAttribute("flag","1");//设置标志
teamanner.onclick=function () {//点击改变背景
    if (teamanner.getAttribute("flag") == "1") {
        teamanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        for (var i=0;i<teali.length;i++){
            teali[i].style.height="26px";
            teali[0].children[0].innerText="教师查询";
            teali[1].children[0].innerText="教师添加";
        }
        teamanner.style.marginBottom="62px";
        teamanner.setAttribute("flag", "0");
    } else if (teamanner.getAttribute("flag") == "0") {
        teamanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        for (var i=0;i<teali.length;i++){
            teali[i].style.height="0px";
            teali[i].children[0].innerText="";
        }
        teamanner.style.marginBottom="2px";
        teamanner.setAttribute("flag", "1");
    }
};


//专业管理
spemanner.setAttribute("flag","1");//设置标志
spemanner.onclick=function () {//点击改变背景
    if (spemanner.getAttribute("flag") == "1") {
        spemanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        for (var i=0;i<speli.length;i++){
            speli[i].style.height="26px";
            speli[0].children[0].innerText="专业查询";
            speli[1].children[0].innerText="专业添加";
        }
        spemanner.style.marginBottom="62px";
        spemanner.setAttribute("flag", "0");
    } else if (spemanner.getAttribute("flag") == "0") {
        spemanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        for (var i=0;i<speli.length;i++){
            speli[i].style.height="0px";
            speli[i].children[0].innerText="";
        }
        spemanner.style.marginBottom="2px";
        spemanner.setAttribute("flag", "1");
    }
};
//课程管理
coumanner.setAttribute("flag","1");//设置标志
coumanner.onclick=function () {//点击改变背景
    if (coumanner.getAttribute("flag") == "1") {
        coumanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        for (var i=0;i<couli.length;i++){
            couli[i].style.height="26px";
            couli[0].children[0].innerText="课程查询";
            couli[1].children[0].innerText="课程添加";
        }
        coumanner.style.marginBottom="62px";
        coumanner.setAttribute("flag", "0");
    } else if (coumanner.getAttribute("flag") == "0") {
        coumanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        for (var i=0;i<couli.length;i++){
            couli[i].style.height="0px";
            couli[i].children[0].innerText="";
        }
        coumanner.style.marginBottom="2px";
        coumanner.setAttribute("flag", "1");
    }
};

//宿舍管理
dormanner.setAttribute("flag","1");//设置标志
dormanner.onclick=function () {//点击改变背景
    if (dormanner.getAttribute("flag") == "1") {
        dormanner.style.backgroundImage = "url('../img/menufolderactive.jpg')";
        for (var i=0;i<dorli.length;i++){
            dorli[i].style.height="26px";
            dorli[0].children[0].innerText="宿舍查询";
            dorli[1].children[0].innerText="宿舍添加";
        }
        dormanner.style.marginBottom="62px";
        dormanner.setAttribute("flag", "0");
    } else if (dormanner.getAttribute("flag") == "0") {
        dormanner.style.backgroundImage = "url('../img/menufolder.jpg')";
        for (var i=0;i<dorli.length;i++){
            dorli[i].style.height="0px";
            dorli[i].children[0].innerText="";
        }
        dormanner.style.marginBottom="2px";
        dormanner.setAttribute("flag", "1");
    }
};



