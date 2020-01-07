package com.briup.smart.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserOrder {
    private Long id;

    private Date orderTime;

    private Double amount;

    private String status;

    private Date deliveryTime;

    private String methodsOfPayment;

    private String notes;

    private String isCanceled;
    //取消原因
    private String cancelReason;

    private Long deliverymanId;

    private Long customerId;
    
    private Long deleted;
    //list 集合 保存订单项
    List<OrderItem> list=new LinkedList<OrderItem>();
    
    
	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getMethodsOfPayment() {
		return methodsOfPayment;
	}

	public void setMethodsOfPayment(String methodsOfPayment) {
		this.methodsOfPayment = methodsOfPayment;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(String isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Long getDeliverymanId() {
		return deliverymanId;
	}

	public void setDeliverymanId(Long deliverymanId) {
		this.deliverymanId = deliverymanId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
	public Long getDeleted() {
		return deleted;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", orderTime=" + orderTime + ", amount=" + amount + ", status=" + status
				+ ", deliveryTime=" + deliveryTime + ", methodsOfPayment=" + methodsOfPayment + ", notes=" + notes
				+ ", isCanceled=" + isCanceled + ", cancelReason=" + cancelReason + ", deliverymanId=" + deliverymanId
				+ ", customerId=" + customerId + ", deleted=" + deleted + ", list=" + list + "]";
	}

	

	

    
}