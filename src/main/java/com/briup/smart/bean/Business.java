package com.briup.smart.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="商家端信息")
public class Business {
	@ApiModelProperty(value="编号")
    private Long id;
	@ApiModelProperty(value="账号")
    private String account;
	@ApiModelProperty(value="密码")
    private String password;
	@ApiModelProperty(value="头像",hidden = true)
	private String headPortrait;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	@Override
	public String toString() {
		return "Business [id=" + id + ", account=" + account + ", password=" + password + ", headPortrait="
				+ headPortrait + "]";
	}

	
    
}