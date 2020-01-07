package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.UserOrder;
import com.briup.smart.service.UserOrderService1;
import com.briup.smart.web.vm.OrderResponseVM;
import com.briup.smart.web.vm.Response;
import com.briup.smart.web.vm.UserOrderVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="顾客端订单模块")
@RestController
public class UserOrderController1 {

	@Autowired
	private UserOrderService1 userOrderService;
	
	//TODO 获取当前用户的所有订单的概要信息:分页、不分页
	@ApiOperation(value="获取未被顾客删除订单的概要信息", notes="下单时间、订单金额、订单状态")
	@ApiImplicitParam(name="customerId",value="顾客编号",required = true)
	@GetMapping("/userOrder/orders")
	public Response<List<OrderResponseVM>> getOrders(Long customerId){
		return Response.ok(userOrderService.getUserOrders(customerId));
	}
	
	// 获取指定用户的指定状态订单的概要信息
	@ApiOperation(value="获取指定用户的指定状态订单的概要信息", notes="下单时间、订单金额、订单状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name="customerId",value="顾客编号",required = true),
		@ApiImplicitParam(name="status",value="订单状态",required = true, allowableValues="待接单,待发货,待收货,已完成,已取消")
	})
	@GetMapping("/userOrder/orders/status")
	public Response<List<OrderResponseVM>> getOrdersByStatus(Long customerId, String status){
		return Response.ok(userOrderService.getUserOrdersByStatus(customerId, status));
	}
	
	@ApiOperation(value="获取指定订单的详细信息及订单项信息", notes="订单编号、下单时间、订单金额、订单状态、"
			+ "预计送达时间、支付方式、订单备注、是否取消、取消原因、骑手编号、顾客编号")
	@ApiImplicitParam(name="id",value="订单编号",paramType="path",required=true)
	@GetMapping("/userOrder/order/{id}")
	public Response<OrderResponseVM> getOrderById(@PathVariable("id") Long id){
		return Response.ok(userOrderService.getUserOrderById(id));
	}
	
	//TODO 
	@ApiOperation(value="保存订单及订单项信息")
	@GetMapping("/userOrder/order")
	public Response<Long> saveOrder(UserOrderVM userOrderVM){
		UserOrder userOrder = new UserOrder();
		
		userOrder.setAmount(userOrderVM.getAmount());
		userOrder.setCustomerId(userOrderVM.getCustomerId());
		userOrder.setMethodsOfPayment(userOrderVM.getMethodsOfPayment());
		
		String notes = userOrderVM.getNotes();
		userOrder.setNotes(notes);
		
		Long id = userOrderService.saveOrderAndOrderItems(userOrder, userOrderVM.getOrderItemIds());
		return Response.ok(id);
	}
	
}
