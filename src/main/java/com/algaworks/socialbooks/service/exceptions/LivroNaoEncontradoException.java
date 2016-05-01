package com.algaworks.socialbooks.service.exceptions;

public class LivroNaoEncontradoException extends NaoEncontradoException {

	private static final long serialVersionUID = 646426053783047210L;

	public LivroNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public LivroNaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
