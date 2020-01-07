<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>订单详情-未完成</title>
	<style type="text/css">
		body{
			background-color:rgb(240,240,240); 
		}
		.content{
			margin: 0 atuto;
			margin-top: 2px;
			background-color: rgb(255,255,255);
		}
	</style>
</head>
<body>
	<div class="content">
	订单状态区
		<label>待接单</label>
		<label>待发货</label>
		<label>待收货</label>
	</div>
	<div id="" class="content">
		<table>
			<tr>
				<td><img src="x.jpg"/></td>
				<td>商品名称</td>
				<td>x1</td>
				<td>￥5.00</td>
			</tr>
			<tr>
				<td><img src="x.jpg"/></td>
				<td>商品名称</td>
				<td>x1</td>
				<td>￥5.00</td>
			</tr>
		</table>
		<div>总金额：￥10.00</div>
	</div>

	<div class="content">
		<div>配送信息</div>
		<table>
			<tr>
				<td>预计送达时间</td>
				<td>2019-12-2 12:21</td>
			</tr>
			<tr>
				<td>收货地址</td>
				<td>张先生</td>
				<td>13212341234</td>
				<td>杰普软件园</td>
			</tr>
			<tr>
				<td>配送骑手</td>
				<td>张三</td>
				<td>13212344321</td>
			</tr>
		</table>
	</div>

	<div class="content">
		<div>订单信息</div>
		<table>
			<tr>
				<td>订单号</td>
				<td>201912121</td>
			</tr>
			<tr>
				<td>支付方式</td>
				<td>支付宝</td>
			</tr>
			<tr>
				<td>下单时间</td>
				<td>2019-12-12 12:12</td>
			</tr>
		</table>
	</div>

	<div class="content">
		<a href="http://localhost:8888/order1/cancelOrder"><button>取消订单</button></a>
		<button>催订单</button>
	</div>
</body>
</html>