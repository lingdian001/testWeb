package com.zyc.sys.base.exception;

import com.zyc.sys.base.exception.base.BaseException;

public class SysException extends BaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SysException() {
		super();
	}
	public SysException(String message) {
		super(message);
		this.errorMessage = message;
	}
	public SysException(String errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public SysException(Throwable cause) {
		super(cause);
	}

	public SysException(String message, Throwable cause) {
		super(message, cause);
		this.errorMessage = message;
	}

}
