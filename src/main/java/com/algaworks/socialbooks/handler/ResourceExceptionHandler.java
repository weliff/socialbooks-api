package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.service.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.service.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(NaoEncontradoException e, HttpServletRequest request) {
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(Long.valueOf(HttpStatus.NOT_FOUND.value()));
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e, HttpServletRequest request) {
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(Long.valueOf(HttpStatus.CONFLICT.value()));
		erro.setTitulo("Autor já exite!");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
}
