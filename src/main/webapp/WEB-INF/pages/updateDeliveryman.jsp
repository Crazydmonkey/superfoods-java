<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 	<style type="text/css">
		*{
			font-size: 30px;
		}
		header{
			text-align: center;
			margin-bottom: 10px
		}
		div{
			margin: 0 auto;
			padding-top: 10px;
			background: gray;
			width:600px;
			height: 300px;
			vertical-align: center;
			border: 1px solid black;

		}
		#confirm{
			margin-top: 20px;
			padding:10px;
			float: right;
			border: 1px solid black;
		}
		input{
			margin-top: 10px;
		}

	</style> -->
	<header><font style="font-size: 60px;">修改骑手</font></header>
	<div>
		骑手编号：<input type="text" placeholder="请输入骑手编号"><br/>
        骑手姓名：<input type="apssword" placeholder="请输入骑手姓名"><br/>
        骑手电话：<input type="text" placeholder="请输入骑手电话">
        <input type="submit" id="confirm" value="保存" onClick="window.location.href = document.referrer;">
    </div>
