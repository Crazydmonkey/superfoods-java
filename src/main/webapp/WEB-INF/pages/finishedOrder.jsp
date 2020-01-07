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
		<span>销售订单日期：<input type="text" >~<input type="text"></span><br>
		<span>销售订单号：&nbsp;&nbsp;&nbsp;<input type="text"></span><br>
		<span>配送人员：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"></span>
		<button>查询</button>
		<!-- 订单项 -->
		<table class="table table-hover">
			<thead>
				<tr style="background: #E8E8E8;">
					<th>销售日期</th>
					<th>订单号</th>
					<th>客户</th>
					<th>手机号</th>
					<th>收货地址</th>
					<th>金额</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			
			</thead>
			<tbody name="order">
					<td>2019.12.10</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>已完成</td>
					<td>
						<input type="button" value="查看详情">
					</td>
			</tbody>
			<tbody name="order">
					<td>2019.12.10</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>已完成</td>
					<td>
						<input type="button" value="查看详情">
					</td>
			</tbody>
			<tbody name="order">
					<td>2019.12.10</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>已完成</td>
					<td>
						<input type="button" value="查看详情">
					</td>
			</tbody>
			<tbody name="order">
					<td>2019.12.10</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>已完成</td>
					<td>
						<input type="button" value="查看详情">
					</td>
			</tbody>
			<tbody name="order">
					<td>2019.12.10</td>
					<td>SCB1998</td>
					<td>A客户</td>
					<td>13233449999</td>
					<td>昆山杰普</td>
					<td>666</td>
					<td>已完成</td>
					<td>
						<input type="button" value="查看详情">
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
