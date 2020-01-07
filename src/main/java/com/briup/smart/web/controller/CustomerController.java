package com.briup.smart.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.Customer;
import com.briup.smart.service.CustomerService;
import com.briup.smart.web.vm.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "顾客个人信息模块")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	@ApiOperation(value = "注册或修改个人信息，传入id为修改，不传id为注册")
	@PostMapping("/customer")
	public Response<String> update(Customer customer) {
		service.update(customer);
		return Response.ok("操作成功");
	}
	
	@ApiOperation(value = "上传图片")
	@PostMapping("/customer/uploadPicture")
	public Response<String> uploadPicture(MultipartFile file) {
		String name = service.uploadPicture(file);
		return new Response<>(200, "ok", "上传成功", name);
	}
	
	@ApiOperation(value = "更换图片")
	@PostMapping("/customer/updatePicture")
	public Response<String> uploadPicture(MultipartFile file, String originalName) {
		String name = service.updatePicture(file, originalName);
		return new Response<>(200, "ok", "更换成功", name);
	}
	

	@ApiOperation(value = "根据编号获取个人信息")
	@ApiImplicitParam(name = "id", value = "编号", paramType = "path", required = true)
	@GetMapping("/customer/{id}")
	public Response<Customer> getCustomerById(@PathVariable("id") Long id) {
		return Response.ok(service.findCustomerById(id));
	}

	@ApiOperation(value = "登录")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "account", value = "账号", paramType = "path", required = true),
		@ApiImplicitParam(name = "password", value = "密码", paramType = "path", required = true) })
	@GetMapping("/customer/{account}/{password}")
	public Response<String> login(@PathVariable String account, @PathVariable String password) {
		service.login(account, password);
		return Response.ok("登录成功");
	}

}
