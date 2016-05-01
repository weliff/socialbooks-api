package com.algaworks.socialbooks.service.exceptions;

public class NaoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1779651876533647509L;

	public NaoEncontradoException(String msg) {
		super(msg);
	}
	
	public NaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
