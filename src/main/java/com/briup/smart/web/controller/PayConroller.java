package com.briup.smart.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.briup.smart.common.utils.AliPayUtil;
import com.briup.smart.service.PayService;
import com.briup.smart.service.UserOrderService1;
import com.briup.smart.service.UserOrderServiceImpl2;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
//import springfox.documentation.annotations.ApiIgnore;

@Api(tags="支付模块")
@Controller
public class PayConroller {

	@Autowired
	private PayService payService;
	
	@Autowired
	private UserOrderServiceImpl2 userOrderService;
	
	@Autowired
	private UserOrderService1 userOrderService1;
	
	@ApiOperation(value = "为指定订单执行付款操作:此接口不能通过swagger看到访问支付页面的效果，需要根据此处的参数信息在地址栏中发送请求",
			notes="已付款订单会提示已付款")
	@ApiImplicitParam(name="orderId", value="订单编号", required=true)
	@GetMapping("/pay")
	public void pay(HttpServletResponse response, Long orderId) {
		AlipayTradePayModel model = payService.createPayModel(orderId);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		// 设置参数
		alipayRequest.setBizModel(model);
		// 设置回调地址
		alipayRequest.setReturnUrl(AliPayUtil.return_url);
		//alipayRequest.setNotifyUrl(AliPayUtil.notify_url);

		AlipayClient alipayClient = AliPayUtil.getAlipayClient();
		try {
			String result = alipayClient.pageExecute(alipayRequest).getBody();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("访问支付页面出错");
		}
	}
	
/// 接收支付宝同步通知
//	 @ApiIgnore
//	 @GetMapping("/receiveNotify")
//	 public void receiveNotify(@RequestParam("out_trade_no")Long orderId) {
//		System.out.println("接收通知");
//		System.out.println(orderId);
//		String status = "待付款";
//		userOrderService.updateOrderStatus(orderId, status);
//	}
	
	// 接收支付完成
	@ApiOperation(value="将指定订单的状态改为\"待接单\"")
	@ApiImplicitParam(name="orderId", value="订单编号", required=true)
	@GetMapping("/receiveNotify")
	@ResponseBody
	public Response<String> receiveNotify(Long orderId) {
		System.out.println("接收通知");
		System.out.println(orderId);
		String status = "待付款";
		userOrderService.updateOrderStatus(orderId, status);
		return Response.ok("状态改变成功");
	}
	
	@ApiOperation(value = "为指定订单执行退款操作")
	@ApiImplicitParam(name="orderId", value="订单编号", required=true)
	@GetMapping("/refund/{orderId}")
	@ResponseBody
	public Response<String> refund(@PathVariable String orderId) {
		Long orderIdLong = Long.parseLong(orderId);
		String amount = userOrderService1.getAmountById(orderIdLong).toString();
		
		
		AlipayTradeRefundModel model = new AlipayTradeRefundModel();
		model.setOutTradeNo(orderId);
		//金额不能大于订单金额,单位为元，支持两位小数
		model.setRefundAmount(amount);
		
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		request.setBizModel(model);
		AlipayClient alipayClient = AliPayUtil.getAlipayClient();
		AlipayTradeRefundResponse response;
		try {
			response = alipayClient.execute(request);
			if(response.isSuccess()){
				return new Response<String>(200, "ok", "退款成功");
			} else {
				return new Response<String>(300, "error", "退款失败");
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
			return new Response<String>(400, "error","退款失败");
		}
	}
}
