<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
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
    .style4 {
        border:none;
       background: #ff4445;
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






<p align="center">  管理员登陆</p>




<form name="form1" method="post" action="AdminServlet">



            <td width="156px" height="20px"><div align="center">&nbsp;Login：
                <input name="Username" type="text" id="Username" size="15"   required>
            </div></td>
    <p>&nbsp;</p>



            <td  width="156px" height="20px"><div align="center"  >PassWord:
                <input name="password" type="password" id="Password" size="15" required>
            </div></td>


    <p align="center">
        &nbsp;&nbsp;<input name="Sub1" type="submit" id="Sub1" value="提交" onClick="od()"  class="style4">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input name="Sub2" type="submit" id="Sub2" value="重置" class="style4"d>
    </p>
</form>
    </div>
        <div id="right">

        </div>
    </div>
    </div>











</body>
</html>
