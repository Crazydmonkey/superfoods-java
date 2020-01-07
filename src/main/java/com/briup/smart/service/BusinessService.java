package com.briup.smart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.briup.smart.bean.Business;
import com.briup.smart.bean.Goods;
import com.briup.smart.common.utils.Upload;
import com.briup.smart.common.utils.exception.BusinessException;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.BusinessMapper;
import com.briup.smart.web.vm.FieldError;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BusinessService {
	@Autowired
	private BusinessMapper businessMapper;

	// 账号不能修改
	@Transactional
	public void modify(Business business, MultipartFile file) {
		Collection<FieldError> fs = new HashSet<>();
		if ("".equals(business.getAccount()) || business.getAccount() == null) {
			fs.add(new FieldError("account", "账号不能为空"));
		}
		if ("".equals(business.getPassword()) || business.getPassword() == null) {
			fs.add(new FieldError("password", "密码不能为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}

		if (business.getId() != null) {
			// 修改
			Business businessFromDB = businessMapper.selectByPrimaryKey(business.getId());
			System.out.println("商家信息:" + businessFromDB);

			if (!businessFromDB.getAccount().equals(business.getAccount())) {
				Business business1 = businessMapper.selectByAccount(business.getAccount());
				if (business1 != null) {
					throw new BusinessException("账号已存在");
				}
			}

			Upload upload = new Upload();
			String result = upload.deletePicture(businessFromDB.getHeadPortrait());
			if (result.equals("成功删除图片")) {
				String name = upload.uploadPicture(file);
				business.setHeadPortrait(name);
				businessMapper.updateByPrimaryKey(business);
			} else {
				throw new RuntimeException("未找到原始头像");
			}
		} else {
			// 新增
			Upload upload = new Upload();

			Business businessFromDB = businessMapper.selectByAccount(business.getAccount());
			System.out.println("商家信息:" + businessFromDB);
			if (businessFromDB != null) {
				throw new BusinessException("账号已存在");
			}
			String name = upload.uploadPicture(file);
			business.setHeadPortrait(name);
			businessMapper.insert(business);
		}
	}

	public void register(Business business, MultipartFile file) {
		Collection<FieldError> fs = new HashSet<>();
		if ("".equals(business.getAccount()) || business.getAccount() == null) {
			fs.add(new FieldError("account", "账号不能为空"));
		}
		if ("".equals(business.getPassword()) || business.getPassword() == null) {
			fs.add(new FieldError("password", "密码不能为空"));
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		Upload upload = new Upload();

		Business businessFromDB = businessMapper.selectByAccount(business.getAccount());
		System.out.println("商家信息:" + businessFromDB);
		if (businessFromDB != null) {
			throw new BusinessException("账号已存在");
		}
		String name = upload.uploadPicture(file);
		business.setHeadPortrait(name);
		businessMapper.insert(business);
	}

	public Business login(String account, String password) {
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
		Business business = businessMapper.selectByAccount(account);
		if (business == null) {
			throw new BusinessException("账号不存在");
		}
//		System.out.println("数据库值：" + business.getPassword());
//		System.out.println("输入值：" + password);
		if (!business.getPassword().equals(password)) {
			throw new BusinessException("密码错误");
		}
		return business;
	}

	public Business findBusinessById(Long id) {
		Business business = businessMapper.selectByPrimaryKey(id);
		if (business != null) {
			String passwordReplace = passwordHandler(business.getPassword());
			business.setPassword(passwordReplace);
		}
		return business;
	}

	public List<Business> getAllBusiness() {
		System.out.println("获得全部员工信息");
		List<Business> businessList = businessMapper.selectAll();

		// 老板账号
		// String boss="boss1234";
		for (Business business : businessList) {
			/// 排除老板账号
//			if (business.getAccount().equals(boss)) {
//				System.out.println("排除老板账号");
//				int index=businessList.indexOf(business);
//				businessList.remove(index);
//				break;
//			}

			// 密码使用*代替
			String passwordReplace = passwordHandler(business.getPassword());
			business.setPassword(passwordReplace);
		}
		return businessList;
	}
	
	public PageInfo<Business> getAllBusiness(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize, true);
		List<Business> list=businessMapper.selectAll();
		for (Business business : list) {
			String passwordReplace = passwordHandler(business.getPassword());
			business.setPassword(passwordReplace);
		}
		if (list == null || list.isEmpty()) {
			list = new ArrayList<>();
		}
		System.out.println("-----------------------------------");
		return new PageInfo<>(list);
	}

	private String passwordHandler(String password) {
		int length = password.length();
		String passwordReplace = "";
		for (int i = 0; i < length; i++) {
			passwordReplace += "*";
		}
		return passwordReplace;
	}

	public void delete(Long id) {
		businessMapper.deleteByPrimaryKey(id);
	}

}
