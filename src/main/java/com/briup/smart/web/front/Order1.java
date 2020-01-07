package com.briup.smart.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Order1 {

	@RequestMapping("/order1/{pageName}")
	public String cancelOrder(@PathVariable String pageName) {
		System.out.println(pageName);
		return pageName;
	}
}
