package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Collection;
import com.briup.smart.service.CollectionService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="收藏夹模块")
@RestController
public class CollectionController {
	@Autowired
	private CollectionService collectionService;
	
	@ApiOperation(value="指定用户收藏收藏指定商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name="goodsId",value="商品id",required=true),
		@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	})
	@PostMapping("/collection")
	public Response<String> addCollection(Long customerId,Long goodsId){
		collectionService.addCollection(customerId,goodsId);
		return Response.ok("收藏成功");
	}
	
	@ApiOperation(value="指定用户取消收藏指定商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name="goodsId",value="商品id",required=true),
		@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	})
	@DeleteMapping("/collection")
	public Response<String> deleteCollection(Long customerId,Long goodsId){
		collectionService.deleteCollection(customerId,goodsId);
		return Response.ok("已取消收藏");
	}
	
	@ApiOperation(value="获取指定用户所有的收藏")
	@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	@GetMapping("/collection/all")
	public Response<List<Collection>> getAllCollection(Long customerId){
		List<Collection> list=collectionService.getAllCollection(customerId);
		return Response.ok(list);
	}
	
	@ApiOperation(value="判断指定商品是否被指定顾客收藏")
	@ApiImplicitParams({
		@ApiImplicitParam(name="goodsId",value="商品id",required=true),
		@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	})
	@GetMapping("/collection/beCollected")
	public Response<String> beCollected(Long customerId,Long goodsId){
		boolean isCollected = collectionService.beCollected(customerId, goodsId);
		if(isCollected) {
			return Response.ok("已收藏");
		}
		return Response.ok("未收藏");
	}
	
}
