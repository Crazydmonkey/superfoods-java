package com.briup.smart.mapper;

import com.briup.smart.bean.Option;
import com.briup.smart.bean.UserOrder;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserOrderMapper2 {
	 int deleteByPrimaryKey(Long id);

	 int insert(UserOrder record);
	 
	 UserOrder selectByPrimaryKey(Long id);
	 //按条件检索
	 List<UserOrder> selectOrder(Option option);
	 //按状态检索
	 List<UserOrder> selectOrderStatus(String status);
	 //检索申请退单
	 List<UserOrder> selectChargeback(Option option);
	 
	 int updateByPrimaryKey(UserOrder order);
	 //修改订单状态
	 int updateByStatus(@Param("orderId") Long orderId,@Param("status")String status);
	 //添加骑手信息
	 int updateByDeliveryman(@Param("orderId") Long orderId,@Param("deliverymanId")Long deliverymanId);


}








