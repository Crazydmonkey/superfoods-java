package com.briup.smart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.OrderItem;
import com.briup.smart.bean.ShowIncoming;
import com.briup.smart.service.IncomingService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "收入展示模块")
@RestController
public class IncomingController {
	@Autowired
	private IncomingService inService;
	@ApiOperation(value = "获取当天日期、总收入和订单数")
	@GetMapping("/incoming/currentIncoming")
	public Response<ShowIncoming> getCurrentIncoming() {
		return Response.ok(inService.showCurrentIncoming());
	}
//@ApiOperation(value="获取所有的订单项",notes="获取所有的订单项")
//@GetMapping("/Incoming/allOrderItem")
//public Response<List<OrderItem>> getAllOrderItem(){
//    return Response.ok(inService.selectAllOrderItem());    
//}
	@ApiOperation(value = "以天为单位获取日期、总收入和订单数")
	@GetMapping("/incoming/dailyIncoming")
	public Response<List<ShowIncoming>> getDailyIncoming() {
		return Response.ok(inService.getDailyIncoming());
	}

//@ApiOperation(value="获取周总收入、订单数以及日期",notes="获取周总收入、订单数以及日期")
//@GetMapping("/Incoming/weeklyIncoming")
//public Response<List<ShowIncoming>> getWeeklyIncoming(){
//	return Response.ok(inService.getWeeklyIncoming());
//}
	@ApiOperation(value = "以月为单位获取月份、总收入和订单数")
	@GetMapping("/incoming/monthlyIncoming")
	public Response<List<ShowIncoming>> getMonthlyIncoming() {
		return Response.ok(inService.getMonthlyIncoming());
	}

//@ApiOperation(value="获取季度总收入、订单数以及日期",notes="获取季度总收入、订单数以及日期")
//@GetMapping("/Incoming/quarterlyIncoming")
//public Response<Double> getQuarterlyIncoming(){
//	return Response.ok(inService.getQuarterlyIncoming());
//}
	@ApiOperation(value = "以年为单位获取年份、总收入和订单数")
	@GetMapping("/incoming/yearlyIncoming")
	public Response<List<ShowIncoming>> getYearlyIncoming() {
		return Response.ok(inService.getYearlyIncoming());
	}

	@ApiOperation(value = "以天为单位获取本月的日期、总收入和订单数")
	@GetMapping("/incoming/dailyIncomingDuringMonth")
	public Response<List<ShowIncoming>> getDailyIncomingDuringMonth() {
		return Response.ok(inService.getDailyIncomingByMonth());
	}

	@ApiOperation(value = "以月为单位获取今年的月份、总收入和订单数")
	@GetMapping("/incoming/monthlyIncomingDuringYear")
	public Response<List<ShowIncoming>> getMonthlyIncomingDuringYear() {
		return Response.ok(inService.getMonthlyIncomingByYear());
	}
}
