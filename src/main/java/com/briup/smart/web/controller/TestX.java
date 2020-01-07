package com.briup.smart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.smart.service.GoodsService;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class TestX {
	
	
	

	
	@RequestMapping("/ttt")
	public String ttt(){
		System.out.println("访问成功");
		return "index";
	}
	
	
	
	@RequestMapping("/businessLogin.do")
	public String businessLogin(){
		System.out.println("商家端登录成功");
		return "businessLogin";
	}
	
	@RequestMapping("/insertGoods.do")
	public String insertGoods(){
		System.out.println("访问成功");
		return "insertGoods";
	}
	
	@RequestMapping("/goodsGood.do")
	public String goodsGood(){
		System.out.println("访问成功");
		return "goodsGood";
	}
	
	@RequestMapping("/goodsShopping.do")
	public String goodsShopping(){
		System.out.println("访问成功");
		return "goodsShopping";
	}
	
	

	
	

}
