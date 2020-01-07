package com.briup.smart.web.vm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="数据校验失败信息展示模型")
public class FieldError {
	@ApiModelProperty(value="属性名")
	private String filedName;
	@ApiModelProperty(value="错误描述")
	private String message;
	public FieldError(String filedName, String message) {
		super();
		this.filedName = filedName;
		this.message = message;
	}
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
