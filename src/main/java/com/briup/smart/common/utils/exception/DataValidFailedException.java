package com.briup.smart.common.utils.exception;

import java.util.Collection;
import java.util.HashSet;

import com.briup.smart.web.vm.FieldError;

public class DataValidFailedException extends RuntimeException{
	private static final long serialVersionUID = -8782712732128501744L;
	private Collection<FieldError> errors = new HashSet<>();
	public Collection<FieldError> getErrors() {
		return errors;
	}
	public DataValidFailedException(FieldError error){
		errors.add(error);
	}
	public DataValidFailedException(Collection<FieldError> errors) {
		this.errors = errors;
	}
	public DataValidFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataValidFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataValidFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataValidFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataValidFailedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
