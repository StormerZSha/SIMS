

///翻页功能
var pageSize=10;//每页数量
var curPage=0;//当前页
var lastPage=0;//最后页
var direct=0;//方向
var len;//总量
var page;//总页数
var begin;
var end;
$(document).ready(function display() {
    len=$("#table tr").length;//求总行数
    page=len%pageSize==0?len/pageSize:Math.floor(len/pageSize)+1;//求页数
    curPage=1;//设置当前为第一页
    displayPage(1);//显示第一页

    $("#btn0").innerHTML="当前"+curPage+"/"+page+"页";

    $("#btn1").click(function firstPage(){//首页
        curPage=1;
        direct=0;
        displayPage();
    });

    $("#btn2").click(function frontPage(){//上一页
        direct=-1;
        displayPage();
    });

    $("#btn3").click(function nextPage(){//下一页
        direct=1;
        displayPage();
    });

    $("#btn4").click(function lastPage(){//尾页
        curPage=page;
        direct=0;
        displayPage();
    });
});

function displayPage(){
    if (curPage<=1&&direct==-1) {
        direct=0;
        alert("已经时第一页了");
        return;
    }else if(curPage>=page&&direct==1){
        direct=0;
        alert("已经是最后一页了");
        return;
    }
    lastPage=curPage;
    if (len>pageSize) {//修复len=0时，curPage为0的情况
        curPage=((curPage+direct+len)%len);
    }else{
        curPage=1;
    }
    $("#btn0").innerHTML="当前"+curPage+"/"+page+"页";


    begin=(curPage-1)*pageSize+1;//起始记录
    end=begin+1*pageSize;//末尾记录

    if (end>len) end=len;
    $("table tr").hide();//先隐藏
    $("table tr").each(function(i){//判断是否恢复
        if ((i>=begin&&i<end)||i==0) {//显示起始和末尾之间的记录
            $(this).show();
        }
    });
}