package com.briup.smart.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.smart.bean.OrderItem;
import com.briup.smart.bean.UserOrder;
import com.briup.smart.mapper.OrderItemMapper;
import com.briup.smart.mapper.OrderItemMapper2;
import com.briup.smart.mapper.UserOrderMapper;
import com.briup.smart.mapper.UserOrderMapper1;
import com.briup.smart.web.vm.OrderResponseVM;

@Service
public class UserOrderService1 {

	@Autowired
	private UserOrderMapper userOrderMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
	private OrderItemMapper2 orderItemMapper2;

	@Autowired
	private UserOrderMapper1 userOrderMapper1;

	// 获取未被顾客删除的订单的概要信息
	@Transactional
	public List<OrderResponseVM> getUserOrders(Long userId) {
		System.out.println("获取未被顾客删除的订单的概要信息-用户编号:" + userId);
		List<UserOrder> userOrders = userOrderMapper1.selectUndeleted(userId);

		List<OrderResponseVM> orders = new ArrayList<>();
		OrderResponseVM orderResp;
		for (UserOrder order : userOrders) {
			orderResp = this.convertUserOrderToOrderReponseVM(order);
			orders.add(orderResp);
		}
		return orders;
	}
	
	// 获取指定用户的指定状态订单的概要信息
	public List<OrderResponseVM> getUserOrdersByStatus(Long customerId, String status) {
//		System.out.println("用户编号:" + customerId);
//		System.out.println("订单状态:" + status);
		
		List<UserOrder> userOrders = userOrderMapper1.selectByCustomerIdAndStatus(customerId, status);

		List<OrderResponseVM> orders = new ArrayList<>();
		OrderResponseVM orderResp;
		for (UserOrder order : userOrders) {
			orderResp = convertUserOrderToOrderReponseVM(order);
			orders.add(orderResp);
		}
		
		return orders;
	}

	@Transactional
	public OrderResponseVM getUserOrderById(Long id) {
		UserOrder userOrder = new UserOrder();
		userOrder = userOrderMapper.selectByPrimaryKey(id);

		System.out.println(userOrder.getOrderTime());

		// 获取订单项
		List<OrderItem> orderItems = orderItemMapper2.selectAll(userOrder.getId());
		for (OrderItem orderItem : orderItems) {
			System.out.println("orderItem:" + orderItem);
		}
		userOrder.setList(orderItems);

		OrderResponseVM order = this.convertUserOrderToOrderReponseVM(userOrder);

		return order;
	}

	@Transactional
	public Long saveOrderAndOrderItems(UserOrder order, List<Long> orderItemIds) {
		Calendar currentTime = Calendar.getInstance();
		currentTime.add(Calendar.MINUTE, 30);
		Date deliveryTime = currentTime.getTime();

		order.setCancelReason("");
		order.setOrderTime(new Date());
		order.setDeliveryTime(deliveryTime);
		order.setIsCanceled("未取消");
		order.setStatus("待付款");
		order.setDeleted(0L);// 标识是否被删除，0表示未被删除

		userOrderMapper1.insert(order);

		for (Long id : orderItemIds) {
			OrderItem orderItem = orderItemMapper.selectByPrimaryKey(id);
			orderItem.setOrderId(order.getId());
			orderItemMapper.updateByPrimaryKey(orderItem);
		}

		return order.getId();
	}

	public Double getAmountById(Long id) {
		UserOrder order = userOrderMapper.selectByPrimaryKey(id);
		return order.getAmount();
	}

	private OrderResponseVM convertUserOrderToOrderReponseVM(UserOrder order) {
		OrderResponseVM orderResp = new OrderResponseVM();
		orderResp.setAmount(order.getAmount());
		orderResp.setCancelReason(order.getCancelReason());
		orderResp.setCustomerId(order.getCustomerId());
		orderResp.setDeleted(order.getDeleted());
		orderResp.setDeliverymanId(order.getDeliverymanId());
		orderResp.setId(order.getId());
		orderResp.setIsCanceled(order.getIsCanceled());
		orderResp.setList(order.getList());
		orderResp.setMethodsOfPayment(order.getMethodsOfPayment());
		orderResp.setNotes(order.getNotes());
		orderResp.setStatus(order.getStatus());

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String orderTime = dateFormat.format(order.getOrderTime());
		orderResp.setOrderTime(orderTime);
		String deliveryTime = dateFormat.format(order.getDeliveryTime());
		orderResp.setDeliveryTime(deliveryTime);

		return orderResp;
	}
}
