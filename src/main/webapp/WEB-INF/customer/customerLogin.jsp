<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>business login</title>
    <base href="/images/"></base>
    <style>
        .button1 {
            -webkit-transition-duration: 0.4s;
            transition-duration: 0.4s;
            padding: 10px;
            text-align: center;
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
            border-radius:5px;
        }
    </style>
</head>
<body>
    <p  style="text-align:center">
        <img src = "mine.png">
    </p>
    <form>
		<table cellpadding=3 cellspacing=1 align=center class=>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="yellow" ><font color="red"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=>请输入您的用户名:</td>
			<td valign=middle class=><INPUT name=userid type=text> &nbsp;
				
			</td>
		</tr>
		<tr>
			<td valign=middle class=>请输入您的密码:</td>
			<td valign=middle class=><INPUT name=password type=password> &nbsp; </td>
		</tr>
		<tr>
            
            <td class= valign=middle colspan=2 ><a href="mine.do"><button class="button1">登录</button></a></td>
            <td class= valign=middle colspan=2 ><button class="button1" >注册</button></td>
            
		</tr>
		</table>
	</form>
</body>
</html>

