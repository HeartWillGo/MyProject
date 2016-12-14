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
            color:#00FF00;
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
            <p align="center"  class="style1"> <a href="NewFile1.jsp"  style="text-decoration:none">查看收入</a></p>
       


        </div>


        <div id="middle">
            <form name="forml" method="post" action="ArrangeServlet"  onsubmit="return copy()">
              <center> <table width="370" height="111" border="1" align="center" cellpadding="1" cellspacing="1">
                    <tr>
                        <td width="142" height="55"><div align="center">航班号</div></td>
                        <td width="373"><div align="center">
                            <select name="Hao">
                                <c:forEach var="sss" items="${tes}">
                                    <option value="${sss.hao}">${sss.hao}</option>
                                </c:forEach>

                            </select>

                        </div></td>
                    </tr>
                    <tr>
                        <td height="30" align="center">设定日期</td>
                        <td><div align="center">
                            <input type="date" name="user"  min="2016-11-11" max="2017-01-01"/>
                        </div></td>
                    </tr>
                </table>
              </center>
                <p align="center">
                    <input name="submit" type="submit" id="sheding" value="设定" >
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="quxiao" type="reset" id="quxiao" value="取消">
                </p>
            </form>
        </div>

    </div>

</div>



</body>

</html>

