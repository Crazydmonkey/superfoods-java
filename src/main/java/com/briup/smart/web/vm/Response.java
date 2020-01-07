package com.briup.smart.web.vm;

import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "接口通用响应模型")
public class Response<T> {
	@ApiModelProperty(value = "响应状态值")
	private Integer status = 200;
	@ApiModelProperty(value = "响应状态码")
	private String code = "ok";
	@ApiModelProperty(value = "响应描述信息")
	private String message = "操作成功！";
	@ApiModelProperty(value = "响应数据")
	private T data;
	@ApiModelProperty(value = "数据校验错误信息")
	private Collection<FieldError> errors;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Collection<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(Collection<FieldError> errors) {
		this.errors = errors;
	}

	public Response(T data) {
		this.data = data;
	}

	public Response(Integer status, String code, String message) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public Response(Integer status, String code, String message, T data) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Response() {
	}

	public static <T> Response<T> ok(T data) {
		return new Response<T>(data);
	}

	public static <T> Response<T> ok(String message) {
		return new Response<T>(200, "ok", message);
	}

	public static <T> Response<T> error(String status, String code, T message) {
		return new Response<T>(20000, status, code, message);
	}

	public static <T> Response<T> error(Collection<FieldError> errors) {
		Response<T> resp = new Response<T>();
		resp.status = 250;
		resp.code = "filed error";
		resp.message = "数据校验失败！";
		resp.errors = errors;
		return resp;
	}

	public static <T> Response<T> uploadError(Collection<FieldError> errors) {
		Response<T> resp = new Response<T>();
		resp.status = 250;
		resp.code = "upload_error";
		resp.message = "图片上传错误！";
		resp.errors = errors;
		return resp;
	}

}
