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
            if(f.Password.value=="")
            {
                alert("原密码不能为空");
                f.Password.focus();
                f.Password.select();
                return false;
            }
            if(f.Password.value.length>16 || f.Password.value.length<6)
            {
                alert("原密码长度不正确");
                f.Password.focus();
                f.Password.select();
                return false;

            }
            if(isNaN(f.Password.value))
            {
                alert("原密码必须为数字");
                f.Password.focus();
                f.Password.select();
                return false;

            }


            if(f.Password1.value=="")
            {
                alert("新密码不能为空");
                f.Password1.focus();
                f.Password1.select();
                return false;
            }
            if(f.Password1.value.length>16 || f.Password.value.length<6)
            {
                alert("新密码长度不正确");
                f.Password1.focus();
                f.Password1.select();
                return false;

            }
            if(isNaN(f.Password1.value))
            {
                alert("新密码必须为数字");
                f.Password1.focus();
                f.Password1.select();
                return false;
            }
            if(f.Password1.value!=f.Password2.value)
            {
                alert("密码不一致!");
                f.Password2.focus();
                f.Password2.select();
                return false;
            }



        }

    </script>


    <title>Title</title>


    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
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

                
                <p>&nbsp;</p>
                <form name="form1" method="post" action="PassServlet" onsubmit="return User()">
                    <p>&nbsp;</p>
                    <table width="300" border="1" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="94" height="38"><div align="center"><p>原密码</p> </div></td>
                            <td width="200"><div align="center"><input name="Password" type="password"  size="20" />
                            </div></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">新密码</div></td>
                            <td><div align="center"><input name="Password1" type="password"  size="20" >
                            </div></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">确认密码</div></td>
                            <td><div align="center"> <input name="Password2" type="password" size="20" >
                            </div></td>
                        </tr>
                        <tr>

                    </table>
                    <p align="center">
                        <input type="submit" name="Submit" value="修改"/>&nbsp;&nbsp;&nbsp;
                        <input type="reset" name="reset" value="重置"/>


                    </p>
                </form>

            </center>
        </div>

    </div>

</div>



</body>

</html>
