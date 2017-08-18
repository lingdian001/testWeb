package com.zyc.sys.base.exception.base;

public class BaseException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}
	public BaseException(String message) {
		super(message);
		this.errorMessage = message;
	}
	public BaseException(String errorCode,String message) {
		super(message);
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	protected String errorCode;
	protected String errorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
