package com.briup.smart.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeiYang {

	@RequestMapping("/fy/{pageName}")
	public String fy(@PathVariable String pageName) {
		System.out.println(pageName);
		return pageName;
	}
}
