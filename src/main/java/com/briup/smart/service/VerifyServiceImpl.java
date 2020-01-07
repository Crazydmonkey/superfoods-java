package com.briup.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.briup.smart.bean.Business;
import com.briup.smart.bean.Customer;
import com.briup.smart.common.utils.JwtTokenUtils;
import com.briup.smart.mapper.BusinessMapper;
import com.briup.smart.mapper.CustomerMapper;

@Service
public class VerifyServiceImpl{
	
	@Autowired
	private BusinessMapper businessMapper;
	@Autowired
	private CustomerMapper customerMapper;

	
	//验证Business账号、密码，返回token
	public String verifyBusiness(String account, String password){
		// 根据用户名去查找用户信息
		System.out.println("查找用户："+account);
		Business business=businessMapper.selectByAccount(account);
		System.out.println("查找用户结果："+business);
//		if(business == null) {
//            throw new UsernameNotFoundException(String.format("Not user Found with '%s'", account));
//        }
		String token=JwtTokenUtils.createJWT(business.getId(), business.getAccount());
		System.out.println("生成令牌为："+token);
        
		return token;
	}
	
	
	//通过token获取Business的基本信息
	public Business parseBusinessToken(String token){
		// 根据token得到用户id
		Long id=Long.parseLong(JwtTokenUtils.getUserId(token, JwtTokenUtils.base64Secret));
		System.out.println("根据token得到用户id为："+id);
		Business business=businessMapper.selectByPrimaryKey(id);
		System.out.println("查找用户结果："+business);
		return business;
	}
	
	
	//验证Customer账号、密码，返回token
	public String verifyCustomer(String account, String password){
		// 根据用户名去查找用户信息
		System.out.println("查找用户："+account);
		Customer customer=customerMapper.selectByAccount(account);
		System.out.println("查找用户结果："+customer);

		String token=JwtTokenUtils.createJWT(customer.getId(), customer.getAccount());
		System.out.println("生成令牌为："+token);
		
		return token;
	}
	
	
	//通过token获取Customer的基本信息
	public Customer parseCustomerToken(String token){
		// 根据token得到用户id
		Long id=Long.parseLong(JwtTokenUtils.getUserId(token, JwtTokenUtils.base64Secret));
		System.out.println("根据token得到用户id为："+id);
		Customer customer=customerMapper.selectByPrimaryKey(id);
		System.out.println("查找用户结果："+customer);
		return customer;
	}
	

}
