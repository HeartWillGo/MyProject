<%@page contentType="text/html" %>
<%@page pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>ע���û�</title>
    <script language="javascript">
        function User()
        {
            var f=document.form1;
            if(f.Username.value=="")
            {
                alert("���ֲ���Ϊ��");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Username.value.substring(0,1)==" ")
            {
                alert("��һλ����Ϊ��");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Username.value.length<8)
            {
                alert("�������û����Ȳ���ȷ");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Username.value.length>12)
            {
                alert("�������û����Ȳ���ȷ");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Password.value=="")
            {
                alert("���벻��Ϊ��");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.Password.value.substring(0,1)==" ")
            {
                alert("��һλ����Ϊ��");
                f.Password.focus();
                f.Password.select();
                return false;
            }

            if(isNaN(f.Password.value)!=true)
            {
                if(f.Password.value.length>12 || f.Password.value.length<6)
                {
                    alert("���볤�Ȳ���ȷ");
                    f.Password.focus();
                    f.Password.select();
                    return false;

                }
            }
            else
            {
                alert("�������Ϊ����");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.Password.value.indexOf("-",0)>=0 || f.Password.value.indexOf("+",0)>=0)
            {
                alert("���ܳ���+ - ��");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.password2.value=="")
            {
                alert("���벻��Ϊ��");
                f.password2.focus();
                f.password2.select();
                return false;
            }
            if(f.password2.value.substring(0,1)==" ")
            {
                alert("��һλ����Ϊ��");
                f.password2.focus();
                f.password2.select();
                return false;
            }
            if(f.password2.value!=f.Password.value)
            {
                alert("���벻һ��!");
                f.password2.focus();
                f.password2.select();
                return false;
            }
            if(f.Name.value=="")
            {
                alert("��������Ϊ��");
                f.Name.focus();
                f.Name.select();
                return false;
            }
            if(f.Name.value.substring(0,1)==" ")
            {
                alert("��һλ����Ϊ��");
                f.Name.focus();
                f.Name.select();
                return false;
            }

            if(isNaN(f.Name.value))
            {
                if((f.Name.value.length)<2 || (f.Name.value.length)>14)
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
            if(f.Tel.value.substring(0,1)==" ")
            {
                alert("��һλ����Ϊ��");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }

            if(isNaN(f.Tel.value)!=true)
            {
                if((f.Tel.value.length)<8 || (f.Tel.value.length)>14)
                {
                    alert("�绰���볤�Ȳ���ȷ");
                    f.Tel.focus();
                    f.Tel.select();
                    return false;
                }
            }
            else
            {
                alert("�绰����Ϊ����");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
            if(f.Tel.value.indexOf("-",0)>=0 || f.Tel.value.indexOf("+",0)>=0)
            {
                alert("���ܳ���+ - ��");
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
                if(f.Email.value.substring(0,1)==" ")
                {
                    alert("��һλ����Ϊ��");
                    f.Email.focus();
                    f.Email.select();
                    return false;
                }
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
        function Pass()
        {
            var f=document.form1;


        }

        function Email()
        {
            var f=document.form1;
            if(f.Email.value.indexOf("@",0)==-1)
            {
                alert("��ַ����,��@����");
                return;
            }
            if(f.Email.value.indexOf(".",0)==-1)
            {
                alert("��ַ����,��.����");
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
    input[type="radio"]:checked{
        background: #5b479f;
        border:none;
    }
    input[type="submit"]:disabled{
        background: #ff4445;
        border:none;
    }
    input[type="reset"]:disabled{
        background: #ff4445;
        border:none;
    }
    .style4 {
        border:none;
       background: #ff4445;
    }
</style>

<body>



<div id="container">
    <div id="banner">

        <p align="center"   class="style1"><a href="index.html"   style="text-decoration:none">��վ��ҳ</a>&nbsp;&nbsp;
            <a href="login.jsp"  style="text-decoration:none">�û���½</a>&nbsp;&nbsp;
            <a href="register.jsp"  style="text-decoration:none">ע���û�</a>&nbsp;&nbsp;
            <a href="Adminlogin.jsp"  style="text-decoration:none">����Աͨ��</a>&nbsp;&nbsp;
            <a href="../index.htm"  style="text-decoration:none">������Ŀ</a></p>

    </div>
    <div id="banner_right">

    </div>

    <div id="body">
        <div id="left">

        </div>
        <div id="middle">




            <p align="center" class="style1">��ӭ��ע���Ա</p>
            <hr>
            <form name="form1" method="post" action="NewUser" onsubmit="return User()">
                <p>&nbsp;</p>
                <table width="443" border="1" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="94" height="38"><div align="center">
                            <p>��&nbsp;�� ��:</p>
                        </div></td>
                        <td width="343">
                            <div align="left">
                                <input name="Username" type="text" id="yonghu" size="20"  required >
                                <span class="style3">*�û�������Ϊ8-16��ĸ����</span></div></td>
                    </tr>
                    <tr>
                        <td height="38"><div align="center">�� &nbsp;     &nbsp;��:</div></td>
                        <td>
                            <div align="left">
                                <input name="Password" type="password" id="password1" size="20" required >
                                *���볤��Ϊ6-14����</div></td>
                    </tr>
                    <tr>
                        <td height="38"><div align="center">�ظ�����:</div></td>
                        <td>
                            <div align="left">
                                <input name="password2" type="password" id="password2" size="20" required>
                                *���������뱣��һ��
                            </div></td></tr>
                    <tr>
                        <td height="38"><div align="center">��ʵ����:</div></td>
                        <td>
                            <div align="left">
                                <input name="Name" type="text" id="name" size="20" required>
                                *ӦΪ��ʵ����
                            </div></td></tr>
                    <tr>
                        <td height="38"><div align="center">�� &nbsp;&nbsp;&nbsp;��:</div></td>
                        <td>
                            <div align="left">
                                <input type="radio" name="Sex" value="1"checked>
                                ��
                                <input type="radio" name="Sex" value="2" required>
                                Ů</div></td></tr>
                    <tr>
                        <td height="38"><div align="center">�绰����:</div></td>
                        <td>
                            <div align="left">
                                <input name="Tel" type="text" id="zhengjian" size="20" required>
                                *�绰����Ϊ8-14λ����</div></td></tr>
                    <tr>
                        <td height="38"><div align="center">�����ʼ�:</div></td>
                        <td>
                            <div align="left">
                                <input name="Email" type="text" id="Email" size="20"  required>
                            </div></td></tr>
                </table>
                <p align="center">
                    <input type="submit" name="submit" value="�ύ" class="style4">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" name="reset" value="����" class="style4">

                </p>
            </form>
        </div>
        <div id="right">

        </div>
    </div>
</div>











</body>
</html>















