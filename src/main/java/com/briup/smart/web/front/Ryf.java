package com.briup.smart.web.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.smart.service.GoodsService;

@Controller
public class Ryf {
	
	
	
	@RequestMapping("/shoppingCar.do")
	public String ttt(){
		System.out.println("访问成功");
		return "shoppingCar";
	}
	//已取消订单
	@RequestMapping("/canceledOrder.do")
	public String canceledOrder(){
		System.out.println("访问成功");
		return "canceledOrder";
	}
	//已取消订单详情
	@RequestMapping("/canceledOrderDetails.do")
	public String canceledOrderDetails(){
		System.out.println("访问成功");
		return "canceledOrderDetails";
	}
	//已完成订单
	@RequestMapping("/finishedOrder.do")
	public String finishedOrder(){
		System.out.println("访问成功");
		return "finishedOrder";
	}
	
	@RequestMapping("/finishedOrderDetails.do")
	public String finishedOrderDetails(){
		System.out.println("访问成功");
		return "finishedOrderDetails";
	}
	
	//等待收货订单
	@RequestMapping("/toBeReceivedGoodsOrder.do")
	public String toBeReceivedGoodsOrder(){
		System.out.println("访问成功");
		return "toBeReceivedGoodsOrder";
	}

	@RequestMapping("/toBeReceivedGoodsOrderDetails.do")
	public String toBeReceivedGoodsOrderDetails(){
		System.out.println("访问成功");
		return "toBeReceivedGoodsOrderDetails";
	}
	//等待确认订单
	@RequestMapping("/toBeReceivedOrder.do")
	public String toBeReceivedOrder(){
		System.out.println("访问成功");
		return "toBeReceivedOrder";
	}
	
	@RequestMapping("/toBeReceivedOrderDetails.do")
	public String toBeReceivedOrderDetails(){
		System.out.println("访问成功");
		return "toBeReceivedOrderDetails";
	}
	//等待发货订单
	@RequestMapping("/toBeSendingOrder.do")
	public String toBeSendingOrder(){
		System.out.println("访问成功");
		return "toBeSendingOrder";
	}
	
	@RequestMapping("/toBeSendingOrderDetails.do")
	public String toBeSendingOrderDetails(){
		System.out.println("访问成功");
		return "toBeSendingOrderDetails";
	}
	//退单
	@RequestMapping("/cancellingOrder.do")
	public String cancellingOrder(){
		System.out.println("访问成功");
		return "cancellingOrder";
	}
	
	@RequestMapping("/cancellingOrderDetails.do")
	public String cancellingOrderDetails(){
		System.out.println("访问成功");
		return "cancellingOrderDetails";
	}
	//催单
	@RequestMapping("/hurryOrder.do")
	public String hurryOrder(){
		System.out.println("访问成功");
		return "hurryOrder";
	}
	
	@RequestMapping("/hurryOrderDetails.do")
	public String hurryOrderDetails(){
		System.out.println("访问成功");
		return "hurryOrderDetails";
	}
	
	



}
