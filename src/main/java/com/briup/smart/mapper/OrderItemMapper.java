package com.briup.smart.mapper;

import com.briup.smart.bean.OrderItem;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    List<OrderItem> selectAll();
    
    //添加已有的商品到购物车
    int updateByPrimaryKey(OrderItem record);
    
    
	//添加商品到购物车
    int insertShopingCar(OrderItem orderItem);
    //查看购物车中是否有该商品
    OrderItem selectOrderItem(@Param("goodsId") Long goodsId,
    		@Param("customerId") Long customerId);
    //清空购物车
    int deleteAll(Long customerId);
    
    
    
    
    
    
    
}