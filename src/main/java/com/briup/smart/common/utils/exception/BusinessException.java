package com.briup.smart.common.utils.exception;

public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException() {}
	
	public BusinessException(String message) {
		super(message);
	}

}
