package com.algaworks.socialbooks.service.exceptions;

public class AutorExistenteException extends RuntimeException {

	private static final long serialVersionUID = 646426053783047210L;

	public AutorExistenteException(String msg) {
		super(msg);
	}
	
	public AutorExistenteException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
