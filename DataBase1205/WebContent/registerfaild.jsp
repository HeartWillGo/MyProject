<%@page pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <script language="javascript">
        function od()
        {
            var f=document.form1;
            if(f.Username.value=="")
            {
                alert("用户名未输入");
                f.Username.focus();
                f.Username.select();
                return;
            }
            if(f.Password.value=="")
            {
                alert("密码未输入");
                f.Password.focus();
                f.Password.select();
                return;
            }
        }
    </script>
    <style type="text/css">
        <!--
        body {
            border:none;
        }
        .style3 {
            font-size: 24pt;
            color: #FF0000;
            font-weight: bold;
        }
        -->
    </style></head>
<style type="text/css">
    <!--.link {
        color : #000000;
        text-decoration : none;
    }A.link:hover {
         color : red;
     }A.link:active {
          color : #000000;
          text-decoration : none;
      }//-->
    #Username:focus {
        border:2px solid #ff6a00;
    }
</style>
<style type="text/css">
    <!--

    #container{width:100%;height:700px;margin:0px  auto;background-color: #2a3342}

    #banner{width:90%;height:20%;float:left; }
    #banner_right{width:10%;height:20%;float:left }
    #body{width:100%;height:80%;}
    #left{width:20%;height:100%;float:left; }
    #middle{width:60%;height:100%;float:left; }
    #right{width:20%;height:100%;float:left;}
    -->
    a:link {
        color:#9F9D81;
        text-decoration:underline;
    }
    a:visited {
        color:#9F9D81;
        text-decoration:none;
    }
    a:hover {
        color: #ffffff;;
        text-decoration:none;
    }
    a:active {
        color:#000000;
        text-decoration:none;
    }
    input[type="text"]:required{
        background: #5b479f;
        border:none;
    }
    input[type="Password"]:required{
        background: #5b479f;
        border:none;
    }
    input[type="submit"]:disabled{
        background: #ff4445;
        border:none;
    }
</style>
<script language="JavaScript1.2">
    if (document.all)
        document.write('<div id="slidemenubar2" style="left:-100" onMouseover="pull()" onMouseout="draw()">')
</script> <layer id="slidemenubar" onMouseover="pull()" onMouseout="draw()"> <script language="JavaScript1.2">

</script> </layer>
<script language="JavaScript1.2">
    function regenerate(){
        window.location.reload()
    }function regenerate2(){
        if (document.layers)
            setTimeout("window.onresize=regenerate",400)
    }window.onload=regenerate2
    if (document.all){
        document.write('</div>')
        themenu=document.all.slidemenubar2.style
        rightboundary=0
        leftboundary=-150
    }else{
        themenu=document.layers.slidemenubar
        rightboundary=150
        leftboundary=10
    }function pull(){
        if (window.drawit)
            clearInterval(drawit)
        pullit=setInterval("pullengine()",50)
    }function draw(){
        clearInterval(pullit)
        drawit=setInterval("drawengine()",50)
    }function pullengine(){
        if (document.all&&themenu.pixelLeft<rightboundary)
            themenu.pixelLeft+=5
        else if(document.layers&&themenu.left<rightboundary)
            themenu.left+=5
        else if (window.pullit)
            clearInterval(pullit)
    }function drawengine(){
        if (document.all&&themenu.pixelLeft>leftboundary)
            themenu.pixelLeft-=5
        else if(document.layers&&themenu.left>leftboundary)
            themenu.left-=5
        else if (window.drawit)
            clearInterval(drawit)
    }</script>
<body>



<div id="container">
<div id="banner">

    <p align="center"   class="style1"><a href="index.html"   style="text-decoration:none">本站首页</a>&nbsp;&nbsp;
 <a href="login.jsp"  style="text-decoration:none">用户登陆</a>&nbsp;&nbsp;
   <a href="register.jsp"  style="text-decoration:none">注册用户</a>&nbsp;&nbsp;
     <a href="Adminlogin.jsp"  style="text-decoration:none">管理员通道</a>&nbsp;&nbsp;
        <a href="../index.htm"  style="text-decoration:none">其它栏目</a></p>

</div>
    <div id="banner_right">

    </div>

    <div id="body">
        <div id="left">

        </div>
    <div id="middle">






        <p>&nbsp;</p>
        <p align="center" class="style1">欢迎您注册会员</p>
        <hr>
        <form name="form1" method="post" action="">
            <p align="center"><span class="style4">注册失败!&nbsp;</span></p>
            <p align="center">&nbsp;</p>
            <p align="center"><span class="style4">请单击此<a href="register.jsp">注册</a> </span></p>
        </form>
        <p>&nbsp;</p>
    </div>
        <div id="right">

        </div>
    </div>
    </div>











</body>
</html>

