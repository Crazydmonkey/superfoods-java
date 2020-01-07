<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <base href="/"/>
	<link href="css/customerFrame.css" rel="stylesheet"/>
<style type="text/css">
header {
	padding-top: 20px;
	font-size: 30px;
	background: orange;
	text-align: center;
	height: 70px;
}

header>span {
	float: right;
	padding-right: 20px;
}

footer {
	height: 100px;
	background: orange;
}

main {
	width: 100%;
	height: 660px;
	overflow: hidden;
}

main .goods-type-food {
	margin-top: 30px;
	width: 27%;
	height: 100%;
	padding: 10px;
	float: left;
	background: #fff;
	border-right: 1px solid #ccc;
}

main .goods-type-food li {
	width: 100%;
	height: 70px;
	color: rgb(65, 64, 64);
	font-weight: bold;
	line-height: 70px;
	text-align: center;
	border-bottom: 1px solid #ccc;
}

main .goods-food-list {
	height: 100%;
	background: #fff;
}

main .goods-food-list li {
	border-bottom: 1px solid #eee;
}

main .goods-food-list p {
	color: rgb(37, 37, 37);
	padding: 5px 10px;
}

.food-info {
	background: #fff;
	width: 100%;
	height: 110px;
	padding: 15px;
}

.food-info .pic1 {
	background: url() no-repeat;
}

.food-info .pic2 {
	background: url() no-repeat;
}

.food-info .pic3 {
	background: url() no-repeat;
}

.food-info .pic4 {
	background: url() no-repeat;
}

.food-info .pic5 {
	background: url() no-repeat;
}

.food-info .pic1, .food-info .pic2, .food-info .pic3, .food-info .pic4,
	.food-info .pic5 {
	width: 60px;
	height: 60px;
	float: left;
	margin-top: 5px;
	background-size: cover;
	background-position: -12px center;
}

.food-info .details {
	float: left;
	margin-left: 10px;
}

.food-info .details p {
	height: 18px;
	color: #000;
	font-weight: bold;
	padding: 0;
	font-size: 14px;
}

.food-info .details span {
	font-size: 12px;
	color: #aaa;
}

.food-info .details .price {
	font-size: 16px;
	font-weight: bold;
	color: red;
}

.food-info .add {
	float: right;
	margin-top: 60px;
}

.food-info .add .icon-add {
	font-size: 20px;
	color: red;
}
</style>
</head>
<body>
	<header>
		<span><input type="button" value="搜索"></span> <span><input
			type="text" id="search"></span> <span><input type="button"
			value="购物车图片"></span>
	</header>

	<main>
	<div>
		<ul class="goods-type-food">
			<li>aaa</li>
			<li>aaa</li>
			<li>aaa</li>
			<li>aaa</li>
			<li>aaa</li>
			<li>aaa</li>
			<li>aaa</li>
		</ul>
	</div>
	<ul class="goods-food-list">
		<li>
			<div class="food-info">
				<div class="pic1"></div>
				<div class="details">
					<p>商品名称</p>
					<span>详情</span><br> <span class="price"><i
						class="iconfont icon-price"></i>22</span>
				</div>
				<div class="add">
					<i class="iconfont icon-add"></i>
				</div>
			</div>
		</li>
		<li>
			<div class="food-info">
				<div class="pic2"></div>
				<div class="details">
					<p>商品名称</p>
					<span>详情</span><br> <span class="price"><i
						class="iconfont icon-price"></i>22</span>
				</div>
				<div class="add">
					<i class="iconfont icon-add"></i>
				</div>
			</div>
		</li>
		<li>
			<div class="food-info">
				<div class="pic3"></div>
				<div class="details">
					<p>商品名称</p>
					<span>详情</span><br> <span class="price"><i
						class="iconfont icon-price"></i>22</span>
				</div>
				<div class="add">
					<i class="iconfont icon-add"></i>
				</div>
			</div>
		</li>
		<li>
			<div class="food-info">
				<div class="pic4"></div>
				<div class="details">
					<p>商品名称</p>
					<span>详情</span><br> <span class="price"><i
						class="iconfont icon-price"></i>22</span>
				</div>
				<div class="add">
					<i class="iconfont icon-add"></i>
				</div>
			</div>
		</li>
	</ul>
	</main>
	<div id="navBar">
		<a href="http://localhost:8888/shopping.do">
			<div id="shopping">
				<img src="images/supermarket.png">
				<div>超市</div>
			</div>
		</a> <a href="http://localhost:8888/food.do">
			<div id="food">
				<img src="images/foods.png">
				<div>美食</div>
			</div>
		</a> <a href="http://localhost:8888/shoppingCar.do">
			<div id="shoppingCart">
				<img src="images/shoppingcar.png">
				<div>购物车</div>
			</div>
		</a> <a href="http://localhost:8888/order1/orders">
			<div id="order">
				<img src="images/order.png">
				<div>订单</div>
			</div>
		</a> <a href="http://localhost:8888/mine.do">
			<div id="mine">
				<img src="images/mine.png">
				<div>我的</div>
			</div>
		</a>
	</div>
</body>
</html>