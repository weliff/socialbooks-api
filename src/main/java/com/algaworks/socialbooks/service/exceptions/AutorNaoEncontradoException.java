package com.algaworks.socialbooks.service.exceptions;

public class AutorNaoEncontradoException extends NaoEncontradoException {

	private static final long serialVersionUID = 646426053783047210L;

	public AutorNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public AutorNaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
