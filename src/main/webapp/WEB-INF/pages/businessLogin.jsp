<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>business login</title> 
    <base href="/images/"></base> -->

    <style>
        .button1 {
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
            padding: 16px 32px;
            text-align: center;
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
            border-radius:5px;
        }
        .button1:hover {
            background-color: #4CAF50;
            color: white;
        }
    </style>
<!-- </head>
<body> -->
    <p  style="text-align:center">
        <img src = "/images/mine.png">
    </p>
    <form action="login.action" method=post name="login">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="yellow" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>请输入您的用户名</td>
			<td valign=middle class=tablebody1><INPUT name=userid type=text> &nbsp;
				
			</td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>请输入您的密码</td>
			<td valign=middle class=tablebody1><INPUT name=password type=password> &nbsp; </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center><button class="button1" onclick="">登录</button></td>
		</tr>
		</table>
	</form>
<!-- </body>
</html>
 -->
