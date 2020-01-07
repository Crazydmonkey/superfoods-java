package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.OrderItem;
import com.briup.smart.service.ShoppingCarService;
import com.briup.smart.web.vm.OrderItemVM;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="购物车模块")
@RestController
public class ShoppingCarController {
	@Autowired
	private ShoppingCarService shoppingCarService;
	
	@ApiOperation(value="添加商品到购物车中、增加指定商品的数量",notes="添加商品到购物车中")
	@PostMapping("/setShoppingCar")
	@ApiImplicitParams({
		@ApiImplicitParam(name="goodsId",value="商品id",required=true),
		@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	})
	public Response<String> setShoppingCar(Long goodsId,Long customerId){
		shoppingCarService.setOrderItem(goodsId, customerId);
		return Response.ok("操作成功");
	}
	
	@ApiOperation(value="设置指定商品的数量")
	@PostMapping("/updateShoppingCar")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="订单项id",required=true),
		@ApiImplicitParam(name="num",value="商品数量",required=true)
	})
	public Response<String> updateShoppingCar(Long id,int num){
		shoppingCarService.updateOrderItem(id, num);
		return Response.ok("商品的数量设置成功");
	}
	
	@ApiOperation(value="减少指定商品的数量")
	@PostMapping("/reductShoppingCar")
	@ApiImplicitParam(name="id",value="订单项id",required=true)
	public Response<String> reductShoppingCar(Long id){
		shoppingCarService.reductOrderItem(id);
		return Response.ok("商品数量已减少");
	}
	
	@ApiOperation(value="从购物车中移除指定商品")
	@DeleteMapping("/removeOne")
	@ApiImplicitParam(name="id",value="订单项id",required=true)
	public Response<String> removeOne(Long id){
		shoppingCarService.deleteOrderItem(id);
		return Response.ok("此商品已移除");
	}
	
	@ApiOperation(value="从购物车中移除全部商品（清空购物车）")
	@DeleteMapping("/removeAll")
	@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	public Response<String> removeAll(Long customerId){
		shoppingCarService.deleteAllOrderItem(customerId);
		return Response.ok("全部商品已移除");
	}	
	
	@ApiOperation(value="获取购物车中全部订单项")
	@GetMapping("/getAll")
	@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	public Response<List<OrderItem>> getAll(Long customerId){
		List<OrderItem> orderItems=shoppingCarService.getAllOrderItem(customerId);
		return Response.ok(orderItems);
	}
	
	@ApiOperation(value="获取购物车中全部订单项及商品信息")
	@GetMapping("/orderItems")
	@ApiImplicitParam(name="customerId",value="顾客id",required=true)
	public Response<List<OrderItemVM>> getOrderItemsWithGoods(Long customerId) {
		List<OrderItemVM> orderItems = shoppingCarService.getOrderItemsWithGoods(customerId);
		return Response.ok(orderItems);
	}

}