package com.briup.smart.common.utils.exception;


import java.util.Collection;
import java.util.HashSet;

import org.apache.ibatis.javassist.SerialVersionUID;

import com.briup.smart.web.vm.FieldError;

public class UploadImageException extends RuntimeException{

	private static final long serialVersionUID = 416114180271606816L;
	private Collection<FieldError> errors=new HashSet<>();
	
	public Collection<FieldError> getErrors() {
		return errors;
	}

	public UploadImageException() {
	}
	
	public UploadImageException(Collection<FieldError> errors){
		this.errors=errors;
	}

}
