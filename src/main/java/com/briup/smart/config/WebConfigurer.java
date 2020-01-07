package com.briup.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.briup.smart.config.interceptor.LoginInterceptor;


@Configuration
public class WebConfigurer implements WebMvcConfigurer{
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns("/**") 表示拦截所有的请求，
	    // excludePathPatterns("") 不需要拦截的
//		registry.addInterceptor(loginInterceptor).addPathPatterns("/getOneOrder").excludePathPatterns("/business/{account}/{password}",
//				"/customer/{account}/{password}","/customer");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	//处理静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("file:F:/bb/");
	}

}




