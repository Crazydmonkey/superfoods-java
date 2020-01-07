package com.briup.smart.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Option;
import com.briup.smart.bean.OrderData;
import com.briup.smart.bean.OrderDetail;
import com.briup.smart.bean.OrderInfo;
import com.briup.smart.bean.UserOrder;
import com.briup.smart.service.UserOrderServiceImpl2;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="商家端订单模块")
@RestController
public class UserOrderController2 {
	
	@Autowired
	private UserOrderServiceImpl2 orderSrevice;
	
	@ApiOperation(value="接受订单  改变商品库存",notes="接受订单  改变商品库存")
	@ApiImplicitParam(name="orderId",value="订单id",required=true)
	@PutMapping("/acceptOrder")
	public Response<UserOrder> acceptOrder(Long orderId){
		UserOrder order=orderSrevice.acceptOrder(orderId);
		return Response.ok(order);
	}

	@ApiOperation(value="根据id获取订单及订单项信息")
	@ApiImplicitParam(name="orderId",value="订单id",required=true)
	@GetMapping("/getOneOrder")
	public Response<UserOrder> getOneOrder(Long orderId){
		UserOrder order=orderSrevice.getOneOrder(orderId);
		return Response.ok(order);
	}
	
	@ApiOperation(value="根据状态获取订单及订单项信息")
	@ApiImplicitParam(name="status",value="订单状态",required=true,allowableValues="待接单,待发货,待收货,已完成,已取消")
	@GetMapping("/getOrderStatus")
	public Response<List<UserOrder>> getOrderStatus(String status){
		List<UserOrder> orders=orderSrevice.getOrderStatus(status);
		return Response.ok(orders);
	}
	
	@ApiOperation(value="根据条件检索订单及订单项信息")
	@GetMapping("/getOrderCondition")
	public Response<List<UserOrder>> getOrderCondition(Option option){
		List<UserOrder> list=orderSrevice.getOrder(option);
		return Response.ok(list);
	}
	
	
//	@ApiOperation(value="根据条件检索订单信息 分页",notes="根据条件检索订单信息 分页")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="pageNum",value="当前页码",required=false,defaultValue="1"),
//		@ApiImplicitParam(name="pageSize",value="每页显示数据个数(0是全部)",required=false,defaultValue="1"),
//	})
//	@GetMapping("/getOrderConditionPage")
//	public Response<PageInfo<UserOrder>> getOrderConditionPage(@RequestParam(name="pageNum",defaultValue="1" )int pageNum,
//			@RequestParam(name="pageSize",defaultValue="1")int pageSize,Option option){
//		PageInfo<UserOrder> orderPage=orderSrevice.getOrderPage(pageNum, pageSize, option);
//		return Response.ok(orderPage);
//	}
	
	
	@ApiOperation(value="根据条件检索订单及订单项信息、顾客信息、骑手信息 分页")
	@ApiImplicitParams({
		@ApiImplicitParam(name="pageNum",value="当前页码",required=false,defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数(0是全部)",required=false,defaultValue="1"),
	})
	@GetMapping("/getOrderConditionPage2")
	public Response<PageInfo<OrderInfo>> getOrderConditionPage2(@RequestParam(name="pageNum",defaultValue="1" )int pageNum,
			@RequestParam(name="pageSize",defaultValue="1")int pageSize,Option option){
		PageInfo<OrderInfo> orderPage=orderSrevice.getOrderPage2(pageNum, pageSize, option);
		return Response.ok(orderPage);
	}

	@ApiOperation(value="获取待接订单数量  催单数量  申请退单数量")
	@GetMapping("/getOrderData")
	public Response<OrderData> getOrderData() {
		OrderData result = orderSrevice.orderData();
		return Response.ok(result);
	}
	

	@ApiOperation(value="修改订单状态")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderId",value="订单id",required=true,defaultValue="1"),
		@ApiImplicitParam(name="status",value="订单当前状态",required=true,defaultValue="待接单"),
	})
	@PutMapping("/updateStatus")
	public Response<String> updateStatus(Long orderId,String status){
		orderSrevice.updateOrderStatus(orderId,status);
		return Response.ok("success");
	}

	@ApiOperation(value="添加订单取消原因")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderId",value="订单id",defaultValue="1"),
		@ApiImplicitParam(name="isCanceled",value="订单是否取消(顾客\\商家)",defaultValue="未取消"),
		@ApiImplicitParam(name="reason",value="订单取消原因",defaultValue="无")
	})
	@PutMapping("/updateCancelReason")
	public Response<String> updateCancelReason(Long orderId,String isCanceled,String reason){
		String result=orderSrevice.updateOrderCancelReason(orderId, isCanceled, reason);
		return Response.ok(result);
	}

	@ApiOperation(value="顾客催单或商家收到催单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderId",value="订单id",required=true,defaultValue="1"),
		@ApiImplicitParam(name="reminder",value="催单信息/确认催单信息",required=true,defaultValue="顾客")
	})
	@PutMapping("/setOrderReminder")
	public Response<String> setOrderReminder(Long orderId, String reminder) {
		String result = orderSrevice.updateOrderReminder(orderId, reminder);
		return Response.ok(result);
	}

	@ApiOperation(value="订单添加骑手信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name="orderId",value="订单id",required=true,defaultValue="1"),
		@ApiImplicitParam(name="deliverymanId",value="骑手id",required=true,defaultValue="1"),
	})
	@PutMapping("/updateDeliveryman")
	public Response<String> updateDeliveryman(Long orderId, Long deliverymanId) {
		orderSrevice.updateOrderDeliveryman(orderId, deliverymanId);
		return Response.ok("success");
	}

	@ApiOperation(value="顾客删除订单  实际为修改订单删除标志")
	@ApiImplicitParam(name="orderId",value="订单id",required=true)
	@PutMapping("/updateDeleted")
	public Response<String> updateDeleted(Long orderId){
		String string=orderSrevice.updateOrderDeleted(orderId);
		return Response.ok(string);
	}
	
	
	@ApiOperation(value="根据订单id查找订单项、商品信息")
	@ApiImplicitParam(name="orderId",value="订单id",required=true,defaultValue="1")
	@GetMapping("/getOrderAndGoods")
	public Response<List<OrderDetail>> getOrderAndGoods(Long orderId){
		List<OrderDetail> orderDetails=orderSrevice.getOrderDetial(orderId);
		return Response.ok(orderDetails);
	}

}
