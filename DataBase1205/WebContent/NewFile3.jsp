<%@page contentType="text/html"%>
<%@ page language="java" import="java.util.*" import="java.awt.*, java.awt.image.*,javax.imageio.ImageIO" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
 
            
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head >

    <meta charset="UTF-8">
    <title>Title</title>
   <script type="text/javascript">
   
  
       
   
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
            color:#9b9b9b;
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

<form name="form1" method="post" action=IncomeServelt>
                    <p>&nbsp;</p>
                     


                     



                     
                     


                    <td width="156px" height="20px"  >
                  <div align="center">起始日 期：
                        <input type="date" name="BeginTime"  size="15" min="2015-11-11" max="2017-01-01" autocomplete/>
                    </div></td>
                    <p>&nbsp;</p>
<div align="center">结束日 期：
                        <input type="date" name="Time"  size="15" min="2015-11-11" max="2017-01-01" autocomplete/>
                    </div></td>
                    <p>&nbsp;</p>
                    <p align="center">
                        &nbsp;&nbsp;<input name="Sub1" type="submit" id="Sub1" value="查询" onClick="od()"   class="style4">
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="Sub2" type="submit" id="Sub2" value="取消" class="style4">
                    </p>
                 
                </form>
                
                <form name="form2" method="post" action=AllIncomeServelt>
                <p align="center">   <input name="Sub3" type="submit" id="Sub3" value="查看收入明细"   class="style4"></p>
                </form>
                <center>
                <p> 全年总收入为：</p>
                <p><%=session.getAttribute("all")%></p>
                
                
                
                
                
                
                
          
                <p align="center">&nbsp;</p>
                
                
                
                
                <table width="200" border="1" align="center" cellpadding="1" cellspacing="1">
                    <tr>
                        <td width="70" height="32"><div align="center">月份</div></td>
                        <td width="82"><div align="center">收入</div></td>
                       
                    </tr>
                
 
                    
                    <c:forEach  var="main" items="${main}" >
                        <tr>
                            <td height="32" align="center">&nbsp;${main.month}</td>
                            <td align="center">&nbsp;${main.income}</td>
                            
 
                        </tr>
                    </c:forEach>
                    
                    
                    
                   
          
    </table>
    
                </center>
                
                


           
           
           
       
        </div>

    </div>

</div>



</body>

</html>