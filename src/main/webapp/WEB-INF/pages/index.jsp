<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>客户关系管理</title>
<script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>

<link rel="stylesheet" href="./layui/css/layui.css">
<!-- <link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="css/bootstrapSwitch/css/bootstrap3/bootstrap-switch.min.css">
<script src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap-3.3.7/css/bootstrap.min.css">
<!-- <script src="css/bootstrapSwitch/css/bootstrap-switch.min.js"></script> -->
<script src="css/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="css/bootstrapSwitch/js/bootstrap-switch.min.js"></script>
<script src="js/router.js"></script>
<script src="js/form.js"></script>

<style src="css/index.css"></style>
<style type="text/css">
#inner p:first-child {
	margin-left: 300px;
	margin-top: 110px;
	font-size: 80px;
	color: white;
	text-shadow: black 0 0 10px;
}

#inner p:last-child {
	color: white;
	text-shadow: black 0 0 10px;
	margin-left: 550px;
	margin-top: 50px;
	font-size: 50px;
}

#inner {
	width: 1140px;
	overflow: hidden;
}

.layui-footer {
	text-align: center;
}

.layui-icon-chart-screen {
	position: relative;
	top: 15px;
	left: 5px;
	font-size: 30px;
	font-weight: bolder;
	color: #cde6c7;
}

.layui-body {
	padding: 10px;
	background-color: #F0F0F0;
	overflow: hidden;
}

.layui-body>div {
	/* position: absolute; */
	background-color: white;
	width: 100%;
	min-height: 550px;
}
</style>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<i class="layui-icon layui-icon-chart-screen"></i>
			<div class="layui-logo" style="font-size: 18px; font-weight: bolder;">超市&餐饮管理系统</div>

			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> 
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img"> ${user.usrName}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="login.html">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					
					
					<c:forEach items="${resource}" var="r">
						<li class="layui-nav-item layui-nav-itemed">
							<a href="javascript:;">${r.name}</a>
							<c:forEach items="${r.subResources}" var="s">
								<dl class="layui-nav-child">
									<dd>
										<a href="javascript:;" url="${s.path}">${s.name}</a>
									</dd>
								</dl>
							
							</c:forEach>
						</li>
					</c:forEach>
					
					<li class="layui-nav-item layui-nav-itemed">
						<a href="javascript:;" url="businessLogin.do">登录</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" url="businessLogin.do">登录</a>
							</dd>
						</dl>	
					</li>
										
					<li class="layui-nav-item layui-nav-itemed">
						<a href="javascript:;">商品管理</a>
						
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" url="insertGoods.do">新增商品</a>
								</dd>
								<dd>
									<a href="javascript:;" url="goodsGood.do">美食商品</a>
								</dd>
								<dd>
									<a href="javascript:;" url="goodsShopping.do">超市商品</a>
								</dd>
							</dl>						
					</li>					
					<li class="layui-nav-item layui-nav-itemed">
						<a href="javascript:;">订单管理</a>
						
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" url="toBeReceivedOrder.do">等待确认订单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="toBeReceivedOrderDetails.do">等待确认订单详情</a>
								</dd>
								<dd>
									<a href="javascript:;" url="toBeSendingOrder.do">等待发货订单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="toBeSendingOrderDetails.do">等待发货订单详情</a>
								</dd>
								<dd>
									<a href="javascript:;" url="toBeReceivedGoodsOrder.do">等待收货订单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="toBeReceivedGoodsOrderDetails.do">等待收货订单详情</a>
								</dd>
								<dd>
									<a href="javascript:;" url="finishedOrder.do">已完成订单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="finishedOrderDetails.do">已完成订单详情</a>
								</dd>
								<dd>
									<a href="javascript:;" url="canceledOrder.do">已取消订单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="canceledOrderDetails.do">已取消订单详情</a>
								</dd>
								<dd>
									<a href="javascript:;" url="cancellingOrder.do">退单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="cancellingOrderDetails.do">退单详情</a>
								</dd>
								<dd>
									<a href="javascript:;" url="hurryOrder.do">催单</a>
								</dd>
								<dd>
									<a href="javascript:;" url="hurryOrderDetails.do">催单详情</a>
								</dd>
							</dl>						
					</li>			
							
					<li class="layui-nav-item layui-nav-itemed">
						<a href="javascript:;">骑手管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" url="searchDeliveryman.do">查看骑手</a>
								</dd>
								<dd>
									<a href="javascript:;" url="addDeliveryman.do">添加骑手</a>
								</dd>
								<dd>
									<a href="javascript:;" url="updateDeliveryman.do">修改骑手</a>
								</dd>
							</dl>						
					</li>					
					<li class="layui-nav-item layui-nav-itemed">
						<a href="javascript:;">收入展示</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" url="dayIncoming.do">查看收入</a>
								</dd>
							</dl>						
					</li>					
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div id="inner">
				<p>欢迎使用</p>
				<p>超市&餐饮管理系统</p>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			Copyright 2011-2018 杰普软件科技有限公司 ICP 05024518 | 营业执照
		</div>
	</div>
	<script src="./layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>