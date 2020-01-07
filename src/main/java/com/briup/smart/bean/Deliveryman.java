package com.briup.smart.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="骑手信息模型")
public class Deliveryman {
	@ApiModelProperty(value="骑手编号")
    private Long id;
	@ApiModelProperty(value="骑手姓名")
    private String name;
	@ApiModelProperty(value="骑手电话")
    private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Deliveryman [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

    
}