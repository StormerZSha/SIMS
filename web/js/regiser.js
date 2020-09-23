var tologin=document.getElementById("tologin");
tologin.onmouseover=function () {//去注册的颜色的变化
    this.style.color="#ff0000";
};
tologin.onmouseout=function () {
    this.style.color="#000";
};

var username=document.getElementById("username");
var usermessage=document.getElementById("usermessage");
var password=document.getElementById("password");
var passmessage=document.getElementById("passmessage");
var email=document.getElementById("email");
var emailmessage=document.getElementById("emailmessage");
var registerbtn=document.getElementById("registerbtn");
registerbtn.onclick=function () {//注册验证
    var flag=true;
    if (!checkuser()) flag=false;
    if (!checkpass()) flag=false;
    return flag;
};
function checkuser() {
    if (username.value==""){
        usermessage.innerText="用户名不能为空";
        usermessage.style.color="#d00";
        usermessage.style.fontSize="14px";
        usermessage.style.lineHeight="40px";
        return false;
    } else{
        usermessage.innerText="";
        return true;
    }
}
function checkpass() {
    if (password.value==""){
        passmessage.innerText="密码不能为空";
        passmessage.style.color="#d00";
        passmessage.style.fontSize="14px";
        passmessage.style.lineHeight="40px";
        return false;
    } else {
        passmessage.innerText="";
        return true;
    }
}
function checkemail() {
    if (email.value=="") {
        emailmessage.innerText="邮箱不能为空";
        emailmessage.style.color="#d00";
        emailmessage.style.fontSize="14px";
        emailmessage.style.lineHeight="40px";
        return false;
    }else{
        emailmessage.innerText="";
        return true;
    }
}
var codeImage=document.getElementById("codeImage");
codeImage.onclick=function () {
    this.src=this.src+"?"+Math.random();
};