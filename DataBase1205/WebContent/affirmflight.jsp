 <%@page contentType="text/html"%>
 
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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
        #middle{width:80%;height:100%;float:left;background-color: #dadada}
        #top{width:100%;height:40%;float:left;background-color: #dadada}

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

        <p align="center" class="style1"> ������Ϣ����</p>

        <p>&nbsp;</p>
    </div>
    <div id="body">
        <div id="left">

 <p>&nbsp;</p>

            <p align="center"  class="style1"><a href="index.html" style="text-decoration:none">��ҳ</a></p>
            <p align="center"   class="style1"><a href="ModifySerlvet?param=0" style="text-decoration:none">�޸ĸ�����Ϣ</a></p>
            <p align="center"   class="style1"><a href="passwordamend.jsp" style="text-decoration:none">�����޸�</a></p>
            <p align="center"  class="style1"><a href="DestineServlet?param=1" style="text-decoration:none">Ԥ����Ʊ</a></p>
            <p align="center"   class="style1"><a href="ExamineSerlvet" style="text-decoration:none">�ҵĶ���</a></p>
            <p align="center"   class="style1"><a href="index.html" style="text-decoration:none">�˳�</a></p>


            <p>&nbsp;</p>

        </div>



        <div id="middle">

          
 




        
         <center>
             <p align="center">&nbsp;</p>
             <p align="center">&nbsp;</p>
             <p align="center">&nbsp;</p>
             <form name="form1" method="post" action="PurchaseServlet" >
                 <table width="593" border="1" align="center" cellpadding="1" cellspacing="1">
                     <tr>
                         <td width="70" height="32"><div align="center">�����</div></td>
                         <td width="126"><div align="center">�����ص�</div></td>
                         <td width="126"><div align="center">Ŀ�ĵ�</div></td>
                         <td width="108"><div align="center">��������</div></td>
                         <td width="83"><div align="center">Ʊ��</div></td>
                         <td width="91"><div align="center">ʣ��Ʊ��</div></td>
                        
                       

                     </tr>
                     <tr>
                         <td height="32" align="center">&nbsp;${sch.hao}</td>
                         <td align="center">&nbsp;${sch.qifei}</td>
                         <td align="center">&nbsp;${sch.mudi}</td>
                         <td align="center">&nbsp;${sch.rqi}</td>
                         <td align="center">&nbsp;${sch.jiage}</td>
                         <td align="center">&nbsp;${sch.piaosu}</td>
                          
                         
                     </tr>
                 </table>
                      </form>
         <center><p>��ѡ��˿�</p></center> 
       
             <form name="form2" method="post" action="PurchaseServlet" >
          <table width="550" border="1" align="center" cellpadding="1" cellspacing="1">
                     <tr>
                         <td width="70" height="32"><div align="center">����</div></td>
                         <td width="70"><div align="center">�Ա�</div></td>
                         <td width="150"><div align="center">���֤����</div></td>
                         
                         <td width="50"><div align="center">����</div></td>
                       <td width="50"><div align="center">�Ƿ���</div></td>

                     </tr>
          
          
          
          
              <c:forEach var="listpass" items="${listpass}">
              <tr>
                                <td height="32" align="center" >&nbsp; ${listpass.name}</td>
                                  <td align="center">&nbsp;${listpass.sex}</td>
                         <td align="center">&nbsp;${listpass.idCard}</td>
                          <td align="center"> <select name="type">
                                <c:forEach var="type" items="${a}">
                                    <option value="${type}">${type}</option>
                                </c:forEach>

                            </select></td>
                           <td align="center"> <a href="PurchaseServlet?namePass=${listpass.idCard} ">����</a></td>
                         </tr>
                                </c:forEach>
                
               </table>
                 
                 </form>
                          
                  
     
                     
             
         
             <p align="center">&nbsp;</p>
             <p align="center">&nbsp;</p>
             <p align="center">&nbsp;</p>
            
              
             
             <p align="center">&nbsp;</p>
         </center>
         
        </div>

    </div>

</div>



</body>

</html>

