package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Deliveryman;
import com.briup.smart.service.DeliverymanService;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "骑手管理模块")
@RestController
public class DeliverymanController {
	@Autowired
	private DeliverymanService dmservice;

	@ApiOperation(value = "添加或修改骑手信息，不传id为添加，传入id为修改")
	@PostMapping("/deliveryman")
	public Response<String> insertDeliveryman(Deliveryman dm) {
		dmservice.addDeliveryman(dm);
		return Response.ok("success");
	}
	
	@ApiOperation(value = "按照编号刪除骑手信息")
	@ApiImplicitParam(name = "id", value = "骑手编号", paramType = "path", required = true)
	@DeleteMapping("/deliveryman/{id}")
	public Response<String> deleteDm(@PathVariable("id") Long id) {
		dmservice.deleteDeliveryman(id);
		return Response.ok("success");
	}
	
	@ApiOperation(value="根据输入条件查找骑手信息", notes="姓名：模糊匹配")
	@GetMapping("/deliverymans/condition")
	public Response<List<Deliveryman>> selectDeliveryman(Deliveryman dm){
		return Response.ok(dmservice.selectDeliveryman(dm));
	}
	
	@ApiOperation(value="根据输入条件查找骑手信息 分页 ", notes="姓名：模糊匹配")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3")
	})
	@GetMapping("/deliverymans/condition/page")
	public Response<PageInfo<Deliveryman>> selectDeliveryman(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
			@RequestParam(name="pageSize",defaultValue="3")int pageSize,Deliveryman dm){
		return Response.ok(dmservice.selectDeliveryman(pageNum, pageSize, dm));
	}
	
	@ApiOperation(value="按照编号查找骑手信息",notes="按照编号查找骑手信息")
	@ApiImplicitParam(name = "id", value = "骑手编号", paramType = "path", required = true)
	@GetMapping("/deliveryman/{id}")
	public Response<Deliveryman> selectDmById(@PathVariable("id") Long id) {
		return Response.ok(dmservice.selectDeliverymanById(id));
	}
	
	@ApiOperation(value="查看骑手列表")
	@GetMapping("/deliverymans")
	public Response<List<Deliveryman>> selectAllDeliveryman() {
		return Response.ok(dmservice.selectAllDeliveryman());
	}
	
	@ApiOperation(value="查看骑手列表 分页")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3")
	})
	@GetMapping("deliverymans/page")
	public Response<PageInfo<Deliveryman>>selectAll(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
			@RequestParam(name="pageSize",defaultValue="3")int pageSize){
		return Response.ok(dmservice.selectAllDeliveryman(pageNum, pageSize));
	}
}
