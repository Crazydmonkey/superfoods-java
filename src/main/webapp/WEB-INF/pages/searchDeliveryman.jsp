<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<font style="font-size: 60px;">骑手信息</font>

<div>
	<input type="button" id="add" value="添加骑手"><br />
	<table cellspacing="0" align="center" width="80%" border="2px"
		style="text-align: center">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>电话</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${deliveryman}" var="dm">
			<tr>
				<td>${dm.id}</td>
				<td>${dm.name}</td>
				<td>${dm.phoneNumber}</td>
				<td><input type="button" id="update" value="修改信息"> 
				<input type="button" id="delete" value="删除信息"">
				</td>
			</tr>
		</c:forEach>
	</table>
	<ul class="pagination">
		<li><a href="#">&laquo;</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">&raquo;</a></li>
	</ul>
</div>
<div class="modal" id="toAdd">
	<div class="modal-dialog" style="height: 400px; overflow: auto;">
		<div class="modal-content">
			<form id="dmForm">
				<div class="modal-body">
					<div class="form-group">
						<label>骑手姓名:</label> <input type="text" name="name"
							class="form-control"> <input type="hidden" name="id">
					</div>
					<div class="form-group">
						<label>骑手电话:</label> <input type="tel" name="phoneNumber"
							class="form-control">
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button class="btn">取消</button>
				<button class="btn">保存</button>
			</div>
		</div>
	</div>
</div>
<div class="modal" id="toDelete">
	<div class="modal-dialog" style="width: 350px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">是否确定删除</h4>
			</div>
			<div class="modal-footer">
				<button type="button" class="cancel" data-dismiss="modal">取消</button>
				<button type="button" class="confirm">确定</button>
			</div>
		</div>
	</div>
</div>
<style>
#add {
	margin-left: 680px;
}

#toAdd {
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	$(function(){
		var id;
		$('#add').click(function(){
			$("#dmForm input[type=hidden]").val("");
			$("#dmForm input[name=name]").val("");
			$("#dmForm input[name=phoneNumber]").val("");
			$('#toAdd').show();
		})
		$('button:contains(取消)').on('click',function(){
			$('button[type=reset]').trigger('click');
				$('#toAdd').hide();
		})
		$('button:contains(保存)').on('click',function(){
			var param = $("#dmForm").serialize();
			console.log(param);
			$.post("/deliveryman",param,function(msg){
				alert(msg);
			});
			$('#toAddDm').hide();
		})
		$('#update').click(function(){
			var deliverymans = 
				$(this).attr("value").split("-");
			console.log(users);
			$("#dmForm input[type=hidden]").val(deliverymans[0]);
			$("#dmForm input[name=name]").val(deliverymans[1]);
			$("#dmForm input[name=phoneNumber]").val(deliverymans[2]);
			$('#toAdd').show();
		})
		$('#delete').click(function(){
			id = $(this).attr("id");
			console.log("要删除的id："+id);
			$('#toDelete').show();
		})
			$('.close').click(function(){
			$('#deleteModal').hide();
		})
			$('.canael').click(function(){
			$('#toDelete').hide();
		})
			$('.confirm').click(function(){
			$.post("/deliveryman/{id}",
				 "id="+id,function(data){
			});
			$('#toDelete').hide();
		})
	}
</script>
