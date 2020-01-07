package com.briup.smart.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.Customer;
import com.briup.smart.common.utils.Upload;
import com.briup.smart.common.utils.exception.BusinessException;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.CustomerMapper;
import com.briup.smart.web.vm.FieldError;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Transactional
	public void update(Customer customer) {

		Collection<FieldError> fs = new HashSet<>();
		if ("".equals(customer.getAccount()) || customer.getAccount() == null) {
			fs.add(new FieldError("account", "用户名不能为空"));
		}
		if ("".equals(customer.getPassword()) || customer.getPassword() == null) {
			fs.add(new FieldError("password", "密码不能为空"));
		}
		if ("".equals(customer.getNickname()) || customer.getNickname() == null) {
			fs.add(new FieldError("nickname", "昵称不能为空"));
		}
		if ("".equals(customer.getAddress()) || customer.getAddress() == null) {
			fs.add(new FieldError("address", "地址不能为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		if (customer.getId() != null) {
			//修改
			Customer customerFromDB = customerMapper.selectByPrimaryKey(customer.getId());
			//修改账号
			if (!customerFromDB.getAccount().equals(customer.getAccount())) {
				Customer customer1 = customerMapper.selectByAccount(customer.getAccount());
				if (customer1 != null) {
					throw new BusinessException("账号已存在");
				}
			}
			
			customerMapper.updateByPrimaryKey(customer);
		} else {
			//新增
			//账号是否重复
			Customer a = customerMapper.selectByAccount(customer.getAccount());
			System.out.println("customer:" + a);
			if (a != null) {
				throw new BusinessException("账号已存在");
			}
			
			customerMapper.insert(customer);
		}
	}
	
	public String uploadPicture(MultipartFile file) {
		Upload upload = new Upload();
		String name = upload.uploadPicture(file);
		return name;
	}
	
	public String updatePicture(MultipartFile file, String originalName) {
		Upload upload = new Upload();
		String result = upload.deletePicture(originalName);
		if(result.equals("未找到图片")) {
			throw new RuntimeException("未找到原始图片");
		}
		String name = upload.uploadPicture(file);
		return name;
	}

	public Customer findCustomerById(Long id) {
		Customer customer = customerMapper.selectByPrimaryKey(id);
		return customer;
	}

	public void login(String account, String password) {
		Collection<FieldError> fs = new HashSet<>();
		if ("".equals(account) || account == null) {
			fs.add(new FieldError("account", "用户名不能为空"));
		}
		if ("".equals(password) || password == null) {
			fs.add(new FieldError("password", "密码不能为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		Customer customer = customerMapper.selectByAccount(account);
		if (customer == null) {
			throw new BusinessException("账号不存在");
		}
		if (!customer.getPassword().equals(password)) {
			throw new BusinessException("密码错误");
		}
	}

}
