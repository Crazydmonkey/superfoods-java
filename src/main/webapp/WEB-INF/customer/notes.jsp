<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>备注</title>
	<style type="text/css">
		body{
			width:375px;
			height:812px;
			background-color:rgb(240,240,240); 
		}
		.content{<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>备注</title>
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
		快速备注
		
		<table>
			<tr>
				<td><button>不辣</button></td>
				<td><button>微辣</button></td>
				<td><button>中辣</button></td>
				<td><button>特辣</button></td>
			</tr>
			<tr>
				<td><button>不要香菜</button></td>
				<td><button>多放醋</button></td>
				<td><button>多放葱</button></td>
				<td><button>少放盐</button></td>
			</tr>
		</table>
	</div>

	
	<div class="content">
		其他备注
		<form>
		<input type="text" name="notes">	
		</form>
	</div>
	<div class="content">
		<a href="http://localhost:8888/order1/confirmOrderInfo"><button onclick="">确定</button></a>
	</div>
	
</body>
</html>