package com.briup.smart.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Wuyp {
	@RequestMapping("/mine.do")
	public String mine(){
		System.out.println("访问成功");
		return "mine";
	}
	@RequestMapping("/setting.do")
	public String setting(){
		System.out.println("访问成功");
		return "setting";
	}
	@RequestMapping("/update.do")
	public String update(){
		System.out.println("访问成功");
		return "update";
	}
	@RequestMapping("/register.do")
	public String register(){
		System.out.println("访问成功");
		return "register";
	}
	@RequestMapping("/paySetting.do")
	public String paySetting(){
		System.out.println("访问成功");
		return "paySetting";
	}
	@RequestMapping("/safe.do")
	public String safe(){
		System.out.println("访问成功");
		return "safe";
	}
	@RequestMapping("/customerLogin.do")
	public String customerLogin(){
		System.out.println("访问成功");
		return "customerLogin";
	}
	

}
