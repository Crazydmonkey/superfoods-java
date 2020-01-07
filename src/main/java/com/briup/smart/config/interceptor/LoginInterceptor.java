package com.briup.smart.config.interceptor;

import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.briup.smart.bean.Business;
import com.briup.smart.bean.Customer;
import com.briup.smart.web.vm.FieldError;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	Collection<FieldError> fs = new HashSet<>();
	//在请求处理之前调用,只有返回true才会执行请求
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获得session对象
		HttpSession session=request.getSession();
		Customer customer=(Customer) session.getAttribute("customer");
		Business business=(Business) session.getAttribute("business");
		System.out.println("customer:"+customer+",business:"+business);
		if (customer==null||business==null) {
			//没有登录
			fs.add(new FieldError("error","未登录，请登录后访问"));
			return false;
		}
		return true;
	}

}
