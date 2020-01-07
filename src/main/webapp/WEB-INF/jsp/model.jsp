<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello JSP</title>

</head>
<body>
---------------
	<form action="upload2" method="post" encty="multipart/form-data">
		编号:<input type="text" name="id"><br/>
		图片:<input type="file" name="picture"><br/>
		名称:<input type="text" name="name"><br/>
		
		价格<input type="text" name="price">
		数量:<input type="text" name="quantity"><br/>
		
		描述：<input type="text" name="description"><br>
		编号：<input type="text" name="categoryId"><br>
		
			<input type="submit" value="提交">
	</form>
	
	<div>
		<img  src="http://localhost:8888/img/2409timg (1).jpg">
	</div>
</body>
</html>
