<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>确认订单信息</title>
	<style type="text/css">
		body{
			background-color:rgb(240,240,240); 
		}
		.content{
			margin: 0 auto;
			margin-top: 2px;
			background-color: rgb(255,255,255);
		}

	</style>
</head>
<body>
	<div class="content">
		<table>
			<tr><td>张三</td></tr>
			<tr><td>13212341234</td></tr>
			<tr><td>杰普软件园</td></tr>
		</table>
	</div>
	<div class="content">
		<table>
			<tr>
				<td>雪碧</td>
				<td>X2</td>
				<td>￥6</td>
			</tr>
			<tr>
				<td>青椒土豆丝盖饭</td>
				<td>X1</td>
				<td>￥8</td>
			</tr>
			<tr>
				<td>￥14</td>
			</tr>
		</table>
	</div>

	<div class="content">
		<a href="http://localhost:8888/order1/notes">订单备注</a>
		<img src="x.jpg" />
	</div>

	<div class="content">
		待支付￥14
		<a href="http://localhost:8888/order1/payResult"><button onclick="">提交订单</button>	</a>
	</div>

</body>
</html>