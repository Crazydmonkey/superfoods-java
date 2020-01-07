package com.briup.smart.bean;

import java.awt.List;

public class OrderDetail {
	private Goods goods;
	private OrderItem orderItem;
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "OrderDetail [goods=" + goods + ", orderItem=" + orderItem + "]";
	}
	
	

}
