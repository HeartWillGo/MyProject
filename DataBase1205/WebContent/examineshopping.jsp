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
    <script type="text/javascript">



    </script>


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

        <p align="center" class="style1">个人信息管理</p>

        <p>&nbsp;</p>
    </div>

    <div id="banner_right">
        <div id="back">   <p align="center" > <a   href="index.html" style="text-decoration:none">退出</a></p></div>
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
            <center>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;</p>
                <table width="800" border="1" align="center" cellpadding="1" cellspacing="1">
                    <tr>
                        <td width="70" height="32"><div align="center">航班号</div></td>
                        <td width="100"><div align="center">出发地点</div></td>
                        <td width="100"><div align="center">目的地</div></td>
                        <td width="150"><div align="center">航班日期</div></td>
                         <td width="150"><div align="center">姓名</div></td>
                          <td width="150"><div align="center">身份证号</div></td>
                        <td width="83"><div align="center">票价</div></td>
                        <td width="83"><div align="center">订票数</div></td>
                        <td width="91"><div align="center">退订</div></td>
                    </tr>
                    <c:forEach var="ary" items="${ary}">
                        <tr>
                            <td height="32" align="center">&nbsp;${ary.hao}</td>
                            <td align="center">&nbsp;${ary.qifei}</td>
                            <td align="center">&nbsp;${ary.mudi}</td>
                            <td align="center">&nbsp;${ary.rqi}</td>
                            <td align="center">&nbsp;${ary.name}</td>
                            <td align="center">&nbsp;${ary.idCard}</td>
                            <td align="center">&nbsp;${ary.jiage}</td>
                            <td align="center">&nbsp;${ary.piaosu}</td>
                            <td align="center">&nbsp;<a href=RecedServlet?hao=${ary.hao}>退票</td>
                        </tr>
                    </c:forEach>
                </table>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;</p>
                <p align="center">&nbsp;*如须退票,请用户在至少在规定航班日期前一天退票.</p>
                <p align="center">&nbsp;超过规定期限,本系统不予票.</p>
            </center>
        </div>

    </div>

</div>



</body>

</html>
