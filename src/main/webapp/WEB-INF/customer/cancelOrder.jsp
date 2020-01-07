<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>请求取消订单</title>
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
		<label>请填写取消订单的原因</label>	
		<form>
			<input type="checkbox" name="cancelReason"/>点错菜了<br/>
			<input type="checkbox" name="cancelReason"/>信息填写有误<br/>
			<input type="checkbox" name="cancelReason"/>优惠和预期不符<br/>
			<input type="checkbox" name="cancelReason"/>付款遇到问题<br/>
			<input type="checkbox" name="cancelReason"/>临时有事<br/>
			<input type="checkbox" name="cancelReason"/>不想买了<br/>
			<input type="checkbox" name="cancelReason" value=""/>其他<br/>
			<textarea name="otherReason" cols="30" rows="1"></textarea>
		</form>
	</div>

	<div class="content">
		<button onclick="">确定</button>
	</div>
</body>
</html>