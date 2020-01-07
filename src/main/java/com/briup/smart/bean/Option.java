package com.briup.smart.bean;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="查找订单选项")
public class Option {
	@ApiModelProperty(value="订单id",example="1")
	private Long orderId;
	@ApiModelProperty(value="配送员id",example="1")
	private Long deliverymanId;
	@ApiModelProperty(value="用户id",example="1")
	private Long customerId;
	@ApiModelProperty(value="状态",allowableValues="待接单,待发货,待收货,已完成,已取消")
	private String status;
	@ApiModelProperty(value="开始检索时间")
	private String beforeDate;
	@ApiModelProperty(value="检索终止时间")
	private String afterDate;
	@ApiModelProperty(value="取消/催单状态",allowableValues="未取消,催单,商家,顾客")
	private String isCanceled;
	@ApiModelProperty(value="用户是否取消订单(0未删除)",allowableValues="0,1")
	private String deleted;
	@ApiModelProperty(value="用于检索申请退单订单，值为‘未完成’时不检索已取消订单",allowableValues="未完成")
	private String finish;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getDeliverymanId() {
		return deliverymanId;
	}
	public void setDeliverymanId(Long deliverymanId) {
		this.deliverymanId = deliverymanId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBeforeDate() {
		return beforeDate;
	}
	public void setBeforeDate(String beforeDate) {
		this.beforeDate = beforeDate;
	}
	public String getAfterDate() {
		return afterDate;
	}
	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}
	
	public String getIsCanceled() {
		return isCanceled;
	}
	public void setIsCanceled(String isCanceled) {
		this.isCanceled = isCanceled;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	@Override
	public String toString() {
		return "Option [orderId=" + orderId + ", deliverymanId=" + deliverymanId + ", customerId=" + customerId
				+ ", status=" + status + ", beforeDate=" + beforeDate + ", afterDate=" + afterDate + ", isCanceled="
				+ isCanceled + ", deleted=" + deleted + ", finish=" + finish + "]";
	}
	
	
	
	
	
	
	
	

}
