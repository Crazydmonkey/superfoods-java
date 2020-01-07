package com.briup.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.smart.bean.UserOrder;

@Mapper
public interface UserOrderMapper1 {

	int insert(UserOrder record);
	
    List<UserOrder> selectUndeleted(Long userId);
	
    List<UserOrder> selectByCustomerIdAndStatus(Long customerId, String status);
}
