<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title> 
    <base href="/"></base>
    <link href="css/customerFrame.css" rel="stylesheet"/>
    <style>
        html{ font-size:100px; } 
        body{ background: rgb(239,239,239); } 
        body,a,h3,span{ padding:0; margin:0; text-decoration: none; } 
        .header{ background: rgb(252, 159, 83) ; height: 0.44rem; font-size:0.14rem; color: white; padding-left:0.17rem; padding-right: 0.25rem; text-align: center; line-height: 0.44rem;  } .header>a{ color: white; float: left; }     
        .header>.btn{     float: right;     padding-top:0.1rem;     } 
        .btn>span{ border-radius: 100%; display: block; width: 0.04rem; height: 0.04rem; background: white; margin-top: 0.03rem; } 
        .username{ height: 0.72rem; background: white; border-bottom: 1px solid #E0E0E0 ; padding-left: 0.17rem; padding-right: 0.12rem; padding-top: .12rem; } 
        .username>img{ width: 0.48rem; height: 0.48rem; object-fit: cover; margin-right: 0.12rem; float: left; border-radius: 0.1rem; } 
        .username>.text{ height: 0.48rem; float: left;  } 
        .username .name{ font-size: 0.15rem; margin-bottom: 0.08rem;  }  
        .username .account{ font-size: 0.12rem; color: #5D5D5D; } 
        .gender,.address,.collection,.other{ font-size: 0.14rem; padding-left: 0.17rem; border-bottom: 1px solid #E0E0E0 ; height: 0.65rem; line-height: 0.65rem; padding-right: 0.12rem; background: white; } 
        .gender,.address,.collection{ margin-top:0.13rem; margin-bottom: 0.13rem; } 
        .gender>a,.address>a,.collection>a,.other>a{ float: right; } 
        .footer{ margin-top: 0.2rem; height: 0.5rem; font-size: 0.16rem; border:1px solid red; border-radius: 0.05rem; width: 2.99rem; text-align: center; line-height: 0.5rem; margin-left: 0.35rem; }
    </style>  
</head>
        <body>
            <div class="header"> 我的
                <div class="btn"> 
                <a href="setting.do"><img src="images/setting.png"  height="30"></a>
                </div> 
            </div>
            <div class="content"> 
                <div class="username">  <img src= "images/mine.png" alt="" /> 
                    <div class="text"> <div class="name">昵称</div> 
                        <div class="account">用户名</div> 
                    </div> 
            </div> 
            <div class="gender"> <td>性别</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <td>男</td></div> 
            <div class="address">我的地址</div>
            <div class="collection">我的收藏 <a href="coll"> > </a></div>  
            <div class="other"> 关于我们 <a href=""> > </a> </div> 
            <div class="footer"> <button onclick="window.location.href='customerLogin.do'">登录</button></div>  
              
            <div id="navBar"> 
		<a href="http://localhost:8888/shopping.do">
			<div id="shopping">	
				<img src="images/supermarket.png" >
				<div>超市</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/food.do">
			<div id="food">
				<img src="images/foods.png" >
				<div>美食</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/shoppingCar.do">
			<div id="shoppingCart">
				<img src="images/shoppingcar.png" >
				<div>购物车</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/order1/orders">
			<div id="order">
				<img src="images/order.png" >
				<div>订单</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/mine.do">
			<div id="mine">
				<img src="images/mine.png" >
				<div>我的</div>
			</div>
		</a>
	</div>
	
	<div id="navBar"> 
		<a href="http://localhost:8888/shopping.do">
			<div id="shopping">	
				<img src="images/supermarket.png" >
				<div>超市</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/food.do">
			<div id="food">
				<img src="images/foods.png" >
				<div>美食</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/shoppingCar.do">
			<div id="shoppingCart">
				<img src="images/shoppingcar.png" >
				<div>购物车</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/order1/orders">
			<div id="order">
				<img src="images/order.png" >
				<div>订单</div>
			</div>
		</a>
		
		<a href="http://localhost:8888/mine.do">
			<div id="mine">
				<img src="images/mine.png" >
				<div>我的</div>
			</div>
		</a>
	</div>
         </body>
</html>
