<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<!-- <style type="text/css">
	  body{
	  	background-color: gray;
	  	text-align: center;
	  }
	  div{
	  	margin:10px auto;
	  	width: 80%;
        height: 300px;
        background-color: white;
        text-align: center;
	  }
	  footer{
	  	margin:10px auto;
	  	height: 60px;
	  	width: 80%;
	  	background-color: white;
	  	text-align: center;
	  }
	  p{
	  	border: 2px solid black; 
	  	width: 70%;
	  	height: 70%;
	  	vertical-align: middle;
	  	text-align: left;
	  	display: inline-block;
	  }
	</style> -->
	<script type="text/javascript">
		function celluser(){
			alert("用户电话为：11111111111");
		}
		function celldelivery(){
			alert("骑手电话为：11111111111");
		}


	</script>

	<div id="order">
		<span>时间</span>
		<span>订单号</span>
		<span>用户id</span><br/>
		<p>订单内容(购买商品的数量*单价信息，订单金额)</p>
	</div>
	<div id="user">
		<p>退单理由</p>
	</div>
	<footer>
		<span><input type="button" id="user" value="联系买家" onclick="celluser()"></span>
		<span><input type="button" id="delivery" value="联系骑手" onclick="celldelivery()"></span>
	</footer>
