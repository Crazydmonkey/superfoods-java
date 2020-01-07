<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>shopping</title> 
        <base href="/images/"></base>  -->
  
    <style>
        td{
            border: 1px solid rebeccapurple;
            width: 150px;
            text-align: center;
        }
    </style>
<!-- </head>
<body> -->
<table>
<thead>
    <tr>
        <input type="text" placeholder="请输入商品名称">
        <img src="mine.png" width="20px">
        <select name="category" id="" class="form-control">
               <option value="">大米</option>
               <option value="0">面</option>
               <option value="1">3</option>
               <option value="2">4</option>
               <option value="3">5</option>
        <input type="checkbox" id="check">全选
        <button>删除</button>
    </tr>
<tr>
    
    <td>序号</td>
    <td>商品图</td>
    <td>商品名称</td>
    <td>价格</td>
    <td>库存</td>
    <td>操作</td>
</tr>
</thead>
<tbody id="tbody">
<tr>
    <td><input type="checkbox" name="user">1</td>
    <td><img src="" alt=""></td>
    <td>大米</td>
    <td>￥10</td>
    <td>100</td>
    <td><button>删除</button><button>编辑</button></td>
</tr>
<tr>
    <td><input type="checkbox" name="user">2</td>
    <td><img src="" alt=""></td>
    <td>大米</td>
    <td>￥10</td>
    <td>100</td>
    <td><button>删除</button><button>编辑</button></td>
</tr>
<tr>
    <td><input type="checkbox" name="user">3</td>
    <td><img src="" alt=""></td>
    <td>大米</td>
    <td>￥10</td>
    <td>100</td>
    <td><button>删除</button><button>编辑</button></td>
</tr>
<tr>
    <td><input type="checkbox" name="user">4</td>
    <td><img src="" alt=""></td>
    <td>大米</td>
    <td>￥10</td>
    <td>100</td>
    <td><button>删除</button><button>编辑</button></td>
</tr>
<tr>
    <td><input type="checkbox" name="user">5</td>
    <td><img src="" alt=""></td>
    <td>大米</td>
    <td>￥10</td>
    <td>100</td>
    <td><button>删除</button><button>编辑</button></td>
</tr>
<tr>
    <td><input type="checkbox" name="user">6</td>
    <td><img src="" alt=""></td>
    <td>大米</td>
    <td>￥10</td>
    <td>100</td>
    <td><button>删除</button><button>编辑</button></td>
</tr>
</tbody>
</table>
<div>
    <a href="">上一页</a>
    <a href="">1</a>
    <a href="">2</a>
    <a href="">3</a>
    <a href="">4</a>
    <a href="">下一页</a>
</div>
<!-- </body> -->
<script>
    document.getElementById("check").onclick = function(){
        var checked = document.getElementById("check").checked;
        var checkson = document.getElementsByName("user");
        if(checked){
            for(var i = 0; i < checkson.length ;i++){
                checkson[i].checked = true;
            }
        }else{
            for(var i = 0; i < checkson.length ;i++){
                checkson[i].checked = false;
            }
        }
    }
</script>
</html>
