package com.briup.smart.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.Deliveryman;
import com.briup.smart.common.utils.exception.DataValidFailedException;
import com.briup.smart.mapper.DeliverymanMapper;
import com.briup.smart.web.vm.FieldError;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class DeliverymanService {
	@Autowired
	private DeliverymanMapper dmMapper;

	@Transactional
	// 添加骑手
	public void addDeliveryman(Deliveryman dm) {
		Collection<FieldError> fs = new HashSet<>();
		if ("".equals(dm.getName()) || dm.getName() == null) {
			fs.add(new FieldError("name", "骑手名字不能为空!"));
		}
		//
		if ("".equals(dm.getPhoneNumber()) || dm.getPhoneNumber() == null) {
			fs.add(new FieldError("phoneNumber", "骑手电话不能为空!"));
		}else {
			//进行电话号码校验
			if(!this.isMobile(dm.getPhoneNumber())) {
				fs.add(new FieldError("phoneNumber", "骑手电话格式不正确!"));
			}
		}
		if (!fs.isEmpty()) {
			throw new DataValidFailedException(fs);
		}
		if (dm.getId() != null) {
			dmMapper.updateByPrimaryKey(dm);
		} else {
			dmMapper.insert(dm);
		}
	}

	/*
	 * 电话号码匹配 java正则表达式通过java.util.regex包下的Pattern与Matcher来实现
	 * Pattern类用于创建一个正则表达式,也可以说创建一个匹配模式,它的构造方法是私有的,不可以直接创建,但可以通过
	 * Pattern.complie(String regex) 简单工厂方法创建一个正则表达式。
	 * Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
	 */
	private boolean isMobile(String str) {
		boolean flag=false;
		Pattern p = null;
		Matcher m = null;
		// 以规定的三位数字匹配开头,后面以八个数字作为结尾
		p = Pattern.compile("^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$");
		System.out.println(str.length());
		if(str.length()!=11) {
			return false;
		}else {
			m=p.matcher(str);//进行匹配
			flag=m.matches();//返回是否匹配指定的字符串，如果匹配则为true,否则为false。
		}
		return flag;
		
	}

	// 删除骑手
	public int deleteDeliveryman(Long id) {
        return dmMapper.deleteByPrimaryKey(id);
	}

	// 查看骑手详细信息
	public Deliveryman selectDeliverymanById(Long id) {
		Deliveryman dm=dmMapper.selectByPrimaryKey(id);
        return dm;
	}
	// 根据输入条件查找骑手信息
	public List<Deliveryman> selectDeliveryman(Deliveryman dm){
		List<Deliveryman>list=dmMapper.selectDeliveryman(dm);
		System.out.println("------------------------");
		System.out.println(list);
		return list;
	}
	// 分页 根据输入条件查找骑手信息
	public PageInfo<Deliveryman> selectDeliveryman(int pageNum,int pageSize,Deliveryman dm){
		PageHelper.startPage(pageNum, pageSize, true);
		List<Deliveryman>list=dmMapper.selectDeliveryman(dm);
		if(list==null||list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}
	// 查看骑手列表
	public List<Deliveryman> selectAllDeliveryman(){
		List<Deliveryman>list=dmMapper.selectAll();
		return list;
	}

	// 分页 查看骑手列表
	public PageInfo<Deliveryman> selectAllDeliveryman(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize, true);
		List<Deliveryman>list=dmMapper.selectAll();
		if(list==null||list.isEmpty()) {
			list = new ArrayList<>();
		}
		return new PageInfo<>(list);
	}

}
