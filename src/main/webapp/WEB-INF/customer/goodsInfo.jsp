<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<style type="text/css">
		body{
			background-color: gray;
		}
		header{
			padding-top: 30px;
			font-size: 30px;
			background: orange;
			text-align: center;
			height: 70px;
		}
        #img{margin: 0 auto;
        	height: 300px;
        	width:90%;
        	background-color: white;
        }
        #information{
        	padding-top: 5px;
        	height: 350px;
        	margin-top: 10px;
        	font-size: 20px;
        	margin-bottom: 10px;
        	background-color:white;
        }

        footer{
        	height: 60px;
           text-align: center;
           background-color: white;
           font-size: 20px;
           margin-top: 10px;
        }
        input{
        	padding: 5px;
        	height: 60px;
        	width:120px;
        	margin-left: 10px;
        }
	</style>
</head>
    <header>商品详情</header>
    <div id="img">
       <img src="">
    </div>
    <div id="information">
       名称:XXXXX<br/>
       价格:XXXXX<br/>
       描述:XXXXXXXXXXXXXXXXXXX<br/>
    </div>
    <footer>
    	<span><input type="button" name="collection" value="加入收藏夹" style="background: orange;"></span>
    	<span><input type="button" name="shoppingCart" value="加入购物车" style="background: orange;"></span>
    </footer>
</html>