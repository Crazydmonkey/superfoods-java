<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>订单列表</title>
	<base href="/"/>
	<style type="text/css">
		body{
			background-color:rgb(240,240,240); 
		}
		.list_item{
			margin:0 auto; 
			margin-top:2px; 
			background-color:rgb(200,200,200); 
		}
	</style>
	<link href="css/customerFrame.css" rel="stylesheet"/>
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		/*$(function(){
		   $.get("http://localhost:8888/userOrder/orders",{userId:"1"}, function(result){
		   		console.log(result.data);
		   		var data = result.data;
		   		for(var i = 0; i < data.length; i++){
		   			console.log(data[i]);
		   		}
		   		
		   },"json");
		 
		});*/
	</script>
</head>
<body>
	<div id="titleBar">订单列表</div>
	
	<div class="list_item">
		<a href="http://localhost:8888/order1/orderDetailsUnfinished">
		<div>
			<label>待收货</label>
		</div>
		<div>
			<label>2019-12-01 12:12</label>
			<label>￥33</label>
		</div>
		</a>
		<div>
			<button>确认收货</button>
			<button>再来一单</button>	
		</div>
	</div>

	<div class="list_item">
		<a href="http://localhost:8888/order1/orderDetailsFinished">
		<div>
			<label>已完成</label>	
		</div>
		<div>
			<label>2019-12-01 12:12</label>
			<label>￥33</label>
		</div>
		</a>
		<div>
			<button>再来一单</button>
		</div>
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