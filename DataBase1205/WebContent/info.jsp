<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head >
    <meta charset="UTF-8">
    <script type="text/javascript">


        function User()
        {
            var f=document.form1;


            if(f.Name.value=="")
            {
                alert("��������Ϊ��");
                f.Name.focus();
                f.Name.select();
                return false;
            }

            if(isNaN(f.Name.value))
            {
                if((f.Name.value.length)<2 || (f.Name.value.length)>10)
                {
                    alert("�������������������");
                    f.Name.focus();
                    f.Name.select();
                    return false;
                }
            }
            else
            {
                alert("��������Ϊ����");
                f.Name.focus();
                f.Name.select();
                return false;
            }



            if(f.Tel.value=="")
            {
                alert("�绰����Ϊ��");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
            if((f.Tel.value.length)<8 || (f.Tel.value.length)>14)
            {
                alert("�绰���볤�Ȳ���ȷ");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
            if(isNaN(f.Tel.value))
            {
                alert("�绰����Ϊ����");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
            if(f.Email.value=="")
            {
                return true;
            }
            else
            {
                if(f.Email.value.indexOf("@",0)==-1)
                {
                    alert("��ַ����,��@����");
                    f.Email.focus();
                    f.Email.select();
                    return false;
                }
                if(f.Email.value.indexOf(".",0)==-1)
                {
                    alert("��ַ����,��.����");
                    f.Email.focus();
                    f.Email.select();
                    return false;
                }
            }


        }
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
        <p align="center" class="style1">������Ϣ����</p>

        <p>&nbsp;</p>
    </div>

    <div id="banner_right">
        <div id="back">   <p align="center" > <a   href="index.html" style="text-decoration:none">�˳�</a></p></div>
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
                <form name="form1" method="post" action="NoparamServlet?param=1" onsubmit="return User()">
                    <p>&nbsp;</p>
                    <table width="443" border="1" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="94" height="38"><div align="center">
                                <p>��&nbsp;�� ��:</p>
                            </div></td>
                            <td width="400">          <div align="center">
                                <input name="Username" type="text" id="yonghu" size="20" readonly="true" value="${user.username}"/>
                            </div></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">��ʵ����:</div></td>
                            <td><div align="center">
                                <input name="Name" type="text" id="xingbin" size="20" value="${user.name}">
                            </div></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">�� &nbsp;&nbsp;��:</div></td>
                            <td><div align="center">

                                <select name="Sex" >
                                    <option value="${ho}" >${ho}</option>
                                    <option value="${mo}">${mo}</option>

                                </select>


                            </div></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">�绰����:</div></td>
                            <td><div align="center">
                                <input name="Tel" type="text" id="zhengjian" size="20" value="${user.tel}">
                            </div></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">�����ʼ�:</div></td>
                            <td><div align="center">
                                <input name="Email" type="text" id="Emil" size="20" value="${user.email}">
                            </div></td>
                        </tr>
                    </table>
                    <p align="center">
                        <input type="submit" name="Submit" value="�޸�">


                    </p>
                </form>


            </center>
        </div>

    </div>

</div>



</body>

</html>
