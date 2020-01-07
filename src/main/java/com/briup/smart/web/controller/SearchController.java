package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Search;
import com.briup.smart.service.SearchService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "搜索记录模块")
@RestController
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@ApiOperation(value = "添加指定用户的一条记录")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "keyword", value = "关键词", required = true),
		@ApiImplicitParam(name = "customerId", value = "顾客编号", required = true) })
	@PostMapping("/record")
	public Response<Number> addSearch(String keyword, Long customerId) {
		int add = searchService.addSearch(keyword, customerId);
		return Response.ok(add);
	}
	
	@ApiOperation(value = "删除指定用户的全部记录")
	@ApiImplicitParam(name = "customerId", value = "顾客编号", required = true)
	@DeleteMapping("/record")
	public Response<Number> deleteSerach(Long customerId) {
		int delete = searchService.deleteSearch(customerId);
		return Response.ok(delete);
	}
	
	@ApiOperation(value = "获取指定用户的全部记录")
	@ApiImplicitParam(name = "customerId", value = "顾客编号", required = true)
	@GetMapping("/record")
	public Response<List<Search>> getAllSearch(Long customerId) {
		List<Search> list = searchService.getAllSearch(customerId);
		return Response.ok(list);
	}
}
