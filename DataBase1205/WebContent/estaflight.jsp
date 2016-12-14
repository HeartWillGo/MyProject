<%@page contentType="text/html"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript">
        function add()
        {
            var f=document.form1;
            if(f.Qifei.value==f.Mudi.value)
            {
                alert("起飞地点和目的地不能相同");

                return false;
            }
        }
        
    </script>

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

</head>

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

            <form name="form1" method="post"  align="center" action="SchedServlet"  onsubmit="return add()">
              <center>  <table width="400" border="1" align="center" cellpadding="1" cellspacing="1">
                    <tr>
                        <td width="150" height="30" align="center">航班号</td>
                        <td width="250"><div align="center">
                            <select name="Hao">
                                <c:forEach var="flight" items="${a}">
                                    <option value="${flight}">${flight}</option>
                                </c:forEach>

                            </select>
                        </div></td>
                    </tr>

                    <tr>
                        <td height="30" align="center">起飞地点</td>
                        <td><div align="center"><select name="Qifei" >
                            <option value="武汉">武汉</option>
                            <option value="北京">北京</option>
                            <option value="上海">上海</option>
                            <option value="长沙">长沙</option>
                            <option value="深圳">深圳</option>
                            <option value="南京">南京</option>
                            <option value="福州">福州</option>
                            <option value="大连">大连</option>
                            <option value="天津">天津</option>
                            <option value="广州">广州</option>
                        </select></div></td>
                    </tr>


                    <tr>
                        <td height="30" align="center">日期</td>
                        <td><div align="center">
                            <input type="date" name="Time"  min="2016-11-11" max="2017-01-01"/>
                        </div></td>
                    </tr>






                    <tr>
                        <td height="30" align="center">目的地点</td>
                        <td><div align="center">
                            <select name="Mudi">
                                <option value="北京">北京</option>
                                <option value="上海">上海</option>
                                <option value="长沙">长沙</option>
                                <option value="深圳">深圳</option>
                                <option value="南京">南京</option>
                                <option value="福州">福州</option>
                                <option value="大连">大连</option>
                                <option value="天津">天津</option>
                                <option value="广州">广州</option>

                            </select></div>
                        </td>
                    </tr>
                    <tr>
                        <td height="30" align="center">旅程(小时)</td>
                        <td><div align="center">

                            <select name="Lchen">
                                <c:forEach var="h" items="${b}">
                                    <option value="${h}">${h}</option>
                                </c:forEach>
                        </div></td>
                    </tr>
                    <tr>
                        <td height="30" align="center">价格(￥)</td>
                        <td><div align="center">
                            <select name="Jiage">
                                <c:forEach var="mon" items="${c}">
                                    <option value="${mon}">${mon}</option>
                                </c:forEach>

                        </div></td>
                    </tr>
                    <tr>
                        <td height="30" align="center">票数(张)</td>
                        <td><div align="center">
                            <select name="Piaosu">
                                <c:forEach var="piao" items="${d}">
                                    <option value="${piao}">${piao}</option>
                                </c:forEach>

                        </div></td>
                    </tr>
                </table>
              </center>
                <p align="center">
                    <input name="tijiao" type="submit" id="tijiao" value="提交">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="chongzhi" type="reset" id="chongzhi" value="重置">
                </p>
                <p align="center">&nbsp;</p>
            </form>
        </div>

    </div>

</div>



</body>

</html>

