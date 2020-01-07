package com.briup.smart.mapper;

import com.briup.smart.bean.OrderItem;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper1 {
	
    int insert(OrderItem orderItem);
}