<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 	<style type="text/css">
		*{
			text-align: center;
			font-size: 30px;
		}
		select{
			padding: 5px;
			text-align: center;
			margin-right:500px;
			float: right;
			padding: 20px;
		}
		tr,td,th{
			border:1px solid black;
			padding:5px,10px;
		}
		table{
			margin-top: 200px;
		}
		div{
			padding-top: 10px;
			height: 800px;
		}
		header,footer{
			height: 150px;
			padding-top: 40px;
		}
	</style> -->
	<script type="text/javascript">
		window.onload = initForm;
		window.onunload = function() {};
		function initForm() {
			document.getElementById("selectInfo").selectedIndex = 0;
			document.getElementById("selectInfo").onchange = jumpPage;
		}
		function jumpPage() {
			var newLoc = document.getElementById ("selectInfo");
			var newPage = newLoc.options [newLoc.selectedIndex].value;

			if (newPage != "") {
				window.location = newPage;
			}
		} 
	</script>
<header><font style="font-size: 60px;">收入展示</font></header>
<div>
	<select id="selectInfo" οnchange="window.location=this.value;">
		<option selected>选择查看形式</option>
		<option value="dayIncoming.do">查看日收入</option>
		<option value="monthIncoming.do">查看月收入</option>
		<option value="yearIncoming.do">查看年收入</option>
	</select>
		<table cellspacing="0" align="center" width="80%" border="2px"
		style="text-align: center">
			<tr>
	       	<th>时间</th>
			<th>收入</th>
			<th>完成订单数</th>
	    </tr>
	    <c:forEach items="${showIncoming}" var="incoming">
		<tr>
			<td>${incoming.time}</td>
			<td>${incoming.amount}</td>
			<td>${incoming.num}</td>
		</tr>
		</c:forEach>
	</table>
</div>
<footer>
	<div class="fenye">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">上一页</span>
					</a>
				</li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">下一页</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>

</footer>

