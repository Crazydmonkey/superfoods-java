package com.briup.smart.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="用户信息模型")
public class SmartUser {
	@ApiModelProperty(value="用户编号")
	private Long id;
	@ApiModelProperty(value="用户名称")
	private String name;
	@ApiModelProperty(value="用户年龄")
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
