<%@page import="com.dao.Sched"%>
<%@page contentType="text/html"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
            #banner{width:90%;height:10%;float:left;background-color:#9b9b9b;}
            #banner_right{width:10%;height:10%;float:left;background-color:#9b9b9b;}
            #body{width:100%;height:100%;}
            #left{width:20%;height:100%;float:left;background-color: #4A4A4A;}
            #middle{width:80%;height:100%;float:left;background-color: #f4f2f0}


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
            #back a:link {
                color:#000000;
                text-decoration:underline;
            }
            #back a:visited {
                color:#000000;
                text-decoration:none;
            }
            #back a:hover {
                color: #ffffff;;
                text-decoration:none;
            }
            #back a:active {
                color:#000000;
                text-decoration:none;
            }



        </style>
<body>
 
<div id="container">
    <div id="banner">

        <p align="center" class="style1"> 个人信息管理</p>

        <p>&nbsp;</p>
    </div>
    <div id="body">
        <div id="left">

 <p>&nbsp;</p>

            <p align="center"  class="style1"><a href="index.html" style="text-decoration:none">首页</a></p>
            <p align="center"   class="style1"><a href="ModifySerlvet?param=0" style="text-decoration:none">修改个人信息</a></p>
            <p align="center"   class="style1"><a href="passwordamend.jsp" style="text-decoration:none">密码修改</a></p>
            <p align="center"  class="style1"><a href="DestineServlet?param=1" style="text-decoration:none">预订机票</a></p>
            <p align="center"   class="style1"><a href="ExamineSerlvet" style="text-decoration:none">我的订单</a></p>
            <p align="center"   class="style1"><a href="index.html" style="text-decoration:none">退出</a></p>


            <p>&nbsp;</p>

        </div>


        <div id="middle">

            <div id="top">


                <form name="form1" method="post" action=QuryServlet>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>


                    <td width="156px" height="20px"><div align="center">起&nbsp;点：
                        <input name="QiDian" type="text" id="QiDian" size="15"   required autocomplete>
                    </div></td>
                    <p>&nbsp;</p>



                    <td  width="156px" height="20px"><div align="center"  >终&nbsp;点：
                        <input name="Zhongdian" type="text" id="Zhongdian" size="15" required   autocomplete>
                    </div></td>
                    <p>&nbsp;</p>


                    <td width="156px" height="20px"  >
                  <div align="center">日&nbsp;期：
                        <input type="date" name="Time"  size="15" min="2016-11-11" max="2017-01-01" autocomplete/>
                    </div></td>
                    <p>&nbsp;</p>

                    <p align="center">
                        &nbsp;&nbsp;<input name="Sub1" type="submit" id="Sub1" value="查询" onClick="od()"   class="style4">
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="Sub2" type="submit" id="Sub2" value="取消" class="style4">
                    </p>
                </form>

            </div>


            <center>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;</p>
                <table width="593" border="1" align="center" cellpadding="1" cellspacing="1">
                    <tr>
                        <td width="70" height="32"><div align="center">航班号</div></td>
                        <td width="82"><div align="center">出发地点</div></td>
                        <td width="100"><div align="center">目的地</div></td>
                        <td width="130"><div align="center">航班日期</div></td>
                        <td width="83"><div align="center">票价</div></td>
                        <td width="70"><div align="center">总票数</div></td>
                        <td width="91"><div align="center">预定</div></td>
                    </tr>
                

                    
                    
                    
                    
                    <c:forEach  var="sch" items="${list2}" >
                        <tr>
                            <td height="32" align="center">&nbsp;${sch.hao}</td>
                            <td align="center">&nbsp;${sch.qifei}</td>
                            <td align="center">&nbsp;${sch.mudi}</td>
                            <td align="center">&nbsp;${sch.rqi}</td>
                            <td align="center">&nbsp;${sch.jiage}</td>
                            <td align="center">&nbsp;${sch.piaosu}</td>

                            <td align="center">&nbsp;<a href="AffirmServlet?hao=${sch.hao}">订票</a></td>
                        </tr>
                    </c:forEach>
                    
                   
          
    
    
    
    
    
    
     <script>



        window.onload = function () {
            var canvas = document.getElementById("myCanvas");
            var context = canvas.getContext("2d");
            //绘制弧线


 var arr=new Array();
    int index=0;
    
    
    
            a=[ 1,2,3,4,5,6,7];

            for (var i = 0;
            i < arr.length;
            i++
            )

            {
            context.beginPath();
            context.moveTo(20*i, 20*i);
            context.lineTo(5*20*i, 20*i);

            context.stroke();

        }



            context.beginPath();
            context.moveTo(250, 500);
            context.lineTo(700, 500);

            context.stroke();

            context.beginPath();
            context.moveTo(250, 500);
            context.lineTo(250, 150);

            context.stroke();
            for (var i=1;i<13;i++){
                context.fillText(i+"月",250+(i-1)*450/12,510)
            }








            





        };
    </script>
    
    
    
    
    
    
    
    
    
                </table>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;</p>
  
 
 
                    
            </center>
        </div>

    </div>

</div>



</body>

</html>

