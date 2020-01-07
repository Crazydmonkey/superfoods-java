<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>

<script src="js/jquery-3.3.1.min.js"></script>

<script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="css/bootstrapSwitch/js/bootstrap-switch.min.js"></script>
<script src="js/router.js"></script>

<base href="/"/>
	<link href="css/customerFrame.css" rel="stylesheet"/>
<script type="text/javascript">
	$(function() {
		console.log("购物车信息");
		$.getJSON("/getAll?customerId=111", function(data) {
			console.log("购物车信息："+data.data[0].id);
			console.log("购物车信息："+data.data[0].goodsId);
			//遍历 查找商品信息
			var goodss = "";
			$.each(data.data, function(index, item) {
				console.log("商品信息："+item.id);
	
				//同步
				$.ajaxSettings.async = false;
				$.getJSON("/findGoods/goods/id/"+item.goodsId+"", function(goods) {
					console.log("商品信息："+goods);
					console.log("商品信息："+goods.data.name);
	
					goodss+="<tr><td rowspan='2'><img width='400px' src='http://localhost:8888/img/"+goods.data.picture+"'></td>"+
							"<td colspan='2'>"+goods.data.name+"</td>"+"</tr>"+
							"<tr><td>"+goods.data.amount+"</td>"+
							"<td><b>+</b><input maxlength='3' style='font-size:40px' type='text' value='"+goods.data.quantity+"'><b>-</b></td>"+"</tr>";
				})
			})
			$("table[name=goods]").each(function() {
				$(this).empty();
				$(this).append(goodss);
			}) 
		})
		
	})
</script>

</head>
<body>
	<div style="background-color: orange;height:30px;text-align: center;" >
		<span>购物车</span>
		<a href="" style="float: right;"><span>管理</span></a>
	</div >
	<div style="height: 100px;">
		<img src="" alt="图片" style="height: 60px;margin-top: 20px;margin-left: 20px">
		<div style="float: right;margin-top: 20px">
			<span>商品1</span>	
			<br><br>
			<span>$100<button>+</button><input type="text" style="width: 50px"><button>-</button></span>
		</div>
	</div>
	<div style="height: 100px;">
		<img src="" alt="图片" style="height: 60px;margin-top: 20px;margin-left: 20px">
		<div style="float: right;margin-top: 20px">
			<span>商品1</span>
			<br><br>
			<span>$100<button>+</button><input type="text" style="width: 50px"><button>-</button></span>
		</div>
	</div>
	<div style="height: 100px;">
		<img src="" alt="图片" style="height: 60px;margin-top: 20px;margin-left: 20px">
		<div style="float: right;margin-top: 20px">
			<span>商品1</span>
			<br><br>
			<span>$100<button>+</button><input type="text" style="width: 50px"><button>-</button></span>
		</div>
	</div>
	<div style="height: 100px;">
		<img src="" alt="图片" style="height: 60px;margin-top: 20px;margin-left: 20px">
		<div style="float: right;margin-top: 20px">
			<span>商品1</span>
			<br><br>
			<span>$100<button>+</button><input type="text" style="width: 50px"><button>-</button></span>
		</div>
	</div>
	<div>
		<span>共计：88￥</span>
		<a href="http://localhost:8888/order1/confirmOrderInfo"><button style="float: right;">付款</button></a>
	</div>
	<!-- <div>
		<span>购物车</span>
		<span>管理</span>
	</div>
	购物车商品
	<div>
		<table name="goods" style="font-size:50px">
				<tr>
					<td rowspan="2"><img width="40px" src="http://localhost:8888/img/2409timg (1).jpg"></td>
					<td colspan="2" >商品</td>
				</tr>
				
				<tr>
					<td width="200px">￥100</td>
					<td>
						<b>+</b>
						<input type="text" maxlength="" name="quantity" style="font-size: 40px">
						<b>-</b>
					</td>
				</tr>
		</table>
	</div>
	
	<div style="margin-bottom: 10px;">
		<span  style="margin-left: 10%;font-size: 70px">全选</span>
		<span  style="float:right;font-size:70px">￥100.00</span>
		<span  style="float:right;font-size:70px">结算</span>
	</div> -->
		
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
