package com.briup.smart.bean;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="收入展示")
public class ShowIncoming {
	@ApiModelProperty(value="日期")
     private String time;
	@ApiModelProperty(value="金额")
     private double amount;
	@ApiModelProperty(value="订单数量")
     private int num;

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ShowIncoming [time=" + time + ", amount=" + amount + ", num=" + num + "]";
	}
	
     
}
