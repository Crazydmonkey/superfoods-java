package com.briup.smart.mapper;

import com.briup.smart.bean.OrderItem;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderItemMapper2 {
	int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);
    
    //获得订单全部订单项
    List<OrderItem> selectAll(Long orderId);

    
    //添加已有的商品到购物车
    int updateByPrimaryKey(OrderItem item);
    
    
	//添加商品到购物车
    int insertShopingCar(OrderItem orderItem);
    //查看购物车中是否有该商品
    OrderItem selectOrderItem(@Param("goodsId") Long goodsId,
    		@Param("customerId") Long customerId);
    //清空购物车
    int deleteAll(Long customerId);
    //删除购物车商品
    int deleteOrdetItem(@Param("goodsId") Long goodsId,
    		@Param("customerId") Long customerId);
    //查询购物车全部订单项
    List<OrderItem> selectAllShoppingCar(Long customerId);
    
    
    
    
    
    
    
    
}