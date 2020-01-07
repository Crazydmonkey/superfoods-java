package com.briup.smart.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "顾客信息")
public class Customer {
	@ApiModelProperty(value = "编号")
	private Long id;
	@ApiModelProperty(value = "账号", required = true)
	private String account;
	@ApiModelProperty(value = "密码", required = true)
	private String password;
	@ApiModelProperty(value = "头像", required = true)
	private String headPortrait;
	@ApiModelProperty(value = "昵称", required = true)
	private String nickname;
	@ApiModelProperty(value = "地址", required = true)
	private String address;
	@ApiModelProperty(value = "真实姓名")
	private String realName;
	@ApiModelProperty(value = "性别")
	private String gender;
	@ApiModelProperty(value = "电话号码")
	private String phoneNumber;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", account=" + account + ", password=" + password + ", headPortrait="
				+ headPortrait + ", nickname=" + nickname + ", address=" + address + ", realName=" + realName
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + "]";
	}

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}