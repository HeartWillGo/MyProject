<%@page contentType="text/html"%>
<%@page pageEncoding="GBK"%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head >
    <script type="text/javascript">

        document.write("<DIV id='cc' style='BORDER-RIGHT: #000000 1px solid; PADDING-RIGHT: 12px; BORDER-TOP: #000000 1px solid; PADDING-LEFT: 12px; Z-INDEX: 2; BACKGROUND: #ffffff; FILTER: Alpha(opacity=85); LEFT: 505px; VISIBILITY: hidden; PADDING-BOTTOM: 12px; BORDER-LEFT: #000000 1px solid; WIDTH: 200px; LINE-HEIGHT: 22px; PADDING-TOP: 12px; BORDER-BOTTOM: #000000 1px solid; POSITION: absolute; TOP: 419px; HEIGHT: 90px'></DIV>");
        document.write("<style>td {font-family: Arial, Helvetica, sans-serif;font-size: 12px;}table{border-collapse:collapse} .sel{font-family: Webdings;font-size: 9pt;font-weight: bold;color: #243F65;cursor:hand;text-decoration: none; background-color:DEDEEF}body {margin-left:0px;margin-top: 0px;}</style>")
        var name;
        function dateSelect(objname){
            cc.style.visibility="visible";
            cc.style.filter="Alpha(opacity=85)"
            cc.style.left=document.body.scrollLeft+window.event.clientX+2;
            cc.style.top=document.body.scrollTop+window.event.clientY+2;
            name = objname;
            showSelect();
        }
        function hiddeninfo(){
            cc.style.visibility="hidden";
        }
        function RunNian(The_Year){
            if ((The_Year%400==0) || ((The_Year%4==0) && (The_Year%100!=0)))
                return true;
            else
                return false;
        }
        function GetWeekday(The_Year,The_Month)
        {
            var Allday;
            Allday = 0;
            if (The_Year>2000){
                for (i=2000;i<The_Year; i++){
                    if (RunNian(i)) {
                        Allday += 366;
                    }else {
                        Allday += 365;
                    }
                }
                for (i=2; i<=The_Month; i++){
                    switch (i){
                        case 2 :
                            if (RunNian(The_Year))
                                Allday += 29;
                            else
                                Allday += 28;
                            break;
                        case 3 : Allday += 31; break;
                        case 4 : Allday += 30; break;
                        case 5 : Allday += 31; break;
                        case 6 : Allday += 30; break;
                        case 7 : Allday += 31; break;
                        case 8 : Allday += 31; break;
                        case 9 : Allday += 30; break;
                        case 10 : Allday += 31; break;
                        case 11 : Allday += 30; break;
                        case 12 :  Allday += 31; break;
                    }
                }
            }
            return (Allday+6)%7;
        }
        function chooseday(The_Year,The_Month,The_Day){
            var Firstday;
            var completely_date;
            if (The_Day!=0)
                completely_date = The_Year + "-" + The_Month + "-" + The_Day;
            else
                completely_date = "";
            //showdate 只是一个为了显示而采用的东西，
            //如果外部想引用这里的时间，可以通过使用 completely_date引用完整日期
            //也可以通过The_Year,The_Month,The_Day分别引用年，月，日
            //当进行月份和年份的选择时，认为没有选择完整的日期
            Firstday = GetWeekday(The_Year,The_Month);
            ShowCalender(The_Year,The_Month,The_Day,Firstday);
        }
        function chooses(The_Year,The_Month,The_Day){
            var obj2 = document.getElementById(name);
            var Firstday;
            var completely_date;
            if (The_Day!=0)
                completely_date = The_Year + "-" + The_Month + "-" + The_Day;
            else
                completely_date = "";
            obj2.value = completely_date;
            hiddeninfo();
        }
        function nextmonth(The_Year,The_Month){
            if (The_Month==12)
                chooseday(The_Year+1,1,0,name);
            else
                chooseday(The_Year,The_Month+1,0,name);
        }
        function prevmonth(The_Year,The_Month){
            if (The_Month==1)
                chooseday(The_Year-1,12,0);
            else
                chooseday(The_Year,The_Month-1,0);
        }
        function prevyear(The_Year,The_Month){
            chooseday(The_Year-1,The_Month,0);
        }
        function nextyear(The_Year,The_Month){
            chooseday(The_Year+1,The_Month,0);
        }
        function ShowCalender(The_Year,The_Month,The_Day,Firstday){
            var ycdate="";
            var showstr;
            var Month_Day;
            var ShowMonth;
            var today;
            today = new Date();
            switch (The_Month){
                case 1 : ShowMonth = "1月"; Month_Day = 31; break;
                case 2 :
                    ShowMonth = "2月";
                    if (RunNian(The_Year))
                        Month_Day = 29;
                    else
                        Month_Day = 28;
                    break;
                case 3 : ShowMonth = "3月"; Month_Day = 31; break;
                case 4 : ShowMonth = "4月"; Month_Day = 30; break;
                case 5 : ShowMonth = "5月"; Month_Day = 31; break;
                case 6 : ShowMonth = "6月"; Month_Day = 30; break;
                case 7 : ShowMonth = "7月"; Month_Day = 31; break;
                case 8 : ShowMonth = "8月"; Month_Day = 31; break;
                case 9 : ShowMonth = "9月"; Month_Day = 30; break;
                case 10 : ShowMonth = "10月"; Month_Day = 31; break;
                case 11 : ShowMonth = "11月"; Month_Day = 30; break;
                case 12 : ShowMonth = "12月"; Month_Day = 31; break;
            }
            showstr = "";
            showstr = "<Table cellpadding=0 cellspacing=0 border=1 bordercolor=#C0D0E8 width=95% align=center valign=top>"; //上边框颜色
            showstr +=  "<tr><td width=0 class='sel' onclick=prevyear("+The_Year+"," + The_Month + ")>3</td><td width=0>" + The_Year + "年 </td><td width=0 onclick=nextyear("+The_Year+","+The_Month+") class='sel'>4</td><td width=0 class='sel' onclick=prevmonth("+The_Year+","+The_Month+")>3</td><td width=40 align=center>" + ShowMonth + "</td><td width=0 onclick=nextmonth("+The_Year+","+The_Month+") class='sel'>4</td></tr>";
            showstr +=  "<tr><td align=center width=100% colspan=6>";
            showstr +=  "<table cellpadding=0 cellspacing=0 border=1 bordercolor=#C0D0E8 width=100%>";//内边框颜色
            showstr += "<Tr align=center bgcolor=#C0D0E8> ";//星期td背景
            showstr += "<td><strong><font color=#ff0000>日</font></strong></td>";
            showstr += "<td><strong><font color=#000000>一</font></strong></td>";
            showstr += "<td><strong><font color=#000000>二</font></strong></td>";
            showstr += "<td><strong><font color=#000000>三</font></strong></td>";
            showstr += "<td><strong><font color=#000000>四</font></strong></td>";
            showstr += "<td><strong><font color=#000000>五</font></strong></td>";
            showstr += "<td><strong><font color=#ff0000>六</font></strong></td>";
            showstr += "</Tr><tr>";
            for (i=1; i<=Firstday; i++)
                showstr += "<Td align=center bgcolor=#ffffff> </Td>";//月前空日日期背景
            for (i=1; i<=Month_Day; i++){
                if ((The_Year==today.getYear()) && (The_Month==today.getMonth()+1) && (i==today.getDate())){
                    bgColor = "#DEDEEF";//当前日期td颜色
                    ycdate = "<b><font color='#ff0000'>" + i + "</font></b>";
                }else{
                    bgColor = "#DEDEEF";//大部分td颜色
                    ycdate=i+"";
                }
                if (The_Day==i) bgColor = "#ffffff";//选择日期td颜色
                showstr += "<td align=center bgcolor=" + bgColor + " style='cursor:hand' onclick=chooses(" + The_Year + "," + The_Month + "," + i + ")>" + ycdate + "</td>";
                Firstday = (Firstday + 1)%7;
                if ((Firstday==0) && (i!=Month_Day)) showstr += "</tr><tr>";
            }
            if (Firstday!=0) {
                for (i=Firstday; i<7; i++)
                    showstr += "<td align=center bgcolor=#ffffff> </td>";//月尾空日td背景
                showstr += "</tr>";
            }
            showstr += "</tr></table></td></tr><tr><td colspan='7'><div  align='center' onclick='hiddeninfo()' style='cursor:hand'>返回</div></td></tr></table>";
            cc.innerHTML = showstr;
        }
        function showSelect(name){
            var The_Year,The_Day,The_Month;
            var today;
            var Firstday;
            today = new Date();
            The_Year = today.getYear();
            The_Month = today.getMonth() + 1;
            The_Day = today.getDate();
            Firstday = GetWeekday(The_Year,The_Month);
            ShowCalender(The_Year,The_Month,The_Day,Firstday);
        }
        function copy()
        {
            var ses = document.forml.user.value;
            var today=new Date();
            var year=today.getYear();
            var month=today.getMonth()+1;
            var date=today.getDate();
            var year1=parseInt(ses.substring(0,ses.indexOf("-",0)));
            var month1=parseInt(ses.substring(ses.indexOf("-",0)+1,ses.indexOf("-",ses.indexOf("-",0)+1)));
            var date1=parseInt(ses.substring(ses.indexOf("-",ses.indexOf("-",0)+1)+1,ses.length));
            if(year>year1)
            {
                alert("日期不合法");
                return false;
            }
            else if(year==year1)
            {
                if(month>month1)
                {
                    alert("日期不合法");
                    return false;
                }
                else if(month==month1)
                {
                    if(date>=date1)
                    {
                        alert("日期不合法");
                        return false;
                    }
                }
                else
                {}
            }
            else
            {
            }
        }

    </script>

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
        #banner{width:90%;height:10%;float:left;background-color:#9b9b9b;}
        #banner_right{width:10%;height:10%;float:left;background-color:#9b9b9b;}
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

        <p align="center" class="style1"> 管理员登陆界面</p>

        <p>&nbsp;</p>
    </div>

    <div id="banner_right">
        <div id="back">   <p align="center" > <a   href="index.html" style="text-decoration:none">退出</a></p></div>
    </div>
    <div id="body">
        <div id="left">


            <p align="center"   class="style1"><a href="FlightServlet"   style="text-decoration:none">制定航班</a></p>

            <p align="center"  class="style1"><a href="HavingServlet"  style="text-decoration:none">安排航班</a></p>
            <p align="center"  class="style1"> <a href="DestineServlet?param=2"  style="text-decoration:none">查看航班</a></p>
 <p align="center"  class="style1"> <a href="IncomeServelt"  style="text-decoration:none">查看收入</a></p>

        </div>


        <div id="middle">
            <center>

                <form name="forml" method="post" action="ArrangeServlet" onsubmit="return copy()">
                    <table width="370" height="111" border="1" align="center" cellpadding="1" cellspacing="1">
                        <tr>
                            <td width="142" height="55"><div align="center">航班号</div></td>
                            <td width="373"><div align="center">
                                <input name="Hao" type="text" size="6" value="${ter.hao}" readonly="true">

                            </div></td>
                        </tr>
                        <tr>
                            <td height="30" align="center">设定日期</td>
                            <td><div align="center">
                                <input type="date" name="user"  min="2016-11-11" max="2017-01-01"/>
                            </div></td>
                        </tr>
                    </table>
                    <p align="center">
                        <input name="submit" type="submit" id="sheding" value="设定">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="quxiao" type="submit" id="quxiao" value="取消">
                    </p>
                </form>

            </center>
        </div>

    </div>

</div>



</body>

</html>