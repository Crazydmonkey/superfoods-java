package com.briup.smart.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.smart.bean.Business;
import com.briup.smart.bean.Customer;
import com.briup.smart.service.BusinessService;
import com.briup.smart.service.CustomerService;
import com.briup.smart.service.VerifyServiceImpl;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户登录检验")
@RestController
public class SecurityController {
	
	@Autowired
	private VerifyServiceImpl verifyServiceImpl;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private CustomerService customerService;
    
    @ApiOperation(value ="验证Business账号、密码，返回token")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "account", value = "账号", required = true),
		@ApiImplicitParam(name = "password", value = "密码", required = true)
	})
	@PostMapping("/authentication/loginBusiness")
	public Response<Map<String, String>> loginBusiness(String account, String password) {
    	System.out.println("开始");
    	Business business=businessService.login(account, password);
		String token=verifyServiceImpl.verifyBusiness(account, password);
    	Map<String,String> map = new HashMap<>();
    	map.put("token", token);
		return Response.ok(map);
	}
    
    
    @ApiOperation(value ="通过token获取Business的基本信息")
    @ApiImplicitParam(name = "token", value = "令牌", required = true) 
    @PostMapping("/authentication/infoBusiness")
    public Response<Business> infoBusiness(String token) {
    	System.out.println("开始");
    	Business business=verifyServiceImpl.parseBusinessToken(token);
    	return Response.ok(business);
    }
    
    
    @ApiOperation(value ="退出登录")
    @PostMapping("/authentication/logout")
    public Response<String> logout() {
    	return Response.ok("退出成功");
    }
    
    
    @ApiOperation(value ="验证Customer账号、密码，返回token")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "account", value = "账号", required = true),
		@ApiImplicitParam(name = "password", value = "密码", required = true)
	})
	@PostMapping("/authentication/loginCustomer")
	public Response<Map<String, String>> loginCustomer(String account, String password) {
    	System.out.println("开始");
    	customerService.login(account, password);
		String token=verifyServiceImpl.verifyCustomer(account, password);
    	Map<String,String> map = new HashMap<>();
    	map.put("token", token);
		return Response.ok(map);
	}
    
    
    @ApiOperation(value ="通过token获取Customer的基本信息")
    @ApiImplicitParam(name = "token", value = "令牌", required = true) 
    @PostMapping("/authentication/infoCustomer")
    public Response<Customer> infoCustomer(String token) {
    	System.out.println("开始");
    	Customer customer=verifyServiceImpl.parseCustomerToken(token);
    	return Response.ok(customer);
    }
    
    
    
    
    

}
