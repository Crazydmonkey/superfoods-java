<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/springmvc-first/">
<meta charset="UTF-8">
<title>模型数据显示面</title>

</head>
<body>
	<form action="upload2" method="post">
		编号:<input type="text" name="id"><br/>
		图片:<input type="file" name="picture"><br/>
		名称:<input type="text" name="name"><br/>
		
		价格<input type="text" name="price">
		数量:<input type="text" name="quantity"><br/>
		
		描述：<input type="text" name="description"><br>
		编号：<input type="text" name="categoryId"><br>
		
			<input type="submit" value="提交">
	</form>
	
	

</body>
</html>