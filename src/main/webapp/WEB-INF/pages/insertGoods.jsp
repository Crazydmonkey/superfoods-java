<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>goods</title>
        <base href="/images/"></base>   -->

    <style>
    </style>
<!-- </head>
<body> -->
    <tr>
        <th>
            新增商品<br>
        </th>
    </tr>
    <tr>
        <td>商品名称：<input type="text"  placeholder="请输入商品名称"></td><br>
    </tr>
    <tr>
        商品类别：
        <select name="category" id="" class="form-control">
           <option value="">请选择商品类别</option>
           <option value="0">超市</option>
           <option value="1">美食</option>
        </select><br>
    </tr>
    <tr>
        <td>商品价格:<input type="text" placeholder="请输入商品价格"></td><br>
        <td>商品进价: <input type="text" placeholder="请输入商品进价"></td><br>
    </tr>
    <tr>
        商品图片:<input type="file"><br>
        <img src="" height="50" title="preview-img"><br>
        <td>最佳尺寸400×400</td>
        <td><button>上传图片</button></td><br>
    </tr>
    <tr>
        <td>商品描述：<input type="text"  placeholder="请输入商品描述"></td><br>
    </tr>
    <tr>
        <td>商品数量：<input type="text"  placeholder="请输入商品数量"></td>
    </tr>
            <script>
          var fileInput = document.querySelector('input[type=file]'),
                  previewImg = document.querySelector('img');
          fileInput.addEventListener('change', function () {
              var file = this.files[0];
              var reader = new FileReader();
              // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
              reader.addEventListener("load", function () {
                  previewImg.src = reader.result;
              }, false);
              // 调用reader.readAsDataURL()方法，把图片转成base64
              reader.readAsDataURL(file);
          }, false);
        </script>
<!-- </body>
</html> -->