<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 待确认订单 -->
<div id="user">
	<!-- <div>
		
		<form id="orderSearch" action="getOrderConditionPage2" method="get" onsubmit="return saveReport();">
			<input type="datetime-local" name="beforeDate">
			<input type="datetime-local" name="afterDate">
			<input type="number" name="orderId" placeholder="订单id">
			<input type="number" name="deliverymanId" placeholder="配送员id">
			<input type="text" name="订单状态" placeholder="状态">
			<input id="order" type="submit" value="检索">
		</form>
		
	
	</div> -->
	<!-- <a href="orderInfo.do" target="_self">跳转</a> -->
	<div>
		<!-- 订单项 -->
		<table class="table table-hover">
			<thead>
				<tr style="background: #E8E8E8;">
					<th>序号</th>
					<th>订单号</th>
					<th>客户</th>
					<th>手机号</th>
					<th>收货地址</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
			
			</thead>
			<tbody name="order">
					<td>001</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>
						<input type="button" value="查看详情">
						<input type="button" value="接受订单">
						<input type="button" value="拒绝订单">
					</td>
			</tbody>
			<tbody name="order">
					<td>001</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>
						<input type="button" value="查看详情">
						<input type="button" value="接受订单">
						<input type="button" value="拒绝订单">
					</td>
			</tbody>
			<tbody name="order">
					<td>001</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>
						<input type="button" value="查看详情">
						<input type="button" value="接受订单">
						<input type="button" value="拒绝订单">
					</td>
			</tbody>
			<tbody name="order">
					<td>001</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>
						<input type="button" value="查看详情">
						<input type="button" value="接受订单">
						<input type="button" value="拒绝订单">
					</td>
			</tbody>
			<tbody name="order">
					<td>001</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>
						<input type="button" value="查看详情">
						<input type="button" value="接受订单">
						<input type="button" value="拒绝订单">
					</td>
			</tbody>
			<tbody name="order">
					<td>001</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>
						<input type="button" value="查看详情">
						<input type="button" value="接受订单">
						<input type="button" value="拒绝订单">
					</td>
			</tbody>
		
		</table>
		<div>
			<button>&lt;</button>
			<button>1</button>
			<button>2</button>
			<button>3</button>
			<button>4</button>
			<button>5</button>
			<button>6</button>
			<button>7</button>
			<button>&gt;</button>
			<select name="" id="">
				<option value="">1页</option>
				<option value="">2页</option>
				<option value="">3页</option>
				<option value="">4页</option>
				<option value="">5页</option>
				<option value="">6页</option>
				<option value="">7页</option>
				<option value="">8页</option>
				<option value="">9页</option>
			</select>
		</div>
		
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
<!--

//-->
</script>
<script type="text/javascript">
	$(function() {
		//页面加载完成后 立即加载ajax请求  获取用户角色类型信息
		//url,[data],[callback]
		//url:发送请求地址     data:待发送 Key/value 参数     callback:载入成功时回调函数。
		
		$.getJSON("/getOrderConditionPage2?pageNum=1&pageSize=5", function(data) {
			console.log("订单信息："+data.code);
			console.log("订单信息---："+data.data.list[0].userOrder.id);
			console.log("订单信息====："+data.data.list[0].userOrder.orderTime);

			//console.log("订单信息："+json["code"]);
			//遍历 显示用户信息
			var orders = "";
			$.each(data.data.list, function(index, item) {
				console.log(item.userOrder.id+"..");
				console.log(item.deliveryman.name+"..");
				console.log(item.customer.nickname+"..");
				orders+="<tr><td>"+item.userOrder.id+"</td>"+
						"<td>"+item.deliveryman.name+"</td>"+
						"<td>"+item.customer.phoneNumber+"</td>"+
						"<td>"+item.customer.address+"</td>"+
						"<td>"+item.userOrder.status+"</td>"+
						"<td>"+item.userOrder.orderTime+"</td>"+
						"<td>"+item.userOrder.deliveryTime+"</td>"+
						"<td>"+item.customer.nickname+"</td>"+
						"<td><i>接单</i>&nbsp;&nbsp;/&nbsp;<i>取消</i></td>"+
						"</tr>";
						
			})
			$("tbody[name=order]").each(function() {
				$(this).empty();
				$(this).append(orders);
			})
		})
		
	})
	

	function saveReport() {
		// jquery 表单提交 
		$("#orderSearch").ajaxSubmit(function(data) {
			// 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容 
			var orders = "";
			$.each(data.data.list, function(index, item) {
				console.log(item.userOrder.id+"..");
				console.log(item.deliveryman.name+"..");
				console.log(item.customer.nickname+"..");
				orders+="<tr><td>"+item.userOrder.id+"</td>"+
						"<td>"+item.deliveryman.name+"</td>"+
						"<td>"+item.customer.phoneNumber+"</td>"+
						"<td>"+item.customer.address+"</td>"+
						"<td>"+item.userOrder.status+"</td>"+
						"<td>"+item.userOrder.orderTime+"</td>"+
						"<td>"+item.userOrder.deliveryTime+"</td>"+
						"<td>"+item.customer.nickname+"</td>"+"</tr>"+
						"<butt";
						/* $("div[name=order]").each(function() {
							$(this).empty();
							$(this).append(orders);
						}) */
			})
			$("tbody[name=order]").each(function() {
				$(this).empty();
				$(this).append(orders);
			})
		});
		return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转 
	}
	
	
	
</script>