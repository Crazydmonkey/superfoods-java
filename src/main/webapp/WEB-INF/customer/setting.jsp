<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>setting</title>
    <style>
        html{ font-size:100px; } 
        body{ background: rgb(239,239,239); } 
        body,a,h3,span{ padding:0; margin:0; text-decoration: none; } 
        .header{ background: rgb(252, 159, 83) ; height: 0.44rem; font-size:0.14rem; color: white; padding-left:0.17rem; padding-right: 0.25rem; text-align: center; line-height: 0.44rem;  }
        .header>a{ color: white; float: left; }     
        .update,.safe,.paysetting{ font-size: 0.14rem; padding-left: 0.17rem; border-bottom: 1px solid #E0E0E0 ; height: 0.65rem; line-height: 0.65rem; padding-right: 0.12rem; background: white; } 
        .update,.safe,.paysetting{ margin-top:0.13rem; margin-bottom: 0.13rem; } 
        .update>a,.safe>a,.paysetting>a{ float: left; } 
        .footer{ margin-top: 0.2rem; height: 0.5rem; font-size: 0.16rem; border:1px solid red; border-radius: 0.05rem; width: 2.99rem; text-align: center; line-height: 0.5rem; margin-left: 0.35rem; }
    </style>  
</head>
<body>
    <div class="header"> <a href="mine.do"> < </a>设置</div>
    <div class="update"><a href="update.do">修改个人信息</a></div>
    <div class="safe"><a href="safe.do">账号安全</a></div>
    <div class="paysetting"><a href="paySetting.do">支付设置</a></div>
</body>
</html>