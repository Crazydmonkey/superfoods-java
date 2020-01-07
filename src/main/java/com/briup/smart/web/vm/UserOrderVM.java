package com.briup.smart.web.vm;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "保存订单传递参数模型")
public class UserOrderVM {

	@ApiModelProperty(value="订单总金额", required=true)
	private Double amount;

	@ApiModelProperty(value="支付方式", required=true, allowableValues="支付宝")
	private String methodsOfPayment;

	@ApiModelProperty(value="备注")
	private String notes;

	@ApiModelProperty(value="顾客编号", required=true)
	private Long customerId;
	
	@ApiModelProperty(value="需要保存的订单项编号", required=true)
	private List<Long> orderItemIds;
	
	@Override
	public String toString() {
		return "UserOrderVM [amount=" + amount + ", methodsOfPayment=" + methodsOfPayment + ", notes=" + notes
				+ ", customerId=" + customerId + "]";
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Long> getOrderItemIds() {
		return orderItemIds;
	}

	public void setOrderItemIds(List<Long> orderItemIds) {
		this.orderItemIds = orderItemIds;
	}

}
