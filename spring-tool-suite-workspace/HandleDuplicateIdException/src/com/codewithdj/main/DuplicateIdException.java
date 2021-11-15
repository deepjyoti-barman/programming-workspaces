package com.codewithdj.main;

class DuplicateIdException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicateIdException() {
		super();
	}
	
	public DuplicateIdException(String message) {
		super(message);
	}
	
	public DuplicateIdException(Throwable cause) {
		super(cause);
	}
	
	public DuplicateIdException(String message, Throwable cause) {
		super(message, cause);
	}
}
