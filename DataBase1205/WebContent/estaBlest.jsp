<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head >

    <meta charset="UTF-8">
    <title>Title</title>


     <style type="text/css">
         *{padding:0;margin:0}


    body {

    }
    .style1 {
        font-size: 50px;
        color: #FF0000;


    }

    #container{width:100%;height:700px;margin:0px  auto;}
    #banner{width:100%;height:10%;background-color:#9b9b9b;}
    #body{width:100%;height:100%;}
    #left{width:20%;height:100%;float:left;background-color: #2a3342;}
    #middle{width:80%;height:100%;float:left;background-color: #f4f2f0}


    a:link {
        color:#9F9D81;
        text-decoration:underline;
    }
    a:visited {
        color:#b8c9f1;
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



</style>
<body>

<div id="container">
    <div id="banner">

        <p align="center" class="style1"> 管理员登陆界面</p>

        <p>&nbsp;</p>
    </div>
    <div id="body">
        <div id="left">


           <p align="center"   class="style1"><a href="FlightServlet"   style="text-decoration:none">制定航班</a></p>

            <p align="center"  class="style1"><a href="HavingServlet"  style="text-decoration:none">安排航班</a></p>
            <p align="center"  class="style1"> <a href="DestineServlet?param=2"  style="text-decoration:none">查看航班</a></p>
            <p align="center"  class="style1"> <a href="NewFile1.jsp"  style="text-decoration:none">查看收入</a></p>
       

        </div>


        <div id="middle">
<center>

    <p align="center">&nbsp;</p>
    <p align="center">制定航班成功!</p>
    <p align="center">&nbsp;</p>

</center>
        </div>

    </div>

</div>



</body>

</html>