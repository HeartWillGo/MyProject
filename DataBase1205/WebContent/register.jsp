<%@page contentType="text/html" %>
<%@page pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>注册用户</title>
    <script language="javascript">
        function User()
        {
            var f=document.form1;
            if(f.Username.value=="")
            {
                alert("名字不能为空");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Username.value.substring(0,1)==" ")
            {
                alert("第一位不能为空");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Username.value.length<8)
            {
                alert("您输入用户长度不正确");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Username.value.length>12)
            {
                alert("您输入用户长度不正确");
                f.Username.focus();
                f.Username.select();
                return false;
            }
            if(f.Password.value=="")
            {
                alert("密码不能为空");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.Password.value.substring(0,1)==" ")
            {
                alert("第一位不能为空");
                f.Password.focus();
                f.Password.select();
                return false;
            }

            if(isNaN(f.Password.value)!=true)
            {
                if(f.Password.value.length>12 || f.Password.value.length<6)
                {
                    alert("密码长度不正确");
                    f.Password.focus();
                    f.Password.select();
                    return false;

                }
            }
            else
            {
                alert("密码必须为数字");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.Password.value.indexOf("-",0)>=0 || f.Password.value.indexOf("+",0)>=0)
            {
                alert("不能出现+ - 号");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.password2.value=="")
            {
                alert("密码不能为空");
                f.password2.focus();
                f.password2.select();
                return false;
            }
            if(f.password2.value.substring(0,1)==" ")
            {
                alert("第一位不能为空");
                f.password2.focus();
                f.password2.select();
                return false;
            }
            if(f.password2.value!=f.Password.value)
            {
                alert("密码不一致!");
                f.password2.focus();
                f.password2.select();
                return false;
            }
            if(f.Name.value=="")
            {
                alert("姓名不能为空");
                f.Name.focus();
                f.Name.select();
                return false;
            }
            if(f.Name.value.substring(0,1)==" ")
            {
                alert("第一位不能为空");
                f.Name.focus();
                f.Name.select();
                return false;
            }

            if(isNaN(f.Name.value))
            {
                if((f.Name.value.length)<2 || (f.Name.value.length)>14)
                {
                    alert("您输入的姓名长度有误");
                    f.Name.focus();
                    f.Name.select();
                    return false;
                }
            }
            else
            {
                alert("姓名不能为数字");
                f.Name.focus();
                f.Name.select();
                return false;
            }

            if(f.Tel.value=="")
            {
                alert("电话不能为空");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
            if(f.Tel.value.substring(0,1)==" ")
            {
                alert("第一位不能为空");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }

            if(isNaN(f.Tel.value)!=true)
            {
                if((f.Tel.value.length)<8 || (f.Tel.value.length)>14)
                {
                    alert("电话号码长度不正确");
                    f.Tel.focus();
                    f.Tel.select();
                    return false;
                }
            }
            else
            {
                alert("电话必须为数字");
                f.Tel.focus();
                f.Tel.select();
                return false;
            }
            if(f.Tel.value.indexOf("-",0)>=0 || f.Tel.value.indexOf("+",0)>=0)
            {
                alert("不能出现+ - 号");
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
                    alert("第一位不能为空");
                    f.Email.focus();
                    f.Email.select();
                    return false;
                }
                if(f.Email.value.indexOf("@",0)==-1)
                {
                    alert("地址有误,把@补上");
                    f.Email.focus();
                    f.Email.select();
                    return false;
                }
                if(f.Email.value.indexOf(".",0)==-1)
                {
                    alert("地址有误,把.补上");
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
                alert("地址有误,把@补上");
                return;
            }
            if(f.Email.value.indexOf(".",0)==-1)
            {
                alert("地址有误,把.补上");
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

        <p align="center"   class="style1"><a href="index.html"   style="text-decoration:none">本站首页</a>&nbsp;&nbsp;
            <a href="login.jsp"  style="text-decoration:none">用户登陆</a>&nbsp;&nbsp;
            <a href="register.jsp"  style="text-decoration:none">注册用户</a>&nbsp;&nbsp;
            <a href="Adminlogin.jsp"  style="text-decoration:none">管理员通道</a>&nbsp;&nbsp;
            <a href="../index.htm"  style="text-decoration:none">其它栏目</a></p>

    </div>
    <div id="banner_right">

    </div>

    <div id="body">
        <div id="left">

        </div>
        <div id="middle">




            <p align="center" class="style1">欢迎您注册会员</p>
            <hr>
            <form name="form1" method="post" action="NewUser" onsubmit="return User()">
                <p>&nbsp;</p>
                <table width="443" border="1" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="94" height="38"><div align="center">
                            <p>用&nbsp;户 名:</p>
                        </div></td>
                        <td width="343">
                            <div align="left">
                                <input name="Username" type="text" id="yonghu" size="20"  required >
                                <span class="style3">*用户名长度为8-16字母数字</span></div></td>
                    </tr>
                    <tr>
                        <td height="38"><div align="center">密 &nbsp;     &nbsp;码:</div></td>
                        <td>
                            <div align="left">
                                <input name="Password" type="password" id="password1" size="20" required >
                                *密码长度为6-14数字</div></td>
                    </tr>
                    <tr>
                        <td height="38"><div align="center">重复密码:</div></td>
                        <td>
                            <div align="left">
                                <input name="password2" type="password" id="password2" size="20" required>
                                *必须与密码保持一致
                            </div></td></tr>
                    <tr>
                        <td height="38"><div align="center">真实姓名:</div></td>
                        <td>
                            <div align="left">
                                <input name="Name" type="text" id="name" size="20" required>
                                *应为真实姓名
                            </div></td></tr>
                    <tr>
                        <td height="38"><div align="center">性 &nbsp;&nbsp;&nbsp;别:</div></td>
                        <td>
                            <div align="left">
                                <input type="radio" name="Sex" value="1"checked>
                                男
                                <input type="radio" name="Sex" value="2" required>
                                女</div></td></tr>
                    <tr>
                        <td height="38"><div align="center">电话号码:</div></td>
                        <td>
                            <div align="left">
                                <input name="Tel" type="text" id="zhengjian" size="20" required>
                                *电话号码为8-14位数字</div></td></tr>
                    <tr>
                        <td height="38"><div align="center">电子邮件:</div></td>
                        <td>
                            <div align="left">
                                <input name="Email" type="text" id="Email" size="20"  required>
                            </div></td></tr>
                </table>
                <p align="center">
                    <input type="submit" name="submit" value="提交" class="style4">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" name="reset" value="重置" class="style4">

                </p>
            </form>
        </div>
        <div id="right">

        </div>
    </div>
</div>











</body>
</html>















