package com.briup.smart.bean;

import java.math.BigDecimal;

public class OrderItem {
	 private Long id;

	 private Long goodsId;
	 
	 private Long orderId;
	 
	 private Integer quantity;
	 
	 private Double amount;
	 
	 private Long customerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", goodsId=" + goodsId + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", amount=" + amount + ", customerId=" + customerId + "]";
	}
	 
	

    
}