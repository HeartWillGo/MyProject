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
        #banner{width:100%;height:10%;background-color:#9b9b9b;}
        #body{width:100%;height:100%;}
        #left{width:20%;height:100%;float:left;background-color: #2a3342;}
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

            <p align="center"  class="style1"><a href="HavingServlet"  style="text-decoration:none">修改航班</a></p>
            <p align="center"  class="style1"> <a href="DestineServlet?param=2"  style="text-decoration:none">查看航班</a></p>

 <p align="center"  class="style1"> <a href="IncomeServelt"  style="text-decoration:none">查看收入</a></p>
        </div>


        <div id="middle">
         <center><table width="593" border="1" align="center" cellpadding="1" cellspacing="1">
                <tr>
                    <td width="70" height="32"><div align="center">航班号</div></td>
                    <td width="120" ><div align="center">航班日期</div></td>
                    <td width="126" ><div align="center">出发地点</div></td>
                    <td width="108"><div align="center">目的地</div></td>
                    <td width="83"><div align="center">票价</div></td>
                    <td width="91"><div align="center">票数</div></td>
                    <td width="130"><div align="center">安排航班</a></div></td>
                    <td width="130"><div align="center">查看订票名单</a></div></td>
                </tr>
                <c:forEach var="sch" items="${sched}">
                    <tr>
                        <td height="32" align="center">&nbsp;${sch.hao}</td>
                        <td align="center">&nbsp;${sch.rqi}</td>
                        <td align="center">&nbsp;${sch.qifei}</td>
                        <td align="center">&nbsp;${sch.mudi}</td>
                        <td align="center">&nbsp;${sch.jiage}</td>
                        <td align="center">&nbsp;${sch.piaosu}</td>
                        <td align="center"><a href="InterServlet?param=${sch.hao}">安排${sch.hao}航班</a></td>
                         <td align="center"><a href="userSerchServlet?param=${sch.hao}">查看${sch.hao}名单</a></td>
                         
                         
                         
                    </tr>
                </c:forEach>
            </table>
         </center>
        </div>

    </div>

</div>



</body>

</html>

