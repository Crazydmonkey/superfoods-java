package com.briup.smart.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.Business;
import com.briup.smart.bean.Goods;
import com.briup.smart.service.BusinessService;
import com.briup.smart.web.vm.Response;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="商家个人信息模块")
@RestController
public class BusinessController {
	@Autowired
	private  BusinessService service;
	
	@ApiOperation(value="登录")
	@ApiImplicitParams({ 
		    @ApiImplicitParam(name = "password", value = "密码", paramType = "path", required = true),
			@ApiImplicitParam(name = "account", value = "账号", paramType = "path", required = true) })
	@GetMapping("/business/{account}/{password}")
	public Response<String> login(@PathVariable String account,@PathVariable String password,
			HttpServletRequest request,HttpServletResponse response){
		Business business = service.login(account, password);

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("business", business);
		System.out.println("session:business  " + session + ":" + business);
		return Response.ok("登录成功");
	}
	
	@ApiOperation(value="根据编号获取商家信息")
	@ApiImplicitParam(name = "id",value = "编号" , paramType="path",required = true)
	@GetMapping("/business/{id}")
	public Response<Business> getBusinessById(@PathVariable("id")Long id){
		return Response.ok(service.findBusinessById(id));
	}
	
	
	@ApiOperation(value="新增或修改信息，传入id为修改，不传id为新增")
	//@ApiImplicitParam(name = "file",value = "头像")
	@PutMapping("/business")
	public Response<String> modify(Business business, MultipartFile file){
		service.modify(business,file);
		return Response.ok("操作成功");
	}
	
//	@ApiOperation(value="注册")
//	//@ApiImplicitParam(name = "file",value = "头像")
//	@PostMapping("/business")
//	public Response<String> register(Business business, MultipartFile file){
//		service.register(business,file);
//		return Response.ok("注册成功");
//	}
	
	
	@ApiOperation(value = "获得全部员工信息")
	@GetMapping("/getAllBusiness")
	public Response<List<Business>> getAllBusiness() {
		List<Business> list = service.getAllBusiness();
		return Response.ok(list);
	}
	
	@ApiOperation(value = "获得全部员工信息 分页")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="pageNum",value="当前页码",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页显示数据个数",defaultValue="3"),
    })
	@GetMapping("/getAllBusinessPageInfo")
	public Response<PageInfo<Business>> getAllBusiness(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
		return Response.ok(service.getAllBusiness(pageNum, pageSize));
	}
	
	@ApiOperation(value="删除指定员工的信息")
	@DeleteMapping("/business/{id}")
	public Response<String> delete(@PathVariable Long id) {
		service.delete(id);
		return Response.ok("删除成功");
	}
}
