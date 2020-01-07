<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 待确认订单 -->
<!-- <div id="user">
	
	<div>
		<table>
			<tr>
				<td   rowspan="2"  style="width:600px;height:300px">
					<div id="userOrder">
						订单信息<br>
						账号：<br>
						金额：<br>
						状态：<br>
						下单时间：<br>
						预计送达时间：<br>
						支付方式：<br>
						备注：<br>
						是否取消：<br>
						是否被删除：<br>
					</div>
				</td>
				<td>
					<div id="customer">
						客户信息<br>
						昵称：<br>
						真实姓名：<br>
						性别：<br>
						地址：<br>
						电话号码：<br>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="deliveryman">
						配送员信息<br>
						编号：<br>
						姓名：<br>
						手机号码：<br>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div>
		订单项
		<table class="table table-hover">
			<thead>
				<tr style="background: #E8E8E8;">
					<th colspan="2">商品</th>
					<th>价格</th>
					<th>数量</th>
					<th>总价</th>
				</tr>
			</thead>
			<tbody name="goods">
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
				</tr>
			</tbody>
		
		</table>
	</div>
	
		
</div> -->



<div>
	<div>
		<table>
			<tr>
				<th>订单编号：</th>
				<td>20019840</td>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金额：</th>
				<td>￥84</td>
			</tr>
			<tr>
				<th>下单时间：</th>
				<td>2019-8-8</td>
				<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单状态：</th>
				<td>待收货</td>
			</tr>
		</table>
		<HR color=#987cb9 SIZE=3>
	</div>
	<div>
		<table>
			<tr style="background-color: #E8E8E8;">
				<th>商品图片</th>
				<th>商品名称</th>
				<th>商品类别</th>
				<th>价格</th>
				<th>数量</th>
				<th>总价</th>
			</tr>
			<tr>
				<td><img src="" alt="图片"></td>
				<td>可比克薯片</td>
				<td>零食</td>
				<td>￥4.5</td>
				<td>3</td>
				<td>￥13.5</td>
			</tr>
			<tr>
				<td><img src="" alt="图片"></td>
				<td>可比克薯片</td>
				<td>零食</td>
				<td>￥4.5</td>
				<td>3</td>
				<td>￥13.5</td>
			</tr>
			<tr>
				<td><img src="" alt="图片"></td>
				<td>可比克薯片</td>
				<td>零食</td>
				<td>￥4.5</td>
				<td>3</td>
				<td>￥13.5</td>
			</tr>
		</table>
		<HR color=#987cb9 SIZE=3>
	</div>		
	<div>
		<table >
			<tr>
				<th>订单备注：</th>
				<td colspan="2" >到山东安佛ID哦是否你从IM从我的家少的搜啊觉得披萨京东怕时间破的就欧赔近赛跑囧</td>
			</tr>
			<tr>
				<td>张三</td>
				<td>昆山杰普</td>
				<td>13213216548</td>
			</tr>
		</table>
	</div>
</div>
<style>
#user {
	width: 1140px;
	overflow: hidden;
}

.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	.pagination>.active>span, .pagination>.active>span:focus, .pagination>.active>span:hover
	{
	background-color: #ccc;
	border-color: #ccc;
}

.pagination>li>a, .pagination>li>span {
	color: black;
}

.fenye {
	margin-left: 400px;
}

.form-inline {
	margin-top: 15px;
	margin-left: 10px;
	margin-bottom: 20px;
}

.search {
	margin-left: 50px;
}

#add {
	margin-left: 680px;
}

.table th, td {
	text-align: center;
}

#deleteModal {
	margin-top: 100px;
}

#toAdd {
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	$(function() {
		//页面加载完成后 立即加载ajax请求  获取用户角色类型信息
		//url,[data],[callback]
		//url:发送请求地址     data:待发送 Key/value 参数     callback:载入成功时回调函数。
		
		$.getJSON("/getOrderConditionPage2?pageNum=0&pageSize=0&orderId=11", function(data) {
			console.log("订单信息："+data);
			console.log("订单信息："+data.data.list[0].userOrder.id);
			var orders = "";
			var customer = "";
			var deliveryman = "";
			$.each(data.data.list, function(index, item) {
				console.log(item.userOrder.id+"..");
				console.log(item.deliveryman.name+"..");
				console.log(item.customer.nickname+"..");
				console.log(item.userOrder.list[0].goodsId+"123");
						
				orders+="订单信息<br>"+
						"账号："+item.userOrder.id+"<br>"+
						"金额："+item.userOrder.amount+"<br>"+
						"状态："+item.userOrder.status+"<br>"+ 
						"下单时间："+item.userOrder.orderTime+"<br>"+ 
						"预计送达时间："+item.userOrder.deliveryTime+"<br>"+ 
						"支付方式："+item.userOrder.methodsOfPayment+"<br>"+ 
						"备注："+item.userOrder.notes+"<br>"+ 
						"是否取消："+item.userOrder.isCanceled+"<br>"+ 
						"是否被删除："+item.userOrder.deleted+"<br>";
						
				customer+="客户信息<br>"+
						"昵称："+item.customer.nickname+"<br>"+
						"真实姓名："+item.customer.realName+"<br>"+
						"性别："+item.customer.gender+"<br>"+
						"地址："+item.customer.address+"<br>"+
						"电话号码："+item.customer.phoneNumber+"<br>";
						
					
				deliveryman+="配送员信息<br>"+
							"编号："+item.deliveryman.id+"<br>"+
							"姓名："+item.deliveryman.name+"<br>"+
							"手机号码："+item.deliveryman.phoneNumber+"<br>";
			})
			$('#userOrder').each(function() {
				$(this).empty();
				$(this).append(orders);
			})
			$('#customer').each(function() {
				$(this).empty();
				$(this).append(customer);
			})
			$('#deliveryman').each(function() {
				$(this).empty();
				$(this).append(deliveryman);
			})
			
			
			var goodss="";
			$.each(data.data.list[0].userOrder.list, function(index, item) {
				console.log(item.goodsId+"商品");
				console.log(item.customerId+"商品");
				console.log(item.id+"商品");
				console.log(item.orderId+"商品");
				//同步
				$.ajaxSettings.async = false;
				$.getJSON("/findGoods/goods/id/"+item.goodsId+"", function(goods) {
					console.log("商品信息："+goods);
					console.log("商品信息："+goods.data.name);
					console.log("商品信息-订单信息："+item.quantity);
	
					goodss+="<tr><td><img width='80px' height='80px' src='http://localhost:8888/img/"+goods.data.picture+"'></td>"+
							"<td>"+goods.data.name+"</td>"+
							"<td>"+goods.data.price+"</td>"+
							"<td>"+item.quantity+"</td>"+
							"<td>"+item.amount+"</td>"+"</tr>";
				}) 
			})
			//取消同步
			$.ajaxSettings.async = true;
			
			$("tbody[name=goods]").each(function() {
				$(this).empty();
				console.log("商品========"+goodss);
				$(this).append(goodss);
			})
			
			
		})
		
	})
</script>