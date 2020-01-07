package com.briup.smart.web.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.Goods;
import com.briup.smart.bean.GoodsCategory;
import com.briup.smart.service.GoodsService;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "商品管理模块")
@RestController
public class GoodsController {
	@Autowired
	private GoodsService service;

//	@ApiOperation(value="增加商品和修改商品",notes="增加商品和修改商品")
//	@PostMapping("/goods")
//	public Response<String> update(Goods goods){
//		System.out.println("goods:"+goods);
//		service.Update(goods);
//		return Response.ok("操作成功");
//	}

	@ApiOperation(value = "删除商品", notes = "根据商品编号删除商品信息")
	@ApiImplicitParam(name = "id", value = "商品编号", paramType = "path", required = true)
	@DeleteMapping("/goods/{id}")
	public Response<String> deleteGoods(@PathVariable("id") Long id) {
		try {
			service.deleteGoodsById(id);
		} catch (DataAccessException e) {
			System.out.println("message start-------");
			System.out.println(e.getMessage());
			System.out.println("message end----------");
			System.out.println(e.getCause());
			if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
				return new Response<String>(300, "业务异常", "删除失败，此商品已被收藏或购买，无法删除");
			}
		}
		return Response.ok("删除成功");
	}

	@ApiOperation(value = "批量删除商品", notes = "根据id批量删除")
	/* @ApiImplicitParam(name="ids",value="商品编号",required=true) */
	@DeleteMapping("/goods/many")
	public Response<String> deletes(@RequestParam List<Long> ids) {
		for (Long id : ids) {
			System.out.println(id);
		}
		try {
			service.deletesGoodsById(ids);
		} catch (DataAccessException e) {
			System.out.println("message start-------");
			System.out.println(e.getMessage());
			System.out.println("message end----------");
			System.out.println(e.getCause());
			if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
				return new Response<String>(300, "业务异常", "删除失败，此商品已被收藏或购买，无法删除");
			}
		}
		return Response.ok("操作成功");
	}

	@ApiOperation(value = "增加商品或修改商品，传入id为修改，不传id为增加", notes = "增加商品和修改商品（包含图片）")
	// @ApiImplicitParam(name="file",value="图片")
	@PutMapping("/goods")
	public Response<String> addOrUpdateGoods(Goods goods, MultipartFile file) {
		service.addOrUpdateGoods(goods, file);
		return Response.ok("操作成功");
	}
	
	
	@ApiOperation(value = "增加或修改商品分类", notes= "增加或修改商品分类")
	@PostMapping("/addGoodsCategory")
	public Response<String> addGoodsCategory(GoodsCategory goodsCategory) {
		String result=service.addGoodsCategory(goodsCategory);
		return Response.ok(result);
	}
	
	
	@ApiOperation(value = "删除商品分类", notes= "删除商品分类")
	@ApiImplicitParam(name="id",value="商品分类id",required=true)
	@DeleteMapping("/deleteGoodsCategory")
	public Response<String> deleteGoodsCategory(Long id) {
		String result=service.deleteGoodsCategory(id);
		return Response.ok(result);
	}
	
	
	@ApiOperation(value = "获取全部商品分类（分页）", notes= "获取全部商品分类（分页）")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="商品分类"),
		@ApiImplicitParam(name="pageSize",value="商品分类"),
		@ApiImplicitParam(name="category",value="商品分类",allowableValues="shopping,food,all")
	})
	@GetMapping("/getGoodsCategory")
	public Response<PageInfo<GoodsCategory>> getGoodsCategory(int pageNum,int pageSize,String category) {
		PageInfo<GoodsCategory> result=service.getGoodsCategory(pageNum, pageSize, category);
		return Response.ok(result);
	}
	
	
}
