package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Goods;
import com.briup.smart.bean.GoodsCategory;
import com.briup.smart.service.FindGoodsService;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "商品查找模块")
@RestController
public class FindGoodsController {
	@Autowired
	private FindGoodsService fgservice;
	
	@ApiOperation(value = "根据商品所属分区(超市|餐饮)查找商品类别列表")
	@ApiImplicitParam(name = "region", value = "商品分区", paramType = "path", required = true,allowableValues="food,shopping")
	@GetMapping("/findGoods/goodsCategory/{region}")
	public Response<List<GoodsCategory>> selectGoodsCategoryByRegion(@PathVariable String region) {
		return Response.ok(fgservice.selectGoodsCategoryByRegion(region));
	}

	@ApiOperation(value = "根据商品所属分区(超市|餐饮)查找商品类别列表 分页 ")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3"),
		@ApiImplicitParam(name ="region", value = "商品分区", paramType = "path", required = true,allowableValues="food,shopping")
    })
	@GetMapping("/findGoods/goodsCategory/{region}/page")
	public Response<PageInfo<GoodsCategory>> selectGoodsCategoryByRegion(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "3") int pageSize,@PathVariable String region) {
		return Response.ok(fgservice.selectGoodsCategoryByRegioin(pageNum, pageSize, region));
	}

	@ApiOperation(value = "根据商品类别编号查找商品列表")
	@ApiImplicitParam(name = "categoryId", value = "商品类别编号", paramType = "path", required = true)
	@GetMapping("/findGoods/goods/{categoryId}")
	public Response<List<Goods>> selectGoodsByCategoryId(@PathVariable Long categoryId) {
		return Response.ok(fgservice.selectGoodsByCategoryId(categoryId));
	}
	
	@ApiOperation(value = "根据商品类别编号查找商品列表 分页 ")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3"),
		@ApiImplicitParam(name ="categoryId", value = "商品类别编号", paramType = "path", required = true)
    })
	@GetMapping("/findGoods/goods/{categoryId}/page")
	public Response<PageInfo<Goods>> selectGoodsByCategoryId(
			@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "3") int pageSize,@PathVariable Long categoryId) {
		return Response.ok(fgservice.selectGoodsByCategoryId(pageNum, pageSize, categoryId));
	}
	
	@ApiOperation(value = "根据商品编号查找商品的详细信息")
	@ApiImplicitParam(name = "id", value = "商品编号", paramType = "path", required = true)
	@GetMapping("/findGoods/goodsDetails/{id}")
	public Response<Goods> selectGoodsById(@PathVariable Long id) {
		return Response.ok(fgservice.selectGoodsById(id));
	}
	
	@ApiOperation(value = "超市-搜索框:根据商品名称查找商品 模糊匹配")
	@ApiImplicitParam(name ="name", value = "商品名称", paramType = "path", required = true)
	@GetMapping("/findGoods/goods/shopping/{name}")
	public Response<List<Goods>> selectGoodsByNameShopping(@PathVariable String name) {
		return Response.ok(fgservice.selectGoodsByNameShopping(name));
	}
	
	@ApiOperation(value = "超市-搜索框:根据商品名称查找商品 模糊匹配 分页")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3"),
		@ApiImplicitParam(name ="name", value = "商品名称", paramType = "path", required = true)
    })
	@GetMapping("/findGoods/goods/shopping/{name}/page")
	public Response<PageInfo<Goods>> selectGoodsByNameShopping(
			@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "3") int pageSize,@PathVariable String name) {
		return Response.ok(fgservice.selectGoodsByNameShopping(pageNum, pageSize, name));
	}
	
	@ApiOperation(value = "餐饮-搜索框:根据商品名称查找商品 模糊匹配")
	@ApiImplicitParam(name ="name", value = "商品名称", paramType = "path", required = true)
	@GetMapping("/findGoods/goods/food/{name}")
	public Response<List<Goods>> selectGoodsByNameFood(@PathVariable String name) {
		return Response.ok(fgservice.selectGoodsByNameFood(name));
	}
	
	@ApiOperation(value = "餐饮-搜索框:根据商品名称查找商品 模糊匹配 分页")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3"),
		@ApiImplicitParam(name ="name", value = "商品名称", paramType = "path", required = true)
    })
	@GetMapping("/findGoods/goods/food/{name}/page")
	public Response<PageInfo<Goods>> selectGoodsByNameFood(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "3") int pageSize,@PathVariable String name) {
		return Response.ok(fgservice.selectGoodsByNameFood(pageNum, pageSize, name));
	}
	
	@ApiOperation(value = "根据商品所属分区查找商品")
	@ApiImplicitParams({
    	@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="5"),
		@ApiImplicitParam(name="region", value="商品分区（超市、餐饮）",  required=true)
    })
	@GetMapping("/findGoods/goodsAll/{region}/page")
	public Response<PageInfo<Goods>> getGoodsByRegion(int pageNum, int pageSize,@PathVariable String region){
		return Response.ok(fgservice.selectGoodsByRegion(pageNum, pageSize, region));
	}

}
