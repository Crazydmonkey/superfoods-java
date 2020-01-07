package com.briup.smart.mapper;

import com.briup.smart.bean.OrderItem;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderItemMapper3 {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    List<OrderItem> selectAll();
    
    
}